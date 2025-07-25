package bastolaaayush.com.np.billing.service;

import bastolaaayush.com.np.billing.model.Customer;
import bastolaaayush.com.np.billing.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public boolean insertCustomer(Customer customer){
        customerRepository.save(customer);
        return true;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Optional<Customer> getCustomerIdByNameAndHouseNumber(Customer customer) {
        return customerRepository.findByCustomerNameAndHouseNumber(customer.getCustomerName(), customer.getHouseNumber());
    }


}
