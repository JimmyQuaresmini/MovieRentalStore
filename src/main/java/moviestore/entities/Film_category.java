package moviestore.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jimmy
 */

@Entity
@IdClass(Film_catPK.class)
public class Film_category {
    @Id
    @ManyToOne    
    @JoinColumn(name="film_id", referencedColumnName="film_id")
    private Film film; 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ManyToOne    
    @JoinColumn(name="category_id", referencedColumnName="category_id")
    private Category category; 
    private LocalDateTime last_update;

    public Film getFilm() { 
        return film; 
    }

    public void setFilm(Film film) { 
        this.film = film; 
    }

    public Category getCategory() { 
        return category; 
    }

    public void setCategory(Category category) { 
        this.category = category; 
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
}
