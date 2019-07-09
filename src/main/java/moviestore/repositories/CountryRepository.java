package moviestore.repositories;

import moviestore.entities.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
    
}
