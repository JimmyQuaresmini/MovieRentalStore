package moviestore.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private String first_name;
    private String last_name;
    @ManyToOne 
    @JoinColumn(name="address_id", unique=true, referencedColumnName="address_id")    
    private Address address; //FK here
    private byte[] picture; //blob datatype in MySQL
    @Email
    private String email;    
    @ManyToOne 
    @JoinColumn(name="store_id", unique=true, referencedColumnName="store_id")
    private Store store; 
    private Boolean active; //Short //tinyint(1) in MySQL
    private String username;
    private String password;
    private LocalDateTime last_update;
    
    @OneToMany(mappedBy = "staff")
    private Set<Store> stores = new HashSet(0);

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
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

    public Boolean getActive() { //Short
        return active;
    }

    public void setActive(Boolean active) { //Short
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

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }    
    
    public Staff() {
        
    }
	
    public Staff(Address address, Store store, String firstName, String lastName, boolean active, String username, LocalDateTime last_update) {
        this.address = address;
        this.store = store;
        this.first_name = firstName;
        this.last_name = lastName;
        this.active = active;
        this.username = username;
        this.last_update = last_update;
    }
    public Staff(Address address, Store store, String firstName, String lastName, byte[] picture, String email, boolean active, String username, String password, LocalDateTime last_update, Set<Store> stores) {
       this.address = address;
       this.store = store;
       this.first_name = firstName;
       this.last_name = lastName;
       this.picture = picture;
       this.email = email;
       this.active = active;
       this.username = username;
       this.password = password;
       this.last_update = last_update;
       this.stores = stores;
    }
}
