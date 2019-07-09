package moviestore.repositories;

import moviestore.entities.Film_catPK;
import moviestore.entities.Film_category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface Film_categoryRepository extends CrudRepository<Film_category, Film_catPK> {
    
}
