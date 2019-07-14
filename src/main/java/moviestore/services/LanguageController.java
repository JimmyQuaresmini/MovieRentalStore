package moviestore.services;

import java.time.LocalDateTime;
import java.util.Set;
import moviestore.entities.Film;
import moviestore.entities.Language;
import moviestore.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jimmy
 */

@RestController
@RequestMapping(path="/language")
public class LanguageController {
    @Autowired
    private LanguageRepository languageRepository;
    
    @GetMapping(path="/all")
    public Iterable<Language> getAllLanguages() { 
        return languageRepository.findAll();
    }
    
    @GetMapping(path="/add")
    public String addLanguage(@RequestParam int id, @RequestParam String name,
            @RequestParam LocalDateTime updated, 
            @RequestParam Set<Film> languageFilms, @RequestParam Set<Film> origLangFilms) {
        Language l = new Language();
        l.setLanguage_id(id);
        l.setName(name);        
        l.setLast_update(updated);
        /*l.setFilmsForLanguageId(languageFilms);
        l.setFilmsForOriginalLanguageId(origLangFilms);*/
        languageRepository.save(l);
        return "Saved language";
    }
    
    @GetMapping(path="/addShort")
    public String addLanguageShort(@RequestParam String name,
            @RequestParam LocalDateTime updated) {
        Language l = new Language();        
        l.setName(name);        
        l.setLast_update(updated);
        languageRepository.save(l);
        return "Saved language with fewer parameters";
    }
}
