package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.City;
import moviestore.entities.Country;
import moviestore.repositories.CityRepository;
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
@RequestMapping(path="/city")
public class CityController {
    @Autowired
    private CityRepository cityRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<City> getAllCities() { 
        return cityRepository.findAll();
    }
    
    @GetMapping(path="/add")
    public @ResponseBody String addCity(@RequestParam int id, @RequestParam String city,
            @RequestParam Country country, @RequestParam LocalDateTime updated) { 
        City c = new City();
        c.setCity_id(id);
        c.setCity(city);
        c.setCountry(country); 
        c.setLast_update(updated);
        cityRepository.save(c);
        return "Saved city";
    }
}
