package moviestore.repositories;

import moviestore.entities.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jimmy
 */

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    
}
