package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Actor;
import moviestore.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jimmy
 */

@Controller
@RequestMapping(path="/actor")
public class ActorController {
    @Autowired
    private ActorRepository actorRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Actor> getAllActors() { 
        return actorRepository.findAll();
    }
    
    @GetMapping(path="/add")
    public @ResponseBody String addActor(@RequestParam int id, @RequestParam String fName,
            @RequestParam String lName, @RequestParam LocalDateTime updated) {
        Actor a = new Actor();
        a.setActor_id(id);
        a.setFirst_name(fName);
        a.setLast_name(lName);
        a.setLast_update(updated);
        actorRepository.save(a);
        return "Saved actor";
    }
    
}