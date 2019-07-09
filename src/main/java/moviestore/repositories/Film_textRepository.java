package moviestore.repositories;

import moviestore.entities.Film_text;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface Film_textRepository extends CrudRepository<Film_text, Integer> {
    
}
