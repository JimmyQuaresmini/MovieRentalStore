package moviestore.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Jimmy
 */

@Embeddable
public class Film_catPK implements Serializable {
    private int film_id; 
    private int category_id; 
    
    public Film_catPK() {
        
    }

    public Film_catPK(int film_id, int category_id) {
        this.film_id = film_id;
        this.category_id = category_id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.film_id;
        hash = 29 * hash + this.category_id;
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
        if (this.film_id != other.film_id) {
            return false;
        }
        if (this.category_id != other.category_id) {
            return false;
        }
        return true;
    }    
        
}
