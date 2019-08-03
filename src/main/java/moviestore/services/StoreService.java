package moviestore.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import moviestore.entities.Address;
import moviestore.entities.Inventory;
import moviestore.entities.Rental;
import moviestore.entities.Staff;
import moviestore.entities.Store;
import moviestore.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Jimmy
 */

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;
    
    public Iterable<Store> getAllStores() {
        return storeRepository.findAll();
    }
    
    public void saveStore(int id, Address address, Staff staff, LocalDateTime updated,
            Set<Staff> staffs, Set<Inventory> inventories) {
        Store s = new Store();
        s.setStore_id(id);
        s.setAddress(address);
        s.setStaff(staff);        
        s.setLast_update(updated);
        s.setStaffs(staffs);
        s.setInventories(inventories);
        storeRepository.save(s);
    }
    
    public void saveStoreShort(Address address, Staff staff, LocalDateTime updated) {
        Store s = new Store();        
        s.setAddress(address);
        s.setStaff(staff);        
        s.setLast_update(updated);
        storeRepository.save(s);
    }
    
    //used by RentalService's saveRentalStore-function & InventoryService's addInventories()
    public Store findStoreById(int id) {
        Optional<Store> s = storeRepository.findById(id);
        if (s.isPresent() == true) {
            Store store = s.get();
            return store;
        }
        else {
            Store store = new Store();
            return store;
        }
    }
    
    //you could do this
    @ModelAttribute("allStores")
    public Iterable<Store> getAllStoresModAttr() {
        return storeRepository.findAll();
    }
}
