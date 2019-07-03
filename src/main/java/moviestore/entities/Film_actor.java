package moviestore.entities;

import java.time.LocalDateTime;
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
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @ManyToOne
    @MapsId("actor_id")
    @JoinColumn(name = "actor_id")
    private Actor actor; //PK 
    @Id
    @ManyToOne
    @MapsId("film_id")
    @JoinColumn(name = "film_id")
    private Film film; //PK 
    private LocalDateTime last_update;   

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
