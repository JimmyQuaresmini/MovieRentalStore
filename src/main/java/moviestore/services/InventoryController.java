package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Film;
import moviestore.entities.Inventory;
import moviestore.entities.Store;
import moviestore.repositories.InventoryRepository;
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
@RequestMapping(path="/inventory")
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;
    
    @GetMapping(path="/all")
    public Iterable<Inventory> getAllInventory() { //@ResponseBody
        return inventoryRepository.findAll();
    }
    
    @GetMapping(path="/add")
    public String addInventory(@RequestParam int id, @RequestParam Film film, 
            @RequestParam Store store, @RequestParam LocalDateTime updated) { 
        Inventory i = new Inventory();
        i.setInventory_id(id);
        i.setFilm(film); 
        i.setStore(store); 
        i.setLast_update(updated);
        inventoryRepository.save(i);
        return "Saved inventory";
    }
}
