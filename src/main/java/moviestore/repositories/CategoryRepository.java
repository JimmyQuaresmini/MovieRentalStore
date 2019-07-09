package moviestore.repositories;

import moviestore.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    
}
