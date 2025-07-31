package bastolaaayush.com.np.billing.controller;

import bastolaaayush.com.np.billing.calculation.BillCalculation;

import bastolaaayush.com.np.billing.model.BillRecord;
import bastolaaayush.com.np.billing.model.Customer;
import bastolaaayush.com.np.billing.service.BillRecordService;
import bastolaaayush.com.np.billing.service.CustomerService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/billRecord")
public class BillRecordsController {

    @Autowired
    private BillRecordService billRecordService;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private BillCalculation billCalculation;

    @GetMapping("/generateBill")
    public String generateBill(@RequestParam double unitsConsumed, HttpSession session) {


        double billAmount = billCalculation.calculateBill(unitsConsumed);

        Customer customer=(Customer) session.getAttribute("customer");
        BillRecord bill =new BillRecord();
        bill.setBillAmount(billAmount);
        bill.setCustomer(customer);
        if(billRecordService.insertBillRecord(bill)){
            return "success";
        }
        return "Error calculating";
    }

    @GetMapping("/bills")
    public String getAllBillRecords(Model model) {
        model.addAttribute("bills",billRecordService.getAllBillRecords());
        return "bills";
    }

//    @GetMapping("/highestBill")
//    public String getHighestPayingCustomer(Model model){
//        model.addAttribute("highestBill",billRecordService.getHighestPayingCustomer());
//        return "bills";
//    }
}
