package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Address;
import moviestore.entities.City;
import moviestore.repositories.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    private AddressRepository addressRepository;
    
    @GetMapping("/all")
    public @ResponseBody Iterable<Address> getAllAddresses() { 
        return addressRepository.findAll();
    }
    
    @GetMapping("/add")
    public @ResponseBody String addAddress(@RequestParam int id, @RequestParam String address,
            @RequestParam String address2, @RequestParam String district,
            @RequestParam City city, @RequestParam String postalCode, 
            @RequestParam String phone, @RequestParam byte[] location, 
            @RequestParam LocalDateTime updated) {
        Address a = new Address();
        a.setAddress_id(id);
        a.setAddress(address);
        a.setAddress2(address2);
        a.setDistrict(district);
        a.setCity(city); 
        a.setPostal_code(postalCode);
        a.setPhone(phone);
        a.setLocation(location);
        a.setLast_update(updated);
        addressRepository.save(a);
        return "Saved address";
    }
}
