package bastolaaayush.com.np.billing.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String customerName;
    private int houseNumber;
    private double unitsConsumed;

    public Customer() {
    }

    public Customer(int customerId, String customerName, int houseNumber, double unitsConsumed){
        this.customerId = customerId;
        this.customerName = customerName;
        this.houseNumber = houseNumber;
        this.unitsConsumed = unitsConsumed;
    }

    public Customer(String customerName, int houseNumber, double unitsConsumed){
        this.customerName = customerName;
        this.houseNumber = houseNumber;
        this.unitsConsumed = unitsConsumed;
    }



    public int getCustomerId(){
        return customerId;
    }

    public String getCustomerName(){
        return customerName;
    }

    public int getHouseNumber(){
        return houseNumber;
    }

    public double getUnitsConsumed(){
        return unitsConsumed;
    }


}
