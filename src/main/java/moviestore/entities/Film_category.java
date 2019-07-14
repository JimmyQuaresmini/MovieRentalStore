package moviestore.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name = "film_id", insertable = false, updatable = false)
    private int film_id;
    
    @Id
    @Column(name = "category_id", insertable = false, updatable = false)
    private int category_id;
    
    @ManyToOne
    @JsonBackReference //to prevent recursive issue
    @JoinColumn(name="film_id", referencedColumnName="film_id")
    private Film film; 
        
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="category_id", referencedColumnName="category_id")
    private Category category; 
    private LocalDateTime last_update;

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    
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
