package moviestore.services;

import java.time.LocalDateTime;
import java.util.List;
import moviestore.entities.Actor;
import moviestore.entities.Film;
import moviestore.entities.Film_actor;
import moviestore.repositories.Film_actorRepository;
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
@RequestMapping(path="/filmActor")
public class Film_actorController {
    @Autowired
    private Film_actorRepository film_actorRepository;
    
    @GetMapping(path="/all")
    public Iterable<Film_actor> getAllActors() { 
        return film_actorRepository.findAll();
    }
    
    @GetMapping(path="/add")
    public String addFilm_actor(@RequestParam Actor actor, @RequestParam Film film,
            @RequestParam LocalDateTime updated) { 
        Film_actor fa = new Film_actor();
        fa.setActor(actor); 
        fa.setFilm(film); 
        fa.setLast_update(updated);
        film_actorRepository.save(fa);
        return "Saved film_actor";
    }
    
    @GetMapping(path="/findActTitleByYear/{year}")
    public @ResponseBody List<String> findActorTitleByYear(@PathVariable("year") short year) { 
        List<String> itFilms = film_actorRepository.findActorTitleByYear(year);
        return itFilms; 
    }
    
    @GetMapping(path="/findActTitleById/{id}")
    public @ResponseBody List<String> findActorTitleById(@PathVariable("id") int id) { 
        List<String> itFilms = film_actorRepository.findActorTitleById(id);
        return itFilms; 
    }
    
    @GetMapping(path="/findActsFilmsByIdJoined/{id}")
    public @ResponseBody List<Object> findActorsFilmsByIdJoined(@PathVariable("id") int id) { 
        List<Object> itFilms = film_actorRepository.findActorsFilmsByIdJoined(id);
        return itFilms; 
    }
}
