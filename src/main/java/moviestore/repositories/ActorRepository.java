package moviestore.repositories;

import moviestore.entities.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {
    
}
