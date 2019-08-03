package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Category;
import moviestore.entities.Film;
import moviestore.entities.Film_category;
import moviestore.repositories.Film_categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class Film_categoryService {
    @Autowired
    private Film_categoryRepository film_categoryRepository;
    
    public Iterable<Film_category> getAll() {
        return film_categoryRepository.findAll();
    }
    
    public void saveFilm_category(Category category, Film film, LocalDateTime updated) {
        Film_category fc = new Film_category();
        fc.setCategory(category); 
        fc.setFilm(film); 
        fc.setLast_update(updated);
        film_categoryRepository.save(fc);
    }
}
