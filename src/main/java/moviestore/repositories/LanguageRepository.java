package moviestore.repositories;

import moviestore.entities.Language;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jimmy
 */

public interface LanguageRepository extends CrudRepository<Language, Integer> {
    
}
