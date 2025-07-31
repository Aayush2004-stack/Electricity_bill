package bastolaaayush.com.np.billing.repositories;

import bastolaaayush.com.np.billing.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
