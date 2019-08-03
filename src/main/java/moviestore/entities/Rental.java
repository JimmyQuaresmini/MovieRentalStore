package moviestore.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Over 16,000 stored
 * @author Jimmy
 */

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int rental_id;
    private LocalDateTime rental_date;
    @ManyToOne 
    @JoinColumn(name="inventory_id", referencedColumnName="inventory_id")
    private Inventory inventory; 
    @ManyToOne 
    @JoinColumn(name="customer_id", referencedColumnName="customer_id")
    private Customer customer; 
    private LocalDateTime return_date;
    @ManyToOne 
    @JoinColumn(name="staff_id", referencedColumnName="staff_id")
    private Staff staff; 
    private LocalDateTime last_update;
    
    public Rental() {
        
    }

    public Rental(Inventory inventory, Customer customer, LocalDateTime return_date, Staff staff) {        
        this.inventory = inventory;
        this.customer = customer;
        this.return_date = return_date;
        this.staff = staff;
        
        this.rental_date = LocalDateTime.now();
        this.last_update = LocalDateTime.now();
    }
    
    

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }
    
    public LocalDateTime getRental_date() {
        return rental_date;
    }

    public void setRental_date(LocalDateTime rental_date) {
        this.rental_date = rental_date;
    }
    
    public Inventory getInventory() { 
        return inventory; 
    }

    public void setInventory(Inventory inventory) { 
        this.inventory = inventory; 
    } 

    public Customer getCustomer() { 
        return customer; 
    }

    public void setCustomer(Customer customer) { 
        this.customer = customer; 
    }
    
    public LocalDateTime getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDateTime return_date) {
        this.return_date = return_date;
    }

    public Staff getStaff() { 
        return staff; 
    }

    public void setStaff(Staff staff) { 
        this.staff = staff; 
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
}
