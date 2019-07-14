package moviestore.entities;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Jimmy
 */

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int actor_id;
    //@Size(max =
    private String first_name;    
    private String last_name;    
    @OneToMany(mappedBy = "actor")
    private Set<Film_actor> film_actors;
    //@Temporal(TemporalType
    private LocalDateTime last_update;

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }   

    public Set<Film_actor> getFilm_actors() {
        return film_actors;
    }

    public void setFilm_actors(Set<Film_actor> film_actors) {
        this.film_actors = film_actors;
    }
    
    
    
        
    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
}
