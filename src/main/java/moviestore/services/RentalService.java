package moviestore.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import moviestore.entities.Customer;
import moviestore.entities.Film;
import moviestore.entities.Inventory;
import moviestore.entities.Payment;
import moviestore.entities.Rental;
import moviestore.entities.Staff;
import moviestore.entities.Store;
import moviestore.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class RentalService {
    //want to use these temporarily to help store a customer...
    //...and a store before I make a rental
    //but they may fit better in some help-class instead
    //with getters and setters.
    //rental needs staff also besides customer, but...
    //..can get that from store.
    Customer customer;
    Store store;
    Inventory inventory;
    boolean storeChosen = false;
    boolean customerChosen = false;
    String stoChoMsg = "";
    String custChoMsg = "";
    
    //bring in some "outsider-services" to get some of their functions
    @Autowired
    private CustomerService customerService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private FilmService filmService;
    
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private PaymentService paymentService;
    
    public Iterable<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }
    
    public void saveRental(int id, LocalDateTime rentalDate, Inventory inventory, 
            Customer customer, Staff staff, LocalDateTime updated) {
        Rental r = new Rental();
        r.setRental_id(id);
        r.setRental_date(rentalDate);
        r.setInventory(inventory); 
        r.setCustomer(customer); 
        r.setStaff(staff); 
        r.setLast_update(updated);
        rentalRepository.save(r);
    }
    
    public List<Object> saveRentalStore(int value) {
        List<Object> storeAndCustomerInfo = new ArrayList<>();
        
        this.store = storeService.findStoreById(value);
        storeAndCustomerInfo.add(store);
        stoChoMsg = "store chosen = " + store.getStore_id();
        System.out.println(stoChoMsg);
        storeAndCustomerInfo.add(stoChoMsg);
        storeChosen = true;
        if (customerChosen == true) {
            custChoMsg = "customer chosen = " + customer.getFirst_name();
            System.out.println(custChoMsg);
            storeAndCustomerInfo.add(custChoMsg);
            Film f = filmService.findById(1);
            storeAndCustomerInfo.add(f);
            storeAndCustomerInfo.add(customerChosen);
            //done selecting store and customer and restore values
            storeChosen = false;
            customerChosen = false;
            stoChoMsg = "";
            custChoMsg = "";
            //return "rentFilm";
        }
        else {
            Iterable<Customer> customers = customerService.getAllCustomers();
            storeAndCustomerInfo.add(customers);
            this.customer = customers.iterator().next();
            storeAndCustomerInfo.add(customer);
            storeAndCustomerInfo.add(customerChosen);
            //return "choseCustomerAndStore";
        }        
        
        return storeAndCustomerInfo;
    }
    
    //help-function giving information for the page where one selects store & customer
    public List<Object> getStoresCustomersForPage() {
        List<Object> storeAndCustomerInfo = new ArrayList<>();
        
        Iterable<Customer> customers = customerService.getAllCustomers();
        Iterable<Store> stores = storeService.getAllStores();
        //find the staff in the store(s) - maybe below when storing rather
        
        //find the inventories in the store(s)
        //from the inventory, find the film
        //incorrect - chose film and after that pick an inventory with the film in
        
        storeAndCustomerInfo.add(customers);
        storeAndCustomerInfo.add(stores);
        //added these 2 below to fix the problem of the page not understanding the object
        //not sure this is right though. should be from those lists above
        this.store = stores.iterator().next();
        storeAndCustomerInfo.add(this.store);
        storeAndCustomerInfo.add(this.customer);
        
        return storeAndCustomerInfo;
    }
    
    public List<Object> saveRentalCustomer(int value) {
        List<Object> storeAndCustomerInfo = new ArrayList<>();
        
        this.customer = customerService.getCustomerById(value);
        customerChosen = true;
        custChoMsg = "customer chosen = " + customer.getFirst_name();
        System.out.println(custChoMsg);
        storeAndCustomerInfo.add(custChoMsg);
        if (storeChosen == true) {
            storeAndCustomerInfo.add(stoChoMsg);
            Film f = filmService.findById(1);
            storeAndCustomerInfo.add(f);
            storeAndCustomerInfo.add(storeChosen);
            //done selecting store and customer and restore values
            storeChosen = false;
            customerChosen = false;
            stoChoMsg = "";
            custChoMsg = "";
            //return "rentFilm"; //redirect:/film/callRentFilmPage
        }            
        else {
            Iterable<Store> stores = storeService.getAllStores();
            storeAndCustomerInfo.add(stores);
            this.store = stores.iterator().next();
            storeAndCustomerInfo.add(this.store);
            storeAndCustomerInfo.add(storeChosen);
            //return "choseCustomerAndStore";
        }
                
        return storeAndCustomerInfo;
    }
    
    public List<Object> rentFilm(int filmId) {
        //information the Controller needs
        List<Object> rentInfo = new ArrayList<>();
        
        Set<Inventory> inventories = filmService.findInventoriesById(filmId);        
        
        if (inventories.isEmpty() == false) { 
            int nrOfInventories = inventories.size();
            int iterations = 0;            
            do { //get an inventory and make sure that its store's ID is the same as the store chosen
                this.inventory = inventories.iterator().next();
                iterations++;
            } while (this.inventory.getStore().getStore_id() != this.store.getStore_id() & 
                    iterations <= nrOfInventories);
            String statusMsg = "";
            //TODO: should do a search for inventories and the movies they are for the chosen store so this check is not needed.
            if (this.inventory.getStore().getStore_id() != this.store.getStore_id()) { 
                statusMsg = "Did not find an inventory with the movie in the store chosen so the movie was not rented.";
                rentInfo.add(statusMsg);
                rentInfo.add(this.inventory.getFilm());
            }
            else { 
                int daysToRent = this.inventory.getFilm().getRental_duration();
                LocalDateTime returnDate = LocalDateTime.now().plusDays(daysToRent);

                Rental rental = new Rental(this.inventory, this.customer, returnDate, this.store.getStaff());
                rentalRepository.save(rental);
                stoChoMsg = "store chosen = " + store.getStore_id();
                rentInfo.add(stoChoMsg);
                custChoMsg = "customer chosen = " + customer.getFirst_name();
                rentInfo.add(custChoMsg);

                //print out information about the rental and payment done farther down.
                System.out.println("New Rental saved. Inventory nr: " + this.inventory.getInventory_id());
                System.out.println("Film: " + this.inventory.getFilm().getTitle()
                        + ". Return date is: " + returnDate);
                System.out.println("Staff for Store nr: " + this.store.getStore_id()
                        + " is: " + this.store.getStaff().getFirst_name()
                        + " " + this.store.getStaff().getLast_name());

                Payment p = new Payment(this.customer, this.store.getStaff(),
                        rental, this.inventory.getFilm().getRental_rate());
                paymentService.savePaymentWithObject(p);
                System.out.println("Payment $" + p.getAmount() + " saved");

                rentInfo.add(this.inventory.getFilm());
                statusMsg = "cost for renting movie " 
                        + this.inventory.getFilm().getTitle() + ": $" + p.getAmount();
                rentInfo.add(statusMsg);
                String returnDateMsg = "movie to be returned on " 
                        + returnDate.getDayOfWeek() + " the " + returnDate.getDayOfMonth()
                        + " of " + returnDate.getMonth();
                rentInfo.add(returnDateMsg);                
            }
        }
        else { 
            Film f = filmService.findById(filmId);
            rentInfo.add(f);
            System.out.println("inventories for movie with ID: " + filmId + " was empty so it couldn't be rented");
        }
        
        return rentInfo;
    }
}
