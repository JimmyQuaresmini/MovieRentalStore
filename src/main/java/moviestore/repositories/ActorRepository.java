package moviestore.repositories;

import moviestore.entities.Actor;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jimmy
 */

public interface ActorRepository extends CrudRepository<Actor, Integer> {
    
}
