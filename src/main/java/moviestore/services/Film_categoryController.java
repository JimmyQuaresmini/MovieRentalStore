package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Category;
import moviestore.entities.Film;
import moviestore.entities.Film_category;
import moviestore.repositories.Film_categoryRepository;
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
@RequestMapping(path="/filmCategory")
public class Film_categoryController {
    @Autowired
    private Film_categoryRepository film_categoryRepository;
    
    @GetMapping(path="/all")
    public Iterable<Film_category> getAllFilmCategories() { 
        return film_categoryRepository.findAll();
    }
    
    @GetMapping(path="/add")
    public String addFilm_category(@RequestParam Category category, @RequestParam Film film,
            @RequestParam LocalDateTime updated) { 
        Film_category fc = new Film_category();
        fc.setCategory(category); 
        fc.setFilm(film); 
        fc.setLast_update(updated);
        film_categoryRepository.save(fc);
        return "Saved film_category";
    }
}
