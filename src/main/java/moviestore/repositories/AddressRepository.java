package moviestore.repositories;

import moviestore.entities.Address;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jimmy
 */

public interface AddressRepository extends CrudRepository<Address, Integer> {
    
}
