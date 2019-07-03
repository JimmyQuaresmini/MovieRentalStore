package moviestore.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import moviestore.entities.Film;
import moviestore.entities.Language;
import moviestore.entities.Rating;
import moviestore.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping(path="/findActTitleByYear/{year}")
    public @ResponseBody List<Film> findActorTitleByYear(@PathVariable("year") short year) {
        List<Film> itFilms = filmRepository.findActorTitleByYear(year);
        return itFilms;
    }
    
    @GetMapping(path="/findActTitleById/{id}")
    public @ResponseBody List<String> findActorTitleById(@PathVariable("id") int id) { 
        List<String> itFilms = filmRepository.findActorTitleById(id);
        return itFilms; 
    }
}
