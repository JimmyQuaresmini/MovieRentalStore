package moviestore.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
    @JoinColumn(name="manager_staff_id", referencedColumnName="staff_id")
    private Staff staff;     
    @ManyToOne
    @JoinColumn(name="address_id", referencedColumnName="address_id")
    private Address address; 
    private LocalDateTime last_update;
    
    @OneToMany(mappedBy = "store")
    private Set<Staff> staffs = new HashSet(0);
    @OneToMany(mappedBy = "store")
    private Set<Inventory> inventories = new HashSet(0);

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

    public Set getStaffs() {
        return staffs;
    }

    public void setStaffs(Set staffs) {
        this.staffs = staffs;
    }

    public Set getInventories() {
        return inventories;
    }

    public void setInventories(Set inventories) {
        this.inventories = inventories;
    }
    
    

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
    
    public Store() {
        
    }
	
    public Store(Address address, Staff staff, LocalDateTime last_update) {
        this.address = address;
        this.staff = staff;
        this.last_update = last_update;
    }
    public Store(Address address, Staff staff, LocalDateTime last_update, Set<Staff> staffs, Set<Inventory> inventories) {
       this.address = address;
       this.staff = staff;
       this.last_update = last_update;
       this.staffs = staffs;
       this.inventories = inventories;
    }
}
