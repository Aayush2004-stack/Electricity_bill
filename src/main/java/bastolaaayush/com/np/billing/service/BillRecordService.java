package bastolaaayush.com.np.billing.service;

import bastolaaayush.com.np.billing.model.BillRecord;
import bastolaaayush.com.np.billing.repositories.BillRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillRecordService {

    @Autowired
    BillRecordRepository billRecordRepository;
    public boolean insertBillRecord(BillRecord bill){
        billRecordRepository.save(bill);
        return true;
    }

    public List<BillRecord> getAllBillRecords() {
        return billRecordRepository.findAll();
    }

    public BillRecord getHighestPayingCustomer() {
        return billRecordRepository.findTopByOrderByBillAmountDesc();
    }
}
