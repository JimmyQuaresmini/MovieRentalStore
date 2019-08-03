package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Country;
import moviestore.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    
    public Iterable<Country> getAllCountries() {
        return countryRepository.findAll();
    }
    
    public void saveCountry(int id, String country, LocalDateTime updated) {
        Country c = new Country();
        c.setCountry_id(id);
        c.setCountry(country);
        c.setLast_update(updated);
        countryRepository.save(c);
    }
}
