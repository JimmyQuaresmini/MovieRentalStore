package moviestore.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author Jimmy
 */

@Entity
@IdClass(Film_actorPK.class)
public class Film_actor {
    @Id
    @Column(name = "film_id", insertable = false, updatable = false)
    private int film_id;
    
    @Id
    @Column(name = "actor_id", insertable = false, updatable = false)
    private int actor_id;
    
    @ManyToOne
    @MapsId("actor_id")
    @JsonBackReference
    @JoinColumn(name = "actor_id")
    private Actor actor; //PK, FK 
    
    @ManyToOne
    @MapsId("film_id")
    @JsonBackReference
    @JoinColumn(name = "film_id")
    private Film film; //PK, FK 
    private LocalDateTime last_update;   

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }    
    
    public Actor getActor() { 
        return actor; 
    }

    public void setActor(Actor actor) { 
        this.actor = actor; 
    }

    public Film getFilm() { 
        return film; 
    }

    public void setFilm(Film film) { 
        this.film = film; 
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
}
