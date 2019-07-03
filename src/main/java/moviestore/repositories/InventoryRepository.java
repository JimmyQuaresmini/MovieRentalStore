package moviestore.repositories;

import moviestore.entities.Inventory;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jimmy
 */

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
    
}
