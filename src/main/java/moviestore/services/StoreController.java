package moviestore.services;

import moviestore.repositories.StoreRepository;
import moviestore.entities.Store;
import java.time.LocalDateTime;
import java.util.Set;
import moviestore.entities.Address;
import moviestore.entities.Inventory;
import moviestore.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Jimmy
 */

@RestController
@RequestMapping(path="/store")
public class StoreController {
    @Autowired
    private StoreRepository storeRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Store> getAllStores() { 
        return storeRepository.findAll();
    }
    
    @GetMapping(path="/add")
    public String addStore(@RequestParam int id, @RequestParam Address address, 
            @RequestParam Staff staff, @RequestParam LocalDateTime updated, 
            Set<Staff> staffs, Set<Inventory> inventories) { 
        Store s = new Store();
        s.setStore_id(id);
        s.setAddress(address);
        s.setStaff(staff);        
        s.setLast_update(updated);
        s.setStaffs(staffs);
        s.setInventories(inventories);
        storeRepository.save(s);
        return "Saved store";
    }
    
    @GetMapping(path="/addShort")
    public String addStoreShort(@RequestParam Address address, 
            @RequestParam Staff staff, @RequestParam LocalDateTime updated) { 
        Store s = new Store();        
        s.setAddress(address);
        s.setStaff(staff);        
        s.setLast_update(updated);
        storeRepository.save(s);
        return "Saved store with fewer parameters";
    }
}
