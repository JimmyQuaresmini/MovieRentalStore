package moviestore.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Jimmy
 */

public class Film_catPK implements Serializable {
    protected Film film; 
    protected Category category; 
    
    public Film_catPK() {
        
    }
    
    public Film_catPK(Film film, Category category) {         
        this.film = film;
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.film); 
        hash = 37 * hash + Objects.hashCode(this.category); 
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
        final Film_catPK other = (Film_catPK) obj;
        if (this.film != other.film) { 
            return false;
        }
        if (this.category != other.category) { 
            return false;
        }
        return true;
    }    
}
