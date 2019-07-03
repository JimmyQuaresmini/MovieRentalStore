package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Customer;
import moviestore.entities.Inventory;
import moviestore.entities.Rental;
import moviestore.entities.Staff;
import moviestore.repositories.RentalRepository;
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
@RequestMapping(path="/rental")
public class RentalController {
    @Autowired
    private RentalRepository rentalRepository;
    
    @GetMapping(path="/all")
    public Iterable<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }
    
    @GetMapping(path="/add")
    public String addRental(@RequestParam int id, @RequestParam LocalDateTime rentalDate, 
            @RequestParam Inventory inventory, @RequestParam Customer customer, 
            @RequestParam Staff staff, @RequestParam LocalDateTime updated) { 
        Rental r = new Rental();
        r.setRental_id(id);
        r.setRental_date(rentalDate);
        r.setInventory(inventory); 
        r.setCustomer(customer); 
        r.setStaff(staff); 
        r.setLast_update(updated);
        rentalRepository.save(r);
        return "Saved rental";
    }
}
