package moviestore.repositories;

import moviestore.entities.Store;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jimmy
 */

public interface StoreRepository extends CrudRepository<Store, Integer> {
    
}
