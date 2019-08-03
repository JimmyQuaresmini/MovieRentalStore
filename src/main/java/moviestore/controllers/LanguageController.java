package moviestore.controllers;

import java.time.LocalDateTime;
import java.util.Set;
import moviestore.entities.Film;
import moviestore.entities.Language;
import moviestore.services.LanguageService;
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
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;
    
    @GetMapping("/all")
    public Iterable<Language> getAllLanguages() { 
        return languageService.getAllLanguages();
    }
    
    @GetMapping("/add")
    public String addLanguage(@RequestParam int id, @RequestParam String name,
            @RequestParam LocalDateTime updated, 
            @RequestParam Set<Film> languageFilms, @RequestParam Set<Film> origLangFilms) {        
        languageService.saveLanguage(id, name, updated, languageFilms, origLangFilms);
        return "Saved language";
    }
    
    @GetMapping("/addShort")
    public String addLanguageShort(@RequestParam String name,
            @RequestParam LocalDateTime updated) {        
        languageService.saveLanguageShort(name, updated);
        return "Saved language with fewer parameters";
    }
}
