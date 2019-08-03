package moviestore.controllers;

import java.time.LocalDateTime;
import moviestore.entities.Film;
import moviestore.entities.Inventory;
import moviestore.entities.Store;
import moviestore.services.FilmService;
import moviestore.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jimmy
 */

@Controller
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    
    @Autowired
    private FilmService filmService;
    
    @GetMapping("/all")
    public @ResponseBody Iterable<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }
    
    @GetMapping("/add")
    public @ResponseBody String addInventory(@RequestParam int id, @RequestParam Film film, 
            @RequestParam Store store, @RequestParam LocalDateTime updated) {         
        inventoryService.saveInventory(id, film, store, updated);
        return "Saved inventory";
    }
    
    @GetMapping("/addInventoriesPage")
    public String showAddInventoryPage(Model model) {        
        Iterable<Film> films = filmService.getAllFilms();
        model.addAttribute("films", films);
        return "addInventories";
    }
        
    @PostMapping("/addInventories")
    public String addInventories(@RequestParam(name="filmRadioBtns") String filmTitle, 
            @RequestParam(name="store1Inventories") int store1Invs,
            @RequestParam(name="store2Inventories") int store2Invs, Model model) {        
        inventoryService.addInventories(filmTitle, store1Invs, store2Invs);
        model.addAttribute("successMsg", "Saved inventories with addInventory - few parameters");
        return "addInventories"; 
    }
}
