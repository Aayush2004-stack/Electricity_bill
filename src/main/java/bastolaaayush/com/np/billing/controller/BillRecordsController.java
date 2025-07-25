package bastolaaayush.com.np.billing.controller;

import bastolaaayush.com.np.billing.calculation.BillCalculation;

import bastolaaayush.com.np.billing.model.BillRecord;
import bastolaaayush.com.np.billing.service.BillRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/billRecord")
public class BillRecordsController {

    @Autowired
    private BillRecordService billRecordService;

    @Autowired
    private BillCalculation billCalculation;

    @PostMapping ("/bill")
    public boolean generateBill(@RequestParam int customerId, @RequestParam double unitsConsumed) {
        double billAmount = billCalculation.calculateBill(unitsConsumed);
        BillRecord bill =new BillRecord(customerId, billAmount);
        return billRecordService.insertBillRecord(bill);

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
