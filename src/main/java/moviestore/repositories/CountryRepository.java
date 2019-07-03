package moviestore.repositories;

import moviestore.entities.Country;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jimmy
 */

public interface CountryRepository extends CrudRepository<Country, Integer> {
    
}
