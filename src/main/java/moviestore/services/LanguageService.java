package moviestore.services;

import java.time.LocalDateTime;
import java.util.Set;
import moviestore.entities.Film;
import moviestore.entities.Language;
import moviestore.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;
    
    public Iterable<Language> getAllLanguages() {
        return languageRepository.findAll();
    }
    
    public void saveLanguage(int id, String name, LocalDateTime updated, 
            Set<Film> languageFilms, Set<Film> origLangFilms) {
        Language l = new Language();
        l.setLanguage_id(id);
        l.setName(name);        
        l.setLast_update(updated);
        /*l.setFilmsForLanguageId(languageFilms);
        l.setFilmsForOriginalLanguageId(origLangFilms);*/
        languageRepository.save(l);
    }
    
    public void saveLanguageShort(String name, LocalDateTime updated) {
        Language l = new Language();        
        l.setName(name);        
        l.setLast_update(updated);
        languageRepository.save(l);
    }
}
