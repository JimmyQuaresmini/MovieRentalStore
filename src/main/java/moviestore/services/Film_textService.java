package moviestore.services;

import moviestore.entities.Film_text;
import moviestore.repositories.Film_textRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class Film_textService {
    @Autowired
    private Film_textRepository film_textRepository;
    
    public Iterable<Film_text> getAll() {
        return film_textRepository.findAll();
    }
    
    public void saveFilm_text(int id, String title, String description) {
        Film_text ft = new Film_text();
        ft.setFilm_id(id);
        ft.setTitle(title);        
        ft.setDescription(description);
        film_textRepository.save(ft);
    }
}
