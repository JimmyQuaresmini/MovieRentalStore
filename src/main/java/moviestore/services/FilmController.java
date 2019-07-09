package moviestore.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import moviestore.entities.Film;
import moviestore.entities.Language;
import moviestore.entities.Rating;
import moviestore.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jimmy
 */

@Controller
@RequestMapping("/film") 
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;
    
    @GetMapping("/all") 
    public String getAllFilms(Model model) { 
        Iterable<Film> itFilms = filmRepository.findAll();
        model.addAttribute("movies", itFilms);
        return "films"; 
    }
    
    @GetMapping(path="/add")
    public @ResponseBody String addFilm(@RequestParam int id, @RequestParam String title,
            @RequestParam String description, @RequestParam short releaseYear,            
            @RequestParam Language language, @RequestParam Language originalLang,
            @RequestParam short rentalDuration, @RequestParam float rentalRate,
            @RequestParam int length, @RequestParam float replacementCost,
            @RequestParam Rating rating, @RequestParam String specialFeatures, 
            @RequestParam LocalDateTime updated) {
        Film f = new Film();
        f.setFilm_id(id);
        f.setTitle(title);
        f.setDescription(description);
        f.setRelease_year(releaseYear);
        f.setLanguage(language); 
        f.setLanguage2(originalLang);
        f.setRental_duration(rentalDuration);
        f.setRental_rate(rentalRate);
        f.setLength(length);
        f.setReplacement_cost(replacementCost);
        f.setRating(rating);
        f.setSpecial_features(specialFeatures);
        f.setLast_update(updated);
        filmRepository.save(f);
        return "Saved film";
    }
    
    @GetMapping(path="/find/{id}")
    public @ResponseBody Film findFilm(@PathVariable("id") int filmId) {
        Optional<Film> f = filmRepository.findById(filmId);
        if (f.isPresent() == true) {
            Film film = f.get();
            return film;
        }
        else {
            Film film = new Film();
            return film;
        }
    }
    
    @GetMapping(path="/findTitle/{id}")
    public @ResponseBody String findTitle(@PathVariable("id") int filmId) {
        return filmRepository.findTitleById(filmId);
    }
                
    @GetMapping(path="/edit/{id}") 
    public String editFilm(@PathVariable("id") int id, Model model) { 
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid film id: " + id));
        
        model.addAttribute("film", film);
        return "updateFilm";
    }
    
    @PostMapping(path="/update/{id}") 
    public String updateFilm(@PathVariable("id") int id, @Valid Film film, 
            BindingResult result, Model model) {
        if (result.hasErrors() == true) {
            film.setFilm_id(id);
            return "updateFilm";
        }
        
        //store, address, create_date are not updated here
        
        film.setLast_update(LocalDateTime.now());
        filmRepository.save(film);
        model.addAttribute("films", filmRepository.findAll());
        return "films";
    }
    
    @GetMapping(path="/delete/{id}") 
    public String deleteFilm(@PathVariable("id") int id, Model model) { 
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid film id: " + id));
        filmRepository.delete(film);
        model.addAttribute("films", filmRepository.findAll());
        return "films";
    }
            
    //temporärt
    /*@GetMapping(path="/findFilmCatsByIdJoined/{id}")
    public @ResponseBody List<String> findFilmCategoriesByIdJoined(@PathVariable("id") int id) { 
        List<String> itFilms = filmRepository.findFilmCategoriesByIdJoined(id);
        return itFilms; //Object
    }*/
    
    /*@GetMapping(path="/findFilmsInnerJoinedActors")
    public @ResponseBody List<Object> findFilmsInnerJoinedActors() { //String
        return filmRepository.findFilmsInnerJoinedActors();
    }*/
    
    @GetMapping(path="/findActorsInFilmsInnerJoined")//not working currently
    public @ResponseBody List<Object> findActorsInFilmsInnerJoined() { //String
        return filmRepository.findActorsInFilmsInnerJoinedExplicit();
    }
}
