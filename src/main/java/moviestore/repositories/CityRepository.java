package moviestore.repositories;

import moviestore.entities.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
    
}
