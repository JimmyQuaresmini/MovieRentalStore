package moviestore.services;

import java.time.LocalDateTime;
import java.util.Set;
import moviestore.entities.Address;
import moviestore.entities.Staff;
import moviestore.entities.Store;
import moviestore.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jimmy
 */

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffRepository staffRepository;
    
    @GetMapping("/all")
    public @ResponseBody Iterable<Staff> getAllStaff() {
        return staffRepository.findAll();
    }
    
    @GetMapping("/add")
    public String addStore(@RequestParam int id, @RequestParam Address address, 
            @RequestParam Store store, @RequestParam String firstName, 
            @RequestParam String lastName, @RequestParam byte[] picture, 
            @RequestParam String email, @RequestParam Boolean active, 
            @RequestParam String userName, @RequestParam String password, 
            @RequestParam LocalDateTime updated, @RequestParam Set<Store> stores) { 
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
        return "Saved staff";
    }
    
    @GetMapping("/addShort")
    public String addStoreShort(@RequestParam Address address, @RequestParam Store store, 
            @RequestParam String firstName, @RequestParam String lastName, 
            @RequestParam Boolean active, @RequestParam String userName,
            @RequestParam LocalDateTime updated) { 
        Staff s = new Staff();        
        s.setAddress(address); 
        s.setStore(store); 
        s.setFirst_name(firstName);
        s.setLast_name(lastName);
        s.setActive(active);
        s.setUsername(userName);
        s.setLast_update(updated);
        staffRepository.save(s);
        return "Saved staff with fewer parameters";
    }
}
