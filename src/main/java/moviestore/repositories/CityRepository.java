package moviestore.repositories;

import moviestore.entities.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
    @Query("SELECT c FROM City c WHERE c.city = :cityName")
    City findCityByName(@Param("cityName") String cityName);
}
