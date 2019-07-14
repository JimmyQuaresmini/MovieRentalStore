package moviestore.services;

import java.time.LocalDateTime;
import javax.validation.Valid;
import moviestore.entities.Address;
import moviestore.entities.Customer;
import moviestore.entities.Store;
import moviestore.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    
    @GetMapping("/all")
    public String getAllCustomers(Model model) { 
        Iterable<Customer> itCustomers = customerRepository.findAll();
        model.addAttribute("customers", itCustomers);
        return "customers"; 
    }
    
    @GetMapping("/add") 
    public @ResponseBody String addCustomer(@RequestParam int id, @RequestParam Store store,
            @RequestParam String fName, @RequestParam String lName, 
            @RequestParam String email, @RequestParam Address address, 
            @RequestParam int active, @RequestParam LocalDateTime createDate, 
            @RequestParam LocalDateTime updated) {
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
        return "Saved customer";
    }
    
    @GetMapping("/edit/{id}") 
    public String editCustomer(@PathVariable("id") int id, Model model) { 
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer id: " + id));
        
        model.addAttribute("customer", customer);
        return "updateCustomer";
    }
    
    @PostMapping("/update/{id}") 
    public String updateCustomer(@PathVariable("id") int id, @Valid Customer customer, 
            BindingResult result, Model model) {
        if (result.hasErrors() == true) {
            customer.setCustomer_id(id);
            return "updateCustomer";
        }
        
        //store, address, create_date are not updated here
        
        customer.setLast_update(LocalDateTime.now());
        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "customers";
    }
    
    @GetMapping("/delete/{id}") 
    public String deleteCustomer(@PathVariable("id") int id, Model model) { 
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer id: " + id));
        customerRepository.delete(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "customers";
    }
}
