package moviestore.controllers;

import java.time.LocalDateTime;
import moviestore.entities.Address;
import moviestore.entities.City;
import moviestore.repositories.CityRepository;
import moviestore.services.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jimmy
 */

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    
    @Autowired
    private CityRepository cityRepository;
    
    @GetMapping("/all")
    public @ResponseBody Iterable<Address> getAllAddresses() { 
        return addressService.getAllAddresses();
    }
    
    @GetMapping("/add")
    public @ResponseBody String addAddress(@RequestParam int id, @RequestParam String address,
            @RequestParam String address2, @RequestParam String district,
            @RequestParam City city, @RequestParam String postalCode, 
            @RequestParam Long phone, @RequestParam byte[] location, 
            @RequestParam LocalDateTime updated) {        
        addressService.saveAddress(id, address, address2, district, city, postalCode, phone, location, updated);        
        return "Saved address";
    }
    
    @GetMapping("/addAddressPage")
    public String showAddAddressPage(Model model) {
        Address a = new Address();
        model.addAttribute("newAddress", a);
        Iterable<City> cities = cityRepository.findAll();//use cityService later
        model.addAttribute("cities", cities);
        return "addAddress";
    }
    
    @PostMapping("/addAddress")
    public String addAddress(@RequestParam String address,
            @RequestParam(name="cityRadioBtns") String cityName, 
            @RequestParam String postal_code, Model model) {
                                       
        Address a = addressService.addAddress(address, cityName, postal_code);
        model.addAttribute("newAddress", a);
        model.addAttribute("successMsg", "Saved address with addAddress - few parameters");
        return "addAddress"; 
    }
}
