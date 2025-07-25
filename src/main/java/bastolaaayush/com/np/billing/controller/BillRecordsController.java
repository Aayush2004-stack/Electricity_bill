package bastolaaayush.com.np.billing.controller;

import bastolaaayush.com.np.billing.calculation.BillCalculation;
import bastolaaayush.com.np.billing.dao.BillRecordsDAO;
import bastolaaayush.com.np.billing.model.BillRecords;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billRecord")
public class BillRecordsController {
    private BillRecordsDAO billRecordsDAO = new BillRecordsDAO();
    private BillCalculation billCalculation = new BillCalculation();

    @PostMapping ("/bill")
    public boolean generateBill(@RequestParam int customerId, @RequestParam double unitsConsumed) {
        double bill = billCalculation.calculateBill(unitsConsumed);
        return billRecordsDAO.insertBillRecord(customerId, bill);

    }

    @GetMapping("/bills")
    public List<BillRecords> getAllBillRecords() {
        return billRecordsDAO.getAllBillRecords();
    }

    @GetMapping("highestBill")
    public BillRecords getHighestPayingCustomer(){
        return billRecordsDAO.getHighestPayingCustomer();
    }
}
