package moviestore.repositories;

import moviestore.entities.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer> {
    
}
