package moviestore.controllers;

import java.time.LocalDateTime;
import javax.validation.Valid;
import moviestore.entities.Address;
import moviestore.entities.Customer;
import moviestore.entities.Store;
import moviestore.services.AddressService;
import moviestore.services.CustomerService;
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
    private AddressService addressService;        
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/all")
    public String getAllCustomers(Model model) { 
        Iterable<Customer> itCustomers = customerService.getAllCustomers();
        model.addAttribute("customers", itCustomers);
        return "customers"; 
    }
    
    @GetMapping("/add") 
    public @ResponseBody String addCustomer(@RequestParam int id, @RequestParam Store store,
            @RequestParam String fName, @RequestParam String lName, 
            @RequestParam String email, @RequestParam Address address, 
            @RequestParam int active, @RequestParam LocalDateTime createDate, 
            @RequestParam LocalDateTime updated) {        
        customerService.saveCustomer(id, store, fName, lName, email, address, active, 
                createDate, updated);
        return "Saved customer";
    }
    
    @GetMapping("/edit/{id}") 
    public String editCustomer(@PathVariable("id") int id, Model model) { 
        Customer customer = customerService.getCustomerById(id);        
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
        model.addAttribute("customers", customerService.updateCustomer(customer));
        return "customers";
    }
    
    @GetMapping("/delete/{id}") 
    public String deleteCustomer(@PathVariable("id") int id, Model model) {         
        model.addAttribute("customers", customerService.deleteById(id));
        return "customers";
    }
    
    @GetMapping("/addCustomerPage")
    public String showAddCustomerPage(Model model) {
        Customer c = new Customer();
        model.addAttribute("customer", c);
        Iterable<Address> addresses = addressService.getAllAddresses();
        addressService.searchAndPrintAddressById(addresses, 602);        
        model.addAttribute("addresses", addresses);
        return "addCustomer";
    }
    
    @PostMapping("/addCustomer")
    public String addCustomer(@RequestParam String first_name,
            @RequestParam String last_name, @RequestParam String email, 
            @RequestParam(name="addressRadioBtns") String addressName, 
            @RequestParam(name="storeRadioBtns") String storeNr, Model model) {
        model.addAttribute("customer", customerService.addCustomer(first_name, last_name, email, addressName, storeNr));
        model.addAttribute("successMsg", "Saved customer with addCustomer - few parameters");
        return "addCustomer"; 
    }
}
