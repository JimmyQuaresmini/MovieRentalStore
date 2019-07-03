package moviestore.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Jimmy
 */

public class Film_actorPK implements Serializable {    
    protected Actor actor; 
    protected Film film; 
    
    public Film_actorPK() {
        
    }
    
    public Film_actorPK(Actor actor, Film film) {         
        this.actor = actor;
        this.film = film;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.actor);
        hash = 17 * hash + Objects.hashCode(this.film);
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
        if (this.actor != other.actor) { 
            return false;
        }
        if (this.film != other.film) { 
            return false;
        }
        return true;
    }
    
    
}
