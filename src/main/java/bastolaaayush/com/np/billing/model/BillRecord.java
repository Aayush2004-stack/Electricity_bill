package bastolaaayush.com.np.billing.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "billRecord")
public class BillRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;

    private int customerId;
    private LocalDate billDate;
    private double billAmount;

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
    public LocalDate getBillDate() {
        return billDate;
    }
    public double getBillAmount() {
        return billAmount;
    }


}
