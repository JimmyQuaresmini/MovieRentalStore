package moviestore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Over 4,500 stored
 * @author Jimmy
 */

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int inventory_id;
    @ManyToOne(fetch=FetchType.LAZY, optional=false) //insertable, updatable(false both)
    @JoinColumn(name="film_id", referencedColumnName="film_id") //unique=true, 
    private Film film; 
    @ManyToOne    
    @JoinColumn(name="store_id", referencedColumnName="store_id") //unique=true, 
    private Store store; 
    private LocalDateTime last_update;

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Film getFilm() { 
        return film; 
    }

    public void setFilm(Film film) { 
        this.film = film; 
    }

    public Store getStore() { 
        return store; 
    }

    public void setStore(Store store) { 
        this.store = store; 
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }    
}
