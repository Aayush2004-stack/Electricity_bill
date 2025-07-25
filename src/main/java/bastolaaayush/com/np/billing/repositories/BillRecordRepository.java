package bastolaaayush.com.np.billing.repositories;

import bastolaaayush.com.np.billing.model.BillRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillRecordRepository extends JpaRepository<BillRecord, Integer>{

    BillRecord findTopByOrderByBillAmountDesc();
}
