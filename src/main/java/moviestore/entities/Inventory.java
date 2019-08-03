package moviestore.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Over 4,500 stored
 * @author Jimmy
 */

@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "inventory_id")
public class Inventory {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int inventory_id;
    @ManyToOne(optional=false)
    @JsonBackReference
    @JoinColumn(name="film_id", referencedColumnName="film_id") 
    private Film film; 
    @ManyToOne 
    @JsonBackReference
    @JoinColumn(name="store_id", referencedColumnName="store_id") 
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
    
    public Inventory() {
        
    }
    
    public Inventory(Film film, Store store) {
       this.film = film;
       this.store = store;
       
       last_update = LocalDateTime.now();
    }
    
    public Inventory(Film film, Store store, LocalDateTime last_update) {
       this.film = film;
       this.store = store;
       this.last_update = last_update;
    }
}
