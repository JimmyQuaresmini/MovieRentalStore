package moviestore.repositories;

import moviestore.entities.Rental;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jimmy
 */

public interface RentalRepository extends CrudRepository<Rental, Integer> {
    
}
