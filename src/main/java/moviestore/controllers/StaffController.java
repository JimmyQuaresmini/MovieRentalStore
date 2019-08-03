package moviestore.controllers;

import java.time.LocalDateTime;
import java.util.Set;
import moviestore.entities.Address;
import moviestore.entities.Staff;
import moviestore.entities.Store;
import moviestore.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jimmy
 */

@Controller
@RequestMapping("/staff")
public class StaffController {    
    @Autowired
    private StaffService staffService;
    
    @GetMapping("/all")
    public @ResponseBody Iterable<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }
    
    @GetMapping("/add")
    public @ResponseBody String addStore(@RequestParam int id, @RequestParam Address address, 
            @RequestParam Store store, @RequestParam String firstName, 
            @RequestParam String lastName, @RequestParam byte[] picture, 
            @RequestParam String email, @RequestParam Boolean active, 
            @RequestParam String userName, @RequestParam String password, 
            @RequestParam LocalDateTime updated, @RequestParam Set<Store> stores) {         
        staffService.saveStaff(id, address, store, firstName, lastName, picture, 
                email, active, userName, password, updated, stores);
        return "Saved staff";
    }
    
    @GetMapping("/addShort")
    public @ResponseBody String addStoreShort(@RequestParam Address address, @RequestParam Store store, 
            @RequestParam String firstName, @RequestParam String lastName, 
            @RequestParam Boolean active, @RequestParam String userName,
            @RequestParam LocalDateTime updated) { 
        staffService.saveStaffShort(address, store, firstName, lastName, active, userName, updated);
        return "Saved staff with fewer parameters";
    }
}
