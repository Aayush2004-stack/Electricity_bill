package bastolaaayush.com.np.billing.controller;

import bastolaaayush.com.np.billing.calculation.BillCalculation;

import bastolaaayush.com.np.billing.model.BillRecord;
import bastolaaayush.com.np.billing.model.Customer;
import bastolaaayush.com.np.billing.service.BillRecordService;
import bastolaaayush.com.np.billing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public String generateBill(@RequestParam String customerName,
                               @RequestParam int houseNumber,
                               @RequestParam double unitsConsumed) {

        Customer customer = new Customer(customerName, houseNumber, unitsConsumed);
        Optional<Customer> optionalCustomer = customerService.getCustomerIdByNameAndHouseNumber(customer);
        int customerId= optionalCustomer.orElseThrow(()-> new RuntimeException("Customer not found")
        ).getCustomerId();
        double billAmount = billCalculation.calculateBill(unitsConsumed);

        BillRecord bill =new BillRecord(customerId, billAmount);
        if(billRecordService.insertBillRecord(bill)){
            return "Calculated successfully";
        }
        return "Error calculating";

    }

    @GetMapping("/bills")
    public List<BillRecord> getAllBillRecords() {
        return billRecordService.getAllBillRecords();
    }

    @GetMapping("highestBill")
    public BillRecord getHighestPayingCustomer(){
        return billRecordService.getHighestPayingCustomer();
    }
}
