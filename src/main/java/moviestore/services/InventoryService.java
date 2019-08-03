package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Film;
import moviestore.entities.Inventory;
import moviestore.entities.Store;
import moviestore.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    
    @Autowired
    private FilmService filmService;
    
    @Autowired
    private StoreService storeService;
    
    public Iterable<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
    
    public void saveInventory(int id, Film film, Store store, LocalDateTime updated) {
        Inventory i = new Inventory();
        i.setInventory_id(id);
        i.setFilm(film); 
        i.setStore(store); 
        i.setLast_update(updated);
        inventoryRepository.save(i);
    }
    
    public void addInventories(String filmTitle, int store1Invs, int store2Invs) {
        Film film = filmService.findByTitle(filmTitle);
        Store s1 = storeService.findStoreById(1);
        Store s2 = storeService.findStoreById(2);
        for (int i = 0; i < store1Invs; i++) {
            Inventory inv = new Inventory(film, s1);
            inventoryRepository.save(inv);            
        }
        for (int i = 0; i < store2Invs; i++) {
            Inventory inv = new Inventory(film, s2);
            inventoryRepository.save(inv);            
        }
    }
}
