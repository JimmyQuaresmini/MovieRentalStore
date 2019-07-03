package moviestore.repositories;

import moviestore.entities.City;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jimmy
 */

public interface CityRepository extends CrudRepository<City, Integer> {
    
}
