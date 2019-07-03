package moviestore.entities;

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
 *
 * @author Jimmy
 */

@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "store_id") //helps prevent a recursive error caused by staff also having store
public class Store {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int store_id;    
    @ManyToOne    
    @JoinColumn(name="manager_staff_id", unique=true, referencedColumnName="staff_id")
    private Staff staff;     
    @ManyToOne
    @JoinColumn(name="address_id", unique=true, referencedColumnName="address_id")
    private Address address; 
    private LocalDateTime last_update;

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }
    
    public Staff getStaff() { 
        return staff; 
    }

    public void setStaff(Staff staff) { 
        this.staff = staff;
    }

    public Address getAddress() { 
        return address; 
    }

    public void setAddress(Address address) { 
        this.address = address; 
    }    

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
}
