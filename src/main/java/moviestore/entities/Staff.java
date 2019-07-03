package moviestore.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "staff_id")
public class Staff {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int staff_id;    
    @ManyToOne 
    @JoinColumn(name="address_id", unique=true, referencedColumnName="address_id")    
    private Address address; //FK here
    private byte[] picture; //blob datatype in MySQL
    @Email
    private String email;    
    @ManyToOne
    @JoinColumn(name="store_id", unique=true, referencedColumnName="store_id")
    private Store store; 
    private Short active;
    private String username;
    private String password;
    private LocalDateTime last_update;

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public Address getAddress() { 
        return address; 
    }

    public void setAddress(Address address) { 
        this.address = address; 
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    

    public Store getStore() { 
        return store; 
    }

    public void setStore(Store store) { 
        this.store = store; 
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
    
    
}
