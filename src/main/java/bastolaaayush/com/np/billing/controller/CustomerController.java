package bastolaaayush.com.np.billing.controller;


import bastolaaayush.com.np.billing.model.Customer;
import bastolaaayush.com.np.billing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;




    @PostMapping
    public boolean addCustomer(@RequestParam String customerName, @RequestParam int houseNumber,@RequestParam double unitsConsumed){
        Customer customer = new Customer(customerName, houseNumber, unitsConsumed);
        return customerService.insertCustomer(customer);
    }

    @GetMapping("/all")
    public String getAllCustomers(Model model){
        model.addAttribute("customer", customerService.getAllCustomers());
        return "customerRecords";
    }

    @GetMapping("/id")
    public int getCustomerId(@RequestParam String customerName, @RequestParam int houseNumber, @RequestParam double unitsConsumed) {
        Customer customer=new Customer(customerName,houseNumber,unitsConsumed);
        Optional<Customer> optionalCustomer =customerService.getCustomerIdByNameAndHouseNumber(customer);
        return optionalCustomer
                .orElseThrow(() -> new RuntimeException("Customer not found"))
                .getCustomerId();
    }
}
