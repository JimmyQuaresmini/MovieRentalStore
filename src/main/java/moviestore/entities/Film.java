package moviestore.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Jimmy
 */

@Entity
public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")//to make it use "Identity" rather with MySQL5.7 or 8
    private int film_id;//can also use "IDENTITY" rather than "AUTO" above
    private String title;
    private String description;    
    private Short release_year;//year in MySQL 
    @ManyToOne    
    @JoinColumn(name="language_id", referencedColumnName="language_id")
    private Language language;
    @ManyToOne    
    @JoinColumn(name="original_language_id", referencedColumnName="language_id") 
    private Language language2; 
    private Short rental_duration;
    private BigDecimal rental_rate; 
    private Short length; 
    private BigDecimal replacement_cost; 
    private String rating;         
    //['Trailers','Commentaries','Deleted Scenes','Behind the Scenes']
    private String special_features;    
    @OneToMany(mappedBy = "film", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Film_actor> film_actors;
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Film_category> film_categories;
    
    private LocalDateTime last_update;
        
    @OneToMany(mappedBy = "film", fetch=FetchType.LAZY, cascade = CascadeType.ALL) 
    @JsonManagedReference
    private Set<Inventory> inventories = new HashSet(0);
    
    public int getFilm_id() {        
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Short release_year) { 
        this.release_year = release_year;
    }

    public Language getLanguage() { 
        return language; 
    }

    public void setLanguage(Language language) { 
        this.language = language; 
    }

    public Language getLanguage2() { 
        return language2; 
    }

    public void setLanguage2(Language language2) { 
        this.language2 = language2; 
    }
    
    public Short getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(Short rental_duration) {
        this.rental_duration = rental_duration;
    }   

    public BigDecimal getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(BigDecimal rental_rate) {
        this.rental_rate = rental_rate;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public BigDecimal getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(BigDecimal replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getRating() { 
        return rating;
    }

    public void setRating(String rating) { 
        this.rating = rating;
    }
    
    public String getSpecial_features() {         
        return special_features;
    }
    
    public void setSpecial_features(String special_features) { 
        this.special_features = special_features;
    }

    public Set<Film_actor> getFilm_actors() {
        return film_actors;
    }

    public void setFilm_actors(Set<Film_actor> film_actors) {
        this.film_actors = film_actors;
    }

    public Set<Film_category> getFilm_categories() {
        return film_categories;
    }

    public void setFilm_categories(Set<Film_category> film_categories) {
        this.film_categories = film_categories;
    }
            
    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    public Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }
    

    //several different constructors follows for various needs
    public Film() {
        
    }
    
    public Film(String title, Language language, Short rental_duration, BigDecimal rental_rate, 
            BigDecimal replacement_cost, LocalDateTime last_update) {
        this.title = title;
        this.language = language;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.replacement_cost = replacement_cost;
        this.last_update = last_update;
    }
    
    public Film(String title, String description, short release_year, Language language, 
            Language language2, Short rental_duration, BigDecimal rental_rate, Short length, 
            BigDecimal replacement_cost, String rating, String special_features, 
            LocalDateTime last_update, Set<Inventory> inventories) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language = language;
        this.language2 = language2;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;
        this.last_update = last_update;
        this.inventories = inventories;
    }
    
    
    public Film(int film_id, String title, String description, short release_year, 
            Language language, Language language2, Short rental_duration, BigDecimal rental_rate, 
            Short length, BigDecimal replacement_cost, String rating, String special_features, 
            LocalDateTime last_update) {
        this.film_id = film_id;
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language = language;
        this.language2 = language2;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;
        this.last_update = last_update;
    }
    
    public Film(int film_id, String title, String description, short release_year, 
            Language language, Language language2, Short rental_duration, BigDecimal rental_rate, 
            Short length, BigDecimal replacement_cost, String rating, String special_features, 
            LocalDateTime last_update, Set<Inventory> inventories) {
        this.film_id = film_id;
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language = language;
        this.language2 = language2;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;
        this.last_update = last_update;
        this.inventories = inventories;
    }
    
    public Film(String title, String description, Short release_year, Language language, 
            Short rental_duration, BigDecimal rental_rate, Short length, BigDecimal replacement_cost, 
            String rating, String special_features) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language = language;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;
    }
}
