package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.City;
import moviestore.entities.Country;
import moviestore.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    
    public Iterable<City> getAllCities() { 
        return cityRepository.findAll();
    }
    
    public void saveCity(int id, String city, Country country, LocalDateTime updated) {
        City c = new City();
        c.setCity_id(id);
        c.setCity(city);
        c.setCountry(country); 
        c.setLast_update(updated);
        cityRepository.save(c);
    }
}
