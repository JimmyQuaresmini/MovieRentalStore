package moviestore.repositories;

import moviestore.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
    
}
