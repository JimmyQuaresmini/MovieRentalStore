package moviestore.controllers;

import java.time.LocalDateTime;
import moviestore.entities.Category;
import moviestore.entities.Film;
import moviestore.entities.Film_category;
import moviestore.services.Film_categoryService;
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
@RequestMapping("/filmCategory")
public class Film_categoryController {    
    @Autowired
    private Film_categoryService film_categoryService;
    
    @GetMapping("/all")
    public Iterable<Film_category> getAllFilmCategories() { 
        return film_categoryService.getAll();
    }
    
    @GetMapping("/add")
    public String addFilm_category(@RequestParam Category category, @RequestParam Film film,
            @RequestParam LocalDateTime updated) {         
        film_categoryService.saveFilm_category(category, film, updated);
        return "Saved film_category";
    }
}
