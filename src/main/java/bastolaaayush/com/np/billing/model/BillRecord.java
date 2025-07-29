package bastolaaayush.com.np.billing.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "billRecord")
public class BillRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;

    private int customerId;
    private double billAmount;

    @Temporal(TemporalType.DATE)
    @Column(name = "billDate", insertable = false, updatable = false)
    private Date billDate;

    public BillRecord() {
    }

    public BillRecord(int customerId, double billAmount) {
        this.customerId = customerId;
        this.billAmount = billAmount;
    }


    public int getBillId() {
        return billId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public Date getBillDate() {
        return billDate;
    }
    public double getBillAmount() {
        return billAmount;
    }


}
