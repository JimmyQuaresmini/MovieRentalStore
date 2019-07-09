package moviestore.repositories;

import moviestore.entities.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface RentalRepository extends CrudRepository<Rental, Integer> {
    
}
