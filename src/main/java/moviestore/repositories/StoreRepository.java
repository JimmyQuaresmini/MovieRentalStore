package moviestore.repositories;

import moviestore.entities.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {
    
}
