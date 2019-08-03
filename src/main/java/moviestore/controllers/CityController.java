package moviestore.controllers;

import java.time.LocalDateTime;
import moviestore.entities.City;
import moviestore.entities.Country;
import moviestore.services.CityService;
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
    private CityService cityService;
    
    @GetMapping("/all")
    public @ResponseBody Iterable<City> getAllCities() { 
        return cityService.getAllCities();
    }
    
    @GetMapping("/add")
    public @ResponseBody String addCity(@RequestParam int id, @RequestParam String city,
            @RequestParam Country country, @RequestParam LocalDateTime updated) {         
        cityService.saveCity(id, city, country, updated);
        return "Saved city";
    }
}
