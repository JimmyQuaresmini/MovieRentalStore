package moviestore.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;

/**
 *
 * @author Jimmy
 */

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int customer_id;    
    @ManyToOne    
    @JoinColumn(name="store_id", referencedColumnName="store_id")
    private Store store; 
    private String first_name;
    private String last_name;
    @Email
    private String email;    
    @ManyToOne    
    @JoinColumn(name="address_id", referencedColumnName="address_id")
    private Address address; 
    private int active;
    private LocalDateTime create_date;
    private LocalDateTime last_update;

    public Customer() {
        
    }

    public Customer(Store store, String first_name, String last_name, String email, Address address) {
        this.store = store;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        
        active = 1;
        create_date = LocalDateTime.now();
        last_update = LocalDateTime.now();
    }    

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Store getStore() { 
        return store; 
    }

    public void setStore(Store store) { 
        this.store = store; 
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() { 
        return address; 
    }

    public void setAddress(Address address) { 
        this.address = address; 
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }    
        
    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
}
