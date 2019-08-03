package moviestore.controllers;

import java.time.LocalDateTime;
import java.util.List;
import moviestore.entities.Customer;
import moviestore.entities.Film;
import moviestore.entities.Inventory;
import moviestore.entities.Rental;
import moviestore.entities.Staff;
import moviestore.entities.Store;
import moviestore.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jimmy
 */

@Controller
@RequestMapping("/rental")
public class RentalController {
    
    @Autowired
    private RentalService rentalService;
    
    @GetMapping("/all")
    public @ResponseBody Iterable<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }
    
    @GetMapping("/add")
    public @ResponseBody String addRental(@RequestParam int id, @RequestParam LocalDateTime rentalDate, 
            @RequestParam Inventory inventory, @RequestParam Customer customer, 
            @RequestParam Staff staff, @RequestParam LocalDateTime updated) {         
        rentalService.saveRental(id, rentalDate, inventory, customer, staff, updated);
        return "Saved rental";
    }
        
    @GetMapping("/callChoseCustAndStorePage")
    public String callChoseCustAndStorePage(Model model) {
        List<Object> storeAndCustomerInfo = rentalService.getStoresCustomersForPage();
        
        model.addAttribute("customers", ((Iterable<Customer>) storeAndCustomerInfo.get(0)));
        model.addAttribute("stores", ((Iterable<Store>) storeAndCustomerInfo.get(1)));
        model.addAttribute("rentalStore", ((Store) storeAndCustomerInfo.get(2)));
        model.addAttribute("rentalCustomer", ((Customer) storeAndCustomerInfo.get(3)));
        return "choseCustomerAndStore";
    }
        
    @PostMapping("/saveStore") 
    public String saveStore(@RequestParam(name="storeRadioBtnsIn") int value, Model model) { 
        List<Object> storeAndCustomerInfo = rentalService.saveRentalStore(value);
        
        model.addAttribute("chosenStore", (Store) storeAndCustomerInfo.get(0));
        model.addAttribute("chosenStoreMsg", (String) storeAndCustomerInfo.get(1));
        if (((Boolean) storeAndCustomerInfo.get(4)) == true) { //boolean for "customer chosen"
            model.addAttribute("chosenCustomerMsg", (String) storeAndCustomerInfo.get(2));
            model.addAttribute("film", (Film) storeAndCustomerInfo.get(3));
            return "rentFilm";
        }
        else {
            model.addAttribute("customers", (Iterable<Customer>) storeAndCustomerInfo.get(2));
            model.addAttribute("rentalCustomer", (Customer) storeAndCustomerInfo.get(3));            
            return "choseCustomerAndStore";
        }        
    }
    
    @PostMapping("/storeCustomer") 
    public String storeCustomer(@RequestParam(name="customerRadioBtnsIn") int value, Model model) {
        List<Object> storeAndCustomerInfo = rentalService.saveRentalCustomer(value);
        
        model.addAttribute("chosenCustomerMsg", (String) storeAndCustomerInfo.get(0));
        if (((Boolean) storeAndCustomerInfo.get(3)) == true) {
            model.addAttribute("chosenStoreMsg", (String) storeAndCustomerInfo.get(1));
            model.addAttribute("film", (Film) storeAndCustomerInfo.get(2));
            return "rentFilm"; //redirect:/film/callRentFilmPage
        }
        else {
            model.addAttribute("stores", (Iterable<Store>) storeAndCustomerInfo.get(1));
            model.addAttribute("rentalStore", (Store) storeAndCustomerInfo.get(2));
            return "choseCustomerAndStore";
        }
    }
        
    @PostMapping("/rentFilm/{id}")
    public String rentFilm(@PathVariable("id") int filmId, Model model) {        
        List<Object> rentalInfo = rentalService.rentFilm(filmId);
        switch (rentalInfo.size()) {
            case 1:
                model.addAttribute("film", (Film) rentalInfo.get(0));
                break;
            case 2:
                model.addAttribute("status", (String) rentalInfo.get(0));
                model.addAttribute("film", (Film) rentalInfo.get(1));
                break;
            case 5:
                model.addAttribute("chosenStoreMsg", (String) rentalInfo.get(0));
                model.addAttribute("chosenCustomerMsg", (String) rentalInfo.get(1));
                model.addAttribute("film", (Film) rentalInfo.get(2));
                model.addAttribute("status", (String) rentalInfo.get(3));
                model.addAttribute("retDateMsg", (String) rentalInfo.get(4));
                break;
            default:
                break;
        }
        
        return "rentFilm"; 
    }
}
