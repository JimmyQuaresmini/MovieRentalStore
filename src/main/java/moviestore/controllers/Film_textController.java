package moviestore.controllers;

import moviestore.entities.Film_text;
import moviestore.services.Film_textService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jimmy
 */

@RestController
@RequestMapping("/filmText")
public class Film_textController {    
    @Autowired
    private Film_textService film_textService;
    
    @GetMapping("/all")
    public Iterable<Film_text> getAllFilmTexts() { 
        return film_textService.getAll();
    }
    
    @GetMapping("/add")
    public String addFilm_text(@RequestParam int id, @RequestParam String title,
            @RequestParam String description) {
        film_textService.saveFilm_text(id, title, description);
        return "Saved film_text";
    }
}
