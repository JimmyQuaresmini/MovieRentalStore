package moviestore.services;

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
@RequestMapping(path="/staff")
public class StaffController {
    @Autowired
    private StaffRepository staffRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Staff> getAllStaff() {
        return staffRepository.findAll();
    }
    
    @GetMapping(path="/add")
    public String addStore(@RequestParam int id, @RequestParam Address address, 
            @RequestParam Store store) { 
        Staff s = new Staff();
        s.setStaff_id(id);
        s.setAddress(address); 
        s.setStore(store); 
        staffRepository.save(s);
        return "Saved staff";
    }
}
