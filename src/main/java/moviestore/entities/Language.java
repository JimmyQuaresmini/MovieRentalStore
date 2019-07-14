package moviestore.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Jimmy
 */

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int language_id;
    private String name;
    private LocalDateTime last_update;
    
    /*@OneToMany(mappedBy = "language")//, fetch=FetchType.LAZY)
    private Set<Film> filmsForLanguageId = new HashSet(0);
    @OneToMany(mappedBy = "language2")//, fetch=FetchType.LAZY)
    private Set<Film> filmsForOriginalLanguageId = new HashSet(0);*/

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    /*public Set<Film> getFilmsForLanguageId() {
        return filmsForLanguageId;
    }

    public void setFilmsForLanguageId(Set<Film> filmsForLanguageId) {
        this.filmsForLanguageId = filmsForLanguageId;
    }

    public Set<Film> getFilmsForOriginalLanguageId() {
        return filmsForOriginalLanguageId;
    }

    public void setFilmsForOriginalLanguageId(Set<Film> filmsForOriginalLanguageId) {
        this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
    }*/
    
    
    
    public Language() {
        
    }
	
    public Language(String name, LocalDateTime last_update) {
        this.name = name;
        this.last_update = last_update;
    }
    public Language(String name, LocalDateTime last_update, Set<Film> filmsForLanguageId, Set<Film> filmsForOriginalLanguageId) {
       this.name = name;
       this.last_update = last_update;
       /*this.filmsForLanguageId = filmsForLanguageId;
       this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;*/
    }
}
