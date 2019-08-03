package moviestore.controllers;

import moviestore.repositories.StoreRepository;
import moviestore.entities.Store;
import java.time.LocalDateTime;
import java.util.Set;
import moviestore.entities.Address;
import moviestore.entities.Inventory;
import moviestore.entities.Staff;
import moviestore.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Jimmy
 */

@Controller
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;
    
    @GetMapping("/all")
    public @ResponseBody Iterable<Store> getAllStores() { 
        return storeService.getAllStores();
    }
    
    @GetMapping("/add")
    public @ResponseBody String addStore(@RequestParam int id, @RequestParam Address address, 
            @RequestParam Staff staff, @RequestParam LocalDateTime updated, 
            Set<Staff> staffs, Set<Inventory> inventories) {         
        storeService.saveStore(id, address, staff, updated, staffs, inventories);
        return "Saved store";
    }
    
    @GetMapping("/addShort")
    public @ResponseBody String addStoreShort(@RequestParam Address address, 
            @RequestParam Staff staff, @RequestParam LocalDateTime updated) {         
        storeService.saveStoreShort(address, staff, updated);
        return "Saved store with fewer parameters";
    }
}
