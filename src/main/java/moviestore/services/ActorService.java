package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Actor;
import moviestore.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;
    
    public Iterable<Actor> getAllActors() {
        Iterable<Actor> itActors = actorRepository.findAll();
        return itActors;
    }
    
    public void saveActor(int id, String fName, String lName, LocalDateTime updated) {
        Actor a = new Actor();
        a.setActor_id(id);
        a.setFirst_name(fName);
        a.setLast_name(lName);
        a.setLast_update(updated);
        actorRepository.save(a);
    }
}
