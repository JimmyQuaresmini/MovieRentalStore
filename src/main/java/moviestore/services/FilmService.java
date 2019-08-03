package moviestore.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import moviestore.entities.Film;
import moviestore.entities.Inventory;
import moviestore.entities.Language;
import moviestore.repositories.FilmRepository;
import moviestore.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;
    
    @Autowired
    private LanguageRepository languageRepository;
    
    public Iterable<Film> getAllFilms() {
        Iterable<Film> itFilms = filmRepository.findAll();
        return itFilms;
    }
    
    public void saveFilm(int id, String title, String description, Short releaseYear, //Date
            Language language, Language originalLang, Short rentalDuration, BigDecimal rentalRate, //float
            Short length, BigDecimal replacementCost, //int //float
            String rating, String specialFeatures, //Rating
            LocalDateTime updated, Set<Inventory> inventories) {
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
        f.setInventories(inventories);
        filmRepository.save(f);
    }
    
    public void saveFilmShort(String title, Language language, Short rentalDuration, BigDecimal rentalRate, 
            BigDecimal replacementCost, LocalDateTime updated) {
        Film f = new Film();        
        f.setTitle(title);        
        f.setLanguage(language);
        f.setRental_duration(rentalDuration);
        f.setRental_rate(rentalRate);
        f.setReplacement_cost(replacementCost);
        f.setLast_update(updated);
        filmRepository.save(f);
    }
    
    public Film addFilm(String title, String description, Short release_year, 
            String lang, Short rental_duration, BigDecimal rental_rate, 
            Short length, BigDecimal replacement_cost, 
            String rating, String special_features) {
        Language language = languageRepository.findLanguageByName(lang);
        Film f = new Film(title, description, release_year, language, rental_duration, 
                rental_rate, length, replacement_cost, rating, special_features);                                
        filmRepository.save(f);
        return f;
    }
    
    public Film findById(int id) {
        Optional<Film> f = filmRepository.findById(id);
        if (f.isPresent() == true) {
            Film film = f.get();
            return film;
        }
        else {
            Film film = new Film();
            return film;
        }
    }
    
    public Film findByTitle(String title) {
        return filmRepository.findFilmWithTitle(title);
    }
    
    public String findTitleById(int id) {
        return filmRepository.findTitleById(id);
    }
    
    public void saveFilmWithFilm(Film film) {
        filmRepository.save(film);
    }
    
    public void deleteFilm(Film film) {
        filmRepository.delete(film);
    }
    
    public List<Object> findActorsInFilmsInnerJoined() {
        return filmRepository.findActorsInFilmsInnerJoinedExplicit();
    }
    
    public Set<Inventory> findInventoriesById(int id) {
        return filmRepository.findInventoriesByFilmId(id);
    }
    
    //temporary - both were in FilmController before with...
    //"@GetMapping("/findFilmCatsByIdJoined/{id}")"
    //"@ResponseBody "
    //...for the first, and...
    //"@GetMapping("/findFilmsInnerJoinedActors")" for the second
    
    /*public List<String> findFilmCategoriesByIdJoined(@PathVariable("id") int id) { 
        List<String> itFilms = filmRepository.findFilmCategoriesByIdJoined(id);
        return itFilms; //Object
    }*/
    
    /*public List<Object> findFilmsInnerJoinedActors() { //String
        return filmRepository.findFilmsInnerJoinedActors();
    }*/
}
