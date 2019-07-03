package moviestore.repositories;

import moviestore.entities.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jimmy
 */

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    
}
