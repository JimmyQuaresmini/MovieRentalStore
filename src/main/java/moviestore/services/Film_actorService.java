package moviestore.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import moviestore.entities.Actor;
import moviestore.entities.Film;
import moviestore.entities.Film_actor;
import moviestore.repositories.Film_actorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class Film_actorService {
    @Autowired
    private Film_actorRepository film_actorRepository;
    
    public Iterable<Film_actor> getAllFilmActors() {
        return film_actorRepository.findAll();
    }
    
    public void saveFilmActor(Actor actor, Film film, LocalDateTime updated) {
        Film_actor fa = new Film_actor();
        fa.setActor(actor); 
        fa.setFilm(film); 
        fa.setLast_update(updated);
        film_actorRepository.save(fa);
    }
    
    public List<String> findActorTitleByYear(Optional<Short> year) {
        List<String> itFilms = new ArrayList<>();
        if (year.isPresent() == true) {            
            itFilms = film_actorRepository.findActorTitleByYear(year.get()); 
        }
        else if (year.isPresent() == false) {            
            itFilms = film_actorRepository.findActorTitleByYear(Short.valueOf("2006"));
        }
        return itFilms;
    }
    
    public List<String> findActorTitleById(int id) {
        List<String> itFilms = film_actorRepository.findActorTitleById(id);
        return itFilms; 
    }
    
    public List<Object> findActorsFilmsByIdJoined(int id) {
        List<Object> itFilms = film_actorRepository.findActorsFilmsByIdJoined(id);
        return itFilms; 
    }
}
