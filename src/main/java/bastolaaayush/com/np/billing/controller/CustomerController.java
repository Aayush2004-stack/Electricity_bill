package bastolaaayush.com.np.billing.controller;


import bastolaaayush.com.np.billing.model.Customer;
import bastolaaayush.com.np.billing.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private HttpSession session;

    @PostMapping
    public String addCustomer(@RequestParam String customerName, @RequestParam int houseNumber,@RequestParam double unitsConsumed){
        Customer customer = new Customer(customerName, houseNumber, unitsConsumed);
        if (customerService.insertCustomer(customer)){
            session.setAttribute("customer", customer);


            return "redirect:/billRecord/generateBill?unitsConsumed=" + unitsConsumed;
        }
        else{
            return "Error inserting";
        }
    }

    @GetMapping("/all")
    public String getAllCustomers(Model model){
        model.addAttribute("customer", customerService.getAllCustomers());
        return "customerRecords";
    }

}
