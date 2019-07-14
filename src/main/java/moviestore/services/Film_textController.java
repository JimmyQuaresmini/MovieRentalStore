package moviestore.services;

import moviestore.entities.Film_text;
import moviestore.repositories.Film_textRepository;
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
    private Film_textRepository film_textRepository;
    
    @GetMapping("/all")
    public Iterable<Film_text> getAllFilmTexts() { 
        return film_textRepository.findAll();
    }
    
    @GetMapping("/add")
    public String addFilm_text(@RequestParam int id, @RequestParam String title,
            @RequestParam String description) {
        Film_text ft = new Film_text();
        ft.setFilm_id(id);
        ft.setTitle(title);        
        ft.setDescription(description);
        film_textRepository.save(ft);
        return "Saved film_text";
    }
}
