package moviestore.controllers;

import java.time.LocalDateTime;
import moviestore.entities.Country;
import moviestore.services.CountryService;
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
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;
    
    @GetMapping("/all")
    public @ResponseBody Iterable<Country> getAllCountries() { 
        return countryService.getAllCountries();
    }
    
    @GetMapping("/add")
    public @ResponseBody String addCountry(@RequestParam int id, @RequestParam String country,
            @RequestParam LocalDateTime updated) {        
        countryService.saveCountry(id, country, updated);
        return "Saved country";
    }
}
