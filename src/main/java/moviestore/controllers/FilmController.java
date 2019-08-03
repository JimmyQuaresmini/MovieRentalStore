package moviestore.controllers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;

import moviestore.entities.Film;
import moviestore.entities.Inventory;
import moviestore.entities.Language;
import moviestore.services.FilmService;
import moviestore.services.LanguageService;
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
    private FilmService filmService;
        
    @Autowired
    private LanguageService languageService;
    
    @GetMapping("/all") 
    public String getAllFilms(Model model) { 
        Iterable<Film> itFilms = filmService.getAllFilms();
        model.addAttribute("movies", itFilms);
        return "films"; 
    }
    
    @GetMapping("/add")
    public @ResponseBody String add(@RequestParam int id, @RequestParam String title,
            @RequestParam String description, @RequestParam Short releaseYear, 
            @RequestParam Language language, @RequestParam Language originalLang,
            @RequestParam Short rentalDuration, @RequestParam BigDecimal rentalRate, 
            @RequestParam Short length, @RequestParam BigDecimal replacementCost, 
            @RequestParam String rating, @RequestParam String specialFeatures, 
            @RequestParam LocalDateTime updated, @RequestParam Set<Inventory> inventories) {        
        filmService.saveFilm(id, title, description, releaseYear, language, originalLang, 
                rentalDuration, rentalRate, length, replacementCost, rating, 
                specialFeatures, updated, inventories);
        return "Saved film";
    }
    
    @GetMapping("/addShort")
    public @ResponseBody String addFilmShort(@RequestParam String title,
            @RequestParam Language language, @RequestParam Short rentalDuration, 
            @RequestParam BigDecimal rentalRate, @RequestParam BigDecimal replacementCost, 
            @RequestParam LocalDateTime updated) {
        filmService.saveFilmShort(title, language, rentalDuration, rentalRate, 
                replacementCost, updated);
        return "Saved film with fewer parameters";
    }
    
    @GetMapping("/addFilmPage")
    public String showAddFilmPage(Model model) {
        Film f = new Film();
        model.addAttribute("film", f);
        model.addAttribute("languages", languageService.getAllLanguages());
        return "add-film";
    }
    
    @PostMapping("/addfilm")
    public String addFilm(@RequestParam String title,
            @RequestParam String description, @RequestParam Short release_year, 
            @RequestParam(name="languageRadioBtns") String lang, @RequestParam Short rental_duration, 
            @RequestParam BigDecimal rental_rate, @RequestParam Short length, 
            @RequestParam BigDecimal replacement_cost, @RequestParam(name="ratingRadioBtns") String rating, 
            @RequestParam(name="specialFeatures") String special_features, Model model) {        
        Film f = filmService.addFilm(title, description, release_year, lang, rental_duration, 
                rental_rate, length, replacement_cost, rating, special_features);                                        
        model.addAttribute("film", f);
        model.addAttribute("successMsg", "Saved film with addfilm - few parameters");
        return "add-film"; 
    }
    
    @GetMapping("/find/{id}")
    public @ResponseBody Film findFilm(@PathVariable("id") int filmId) {
        Film f = filmService.findById(filmId);
        return f;
    }
    
    @PostMapping("/find")
    public String findFilmPost(@RequestParam(name = "searchId") int filmId, Model model) {
        Film film = filmService.findById(filmId);        
        model.addAttribute("film", film);
        return "rentFilm";
    }
    
    @GetMapping("/findTitle/{id}")
    public @ResponseBody String findTitle(@PathVariable("id") int filmId) {
        return filmService.findTitleById(filmId);
    }
                        
    @GetMapping("/edit/{id}") 
    public String editFilm(@PathVariable("id") int id, Model model) { 
        Film film = filmService.findById(id);        
        model.addAttribute("film", film);
        return "updateFilm";
    }
    
    @PostMapping("/update/{id}") 
    public String updateFilm(@PathVariable("id") int id, @Valid Film film, 
            BindingResult result, Model model) {
        if (result.hasErrors() == true) {
            film.setFilm_id(id);
            return "updateFilm";
        }
        
        //store, address, create_date are not updated here
        
        film.setLast_update(LocalDateTime.now());
        filmService.saveFilmWithFilm(film);
        model.addAttribute("films", filmService.getAllFilms());
        return "films";
    }
    
    @GetMapping("/delete/{id}") 
    public String deleteFilm(@PathVariable("id") int id, Model model) { 
        Film film = filmService.findById(id);
        filmService.deleteFilm(film);
        model.addAttribute("films", filmService.getAllFilms());
        return "films";
    }    
    
    @GetMapping("/findActorsInFilmsInnerJoined")
    public @ResponseBody List<Object> findActorsInFilmsInnerJoined() { 
        return filmService.findActorsInFilmsInnerJoined();
    }
    
    //this can be called by writing in the title directly
    @GetMapping("/findWithTitle/{title}")
    public @ResponseBody Film findWithTitleGet(@PathVariable("title") String filmTitle) {
        return filmService.findByTitle(filmTitle);
    }
    
    //this can be called from the form in "rentFilm(.html)"
    @PostMapping("/findWithTitle")
    public String findWithTitlePost(@RequestParam(name = "searchTitle") String filmTitle, Model model) {
        Film film = filmService.findByTitle(filmTitle);
        model.addAttribute("film", film);
        return "rentFilm";
    }
                
    @GetMapping("/callRentFilmPage") 
    public String callRentFilmPage(Model model) {
        Film firstFilm = filmService.findById(1);
        model.addAttribute("film", firstFilm);
        return "rentFilm"; 
    }
    
    @GetMapping("/findInventories/{id}")
    public @ResponseBody Set<Inventory> findInventoriesById(@PathVariable("id") int filmId) {
        return filmService.findInventoriesById(filmId);
    }
}
