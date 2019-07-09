package moviestore.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author Jimmy
 */

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int film_id;
    private String title;
    private String description;
    private short release_year;//year in MySQL
    @ManyToOne    
    @JoinColumn(name="language_id", referencedColumnName="language_id")
    private Language language;
    @ManyToOne    
    @JoinColumn(name="original_language_id", nullable=false, referencedColumnName="language_id")
    private Language language2; 
    private short rental_duration;
    private float rental_rate;
    private int length;
    private float replacement_cost;
    private Rating rating;
        
    @Transient 
    private Set<String> specFeatString; //['Trailers','Commentaries','Deleted Scenes','Behind the Scenes']
    private String special_features;
    
    //@ManyToMany(cascade=CascadeType.ALL)
    //@JoinTable(name="film_actor", joinColumns=@JoinColumn(name="film_id"), inverseJoinColumns=@JoinColumn(name="actor_id"))
    @OneToMany(mappedBy = "film")
    private Set<Film_actor> film_actors;
    
    //@ManyToMany(cascade=CascadeType.ALL)
    //@JoinTable(name="film_category", joinColumns=@JoinColumn(name="film_id"), inverseJoinColumns=@JoinColumn(name="category_id"))
    @OneToMany(mappedBy = "film")
    private Set<Film_category> film_categories;
    
    private LocalDateTime last_update;
    
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

    public short getRelease_year() {
        return release_year;
    }

    public void setRelease_year(short release_year) {
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

    public short getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(short rental_duration) {
        this.rental_duration = rental_duration;
    }

    public float getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(float rental_rate) {
        this.rental_rate = rental_rate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(float replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
    
    
    
    public String getSpecial_features() { 
        if (specFeatString == null)
            return null;
        else
            return String.join(",", specFeatString);            
    }
    
    public void setSpecial_features(String special_features) {             
        String[] tempStrings = special_features.split(",");
        for (int i = 0; 0 < tempStrings.length; i++) {
            if (specFeatString.contains(tempStrings[i]) == false) {
                specFeatString.add(tempStrings[i]);
            }
        }        
    }

    public Set<Film_actor> getFilm_actors() {
        return film_actors;
    }

    public void setFilm_actors(Set<Film_actor> film_actors) {
        this.film_actors = film_actors;
    }

    public Set<Film_category> getCategories() {
        return film_categories;
    }

    public void setCategories(Set<Film_category> categories) {
        this.film_categories = categories;
    }
    
            
    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
}
