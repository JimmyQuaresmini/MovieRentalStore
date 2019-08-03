package moviestore.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import moviestore.entities.Address;
import moviestore.entities.City;
import moviestore.repositories.AddressRepository;
import moviestore.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private CityRepository cityRepository;
    
    public Iterable<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
    
    public void saveAddress (int id, String address, String address2, String district,
            City city, String postalCode, Long phone, byte[] location, LocalDateTime updated) {
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
    }
    
    public Address addAddress (String address, String cityName, String postal_code) {
        City city = cityRepository.findCityByName(cityName);
        Address a = new Address(address, city, postal_code);
        addressRepository.save(a);
        return a;
    }
    
    //special for CustomerController for more information
    public void searchAndPrintAddressById(Iterable<Address> addresses, int id) {
        addresses.forEach(a -> {if (a.getAddress_id() == id) System.out.println("address blob = " + 
                Arrays.toString(a.getLocation()));});//West Greece district
    }
}
