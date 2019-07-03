package moviestore.services;

import moviestore.repositories.StoreRepository;
import moviestore.entities.Store;
import java.time.LocalDateTime;
import moviestore.entities.Address;
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
    public String addStore(@RequestParam int id, @RequestParam Staff staff, 
            @RequestParam Address address, @RequestParam LocalDateTime updated) { 
        Store s = new Store();
        s.setStore_id(id);
        s.setStaff(staff);
        s.setAddress(address);
        s.setLast_update(updated);
        storeRepository.save(s);
        return "Saved store";
    }
}
