package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Address;
import moviestore.entities.Customer;
import moviestore.entities.Store;
import moviestore.repositories.AddressRepository;
import moviestore.repositories.CustomerRepository;
import moviestore.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private StoreRepository storeRepository;
    
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public void saveCustomer(int id, Store store, String fName, String lName, 
            String email, Address address, int active, LocalDateTime createDate, LocalDateTime updated) {
        Customer c = new Customer();
        c.setCustomer_id(id);
        c.setStore(store);
        c.setFirst_name(fName);
        c.setLast_name(lName);
        c.setEmail(email);
        c.setAddress(address);
        c.setActive(active);
        c.setCreate_date(createDate);
        c.setLast_update(updated);
        customerRepository.save(c);
    }
    
    public Customer getCustomerById(int id) {        
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer id: " + id));
        return customer;
    }
    
    public Iterable<Customer> updateCustomer(Customer customer) {
        customer.setLast_update(LocalDateTime.now());
        //store, address, create_date are not updated here
        customerRepository.save(customer);
        Iterable<Customer> customers = customerRepository.findAll();
        return customers;
    }
    
    public Iterable<Customer> deleteById(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer id: " + id));
        customerRepository.delete(customer);
        Iterable<Customer> customers = customerRepository.findAll();
        return customers;
    }
    
    public Customer addCustomer(String first_name, String last_name, String email, 
            String addressName, String storeNr) {
        Address address = addressRepository.findAddressByName(addressName);
        int storeId = Integer.parseInt(storeNr);
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid store id: " + storeId));
        Customer c = new Customer(store, first_name, last_name, email, address);                                
        customerRepository.save(c);
        return c;
    }
}
