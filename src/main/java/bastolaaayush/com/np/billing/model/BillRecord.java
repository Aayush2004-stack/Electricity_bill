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

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    private double billAmount;

    @Temporal(TemporalType.DATE)
    @Column(name = "billDate", insertable = false, updatable = false)
    private Date billDate;

    public BillRecord() {
    }

    public int getBillId() {
        return billId;
    }

    public Date getBillDate() {
        return billDate;
    }
    public double getBillAmount() {
        return billAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }
}
