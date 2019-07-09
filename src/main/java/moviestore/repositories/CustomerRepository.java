package moviestore.repositories;

import moviestore.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    
}
