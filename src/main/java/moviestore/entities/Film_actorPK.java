package moviestore.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Jimmy
 */

@Embeddable
public class Film_actorPK implements Serializable {    
    private int actor_id; 
    private int film_id; 
    
    public Film_actorPK() {
        
    }

    public Film_actorPK(int actor_id, int film_id) {
        this.actor_id = actor_id;
        this.film_id = film_id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.actor_id;
        hash = 29 * hash + this.film_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Film_actorPK other = (Film_actorPK) obj;
        if (this.actor_id != other.actor_id) {
            return false;
        }
        if (this.film_id != other.film_id) {
            return false;
        }
        return true;
    }
            
}
