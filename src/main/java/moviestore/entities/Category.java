package moviestore.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Jimmy
 */

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int category_id;
    private String name;
    
    @OneToMany(mappedBy = "category")
    @JsonManagedReference //to prevent recursive issue combined with ...
    private Set<Film_category> film_categories; //...@JsonBackReference in the other direction
    private LocalDateTime last_update;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Film_category> getFilms() {
        return film_categories;
    }

    public void setFilms(Set<Film_category> films) {
        this.film_categories = films;
    }
    
    
        
    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
}
