package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Country;
import moviestore.repositories.CountryRepository;
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
@RequestMapping(path="/country")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Country> getAllCountries() { 
        return countryRepository.findAll();
    }
    
    @GetMapping(path="/add")
    public @ResponseBody String addCountry(@RequestParam int id, @RequestParam String country,
            @RequestParam LocalDateTime updated) {
        Country c = new Country();
        c.setCountry_id(id);
        c.setCountry(country);
        c.setLast_update(updated);
        countryRepository.save(c);
        return "Saved country";
    }
}
