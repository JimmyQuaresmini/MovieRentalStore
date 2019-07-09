package moviestore.repositories;

import moviestore.entities.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
    
}
