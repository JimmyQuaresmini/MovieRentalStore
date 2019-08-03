package moviestore.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import moviestore.entities.Actor;
import moviestore.entities.Film;
import moviestore.entities.Film_actor;
import moviestore.services.Film_actorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jimmy
 */

@RestController
@RequestMapping("/filmActor")
public class Film_actorController {    
    @Autowired
    private Film_actorService film_actorService;
    
    @GetMapping("/all")
    public Iterable<Film_actor> getAllActors() { 
        return film_actorService.getAllFilmActors();
    }
    
    @GetMapping("/add")
    public String addFilm_actor(@RequestParam Actor actor, @RequestParam Film film,
            @RequestParam LocalDateTime updated) {         
        film_actorService.saveFilmActor(actor, film, updated);
        return "Saved film_actor";
    }
    
    @GetMapping(value = {"/findActTitleByYear/", "/findActTitleByYear/{year}"}) 
    public @ResponseBody List<String> findActorTitleByYear(@PathVariable Optional<Short> year) {         
        return film_actorService.findActorTitleByYear(year); 
    }
    
    @GetMapping("/findActTitleById/{id}")
    public @ResponseBody List<String> findActorTitleById(@PathVariable("id") int id) {         
        return film_actorService.findActorTitleById(id); 
    }
    
    @GetMapping("/findActsFilmsByIdJoined/{id}")
    public @ResponseBody List<Object> findActorsFilmsByIdJoined(@PathVariable("id") int id) {         
        return film_actorService.findActorsFilmsByIdJoined(id);
    }
}
