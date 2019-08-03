package moviestore.repositories;

import java.util.List;
import moviestore.entities.Language;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer> {
    @Query("SELECT l.name FROM Language l")
    public List<String> findAllLanguageNames();
    
    @Query("SELECT l FROM Language l WHERE name = :lang")
    public Language findLanguageByName(@Param("lang") String lang);
}
