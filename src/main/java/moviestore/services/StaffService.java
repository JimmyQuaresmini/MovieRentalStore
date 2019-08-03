package moviestore.services;

import java.time.LocalDateTime;
import java.util.Set;
import moviestore.entities.Address;
import moviestore.entities.Staff;
import moviestore.entities.Store;
import moviestore.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;
    
    public Iterable<Staff> getAllStaff() {
        return staffRepository.findAll();
    }
    
    public void saveStaff(int id, Address address, Store store, 
            String firstName, String lastName, byte[] picture, 
            String email, Boolean active, String userName, String password, 
            LocalDateTime updated, Set<Store> stores) {
        Staff s = new Staff();
        s.setStaff_id(id);
        s.setAddress(address); 
        s.setStore(store);
        s.setFirst_name(firstName);
        s.setLast_name(lastName);
        s.setPicture(picture);
        s.setEmail(email);
        s.setActive(active);
        s.setUsername(userName);
        s.setPassword(password);
        s.setLast_update(updated);
        s.setStores(stores);
        staffRepository.save(s);
    }
    
    public void saveStaffShort(Address address, Store store, String firstName, String lastName, 
            Boolean active, String userName, LocalDateTime updated) {
        Staff s = new Staff();        
        s.setAddress(address); 
        s.setStore(store); 
        s.setFirst_name(firstName);
        s.setLast_name(lastName);
        s.setActive(active);
        s.setUsername(userName);
        s.setLast_update(updated);
        staffRepository.save(s);
    }
}
