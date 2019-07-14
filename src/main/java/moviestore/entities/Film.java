package moviestore.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Jimmy
 */

@Entity
public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int film_id;
    private String title;
    private String description;
    //@Temporal(javax.persistence.TemporalType.DATE)
    private Short release_year;//year in MySQL //Date //changed back to short
    @ManyToOne    
    @JoinColumn(name="language_id", referencedColumnName="language_id")
    private Language language;
    @ManyToOne    
    @JoinColumn(name="original_language_id", referencedColumnName="language_id") //nullable=false, 
    private Language language2; 
    private Short rental_duration;
    private BigDecimal rental_rate; //float
    private Short length; //int
    private BigDecimal replacement_cost; //float
    //@Convert(converter = RatingConverter.class)
    private String rating; //Rating
        
    //@Transient 
    //private Set<String> specFeatString; //['Trailers','Commentaries','Deleted Scenes','Behind the Scenes']
    private String special_features;
    
    //@ManyToMany(cascade=CascadeType.ALL)
    //@JoinTable(name="film_actor", joinColumns=@JoinColumn(name="film_id"), inverseJoinColumns=@JoinColumn(name="actor_id"))
    @OneToMany(mappedBy = "film", fetch=FetchType.LAZY, cascade = CascadeType.ALL)//, fetch=FetchType.LAZY
    @JsonManagedReference
    private Set<Film_actor> film_actors;
    
    //@ManyToMany(cascade=CascadeType.ALL)
    //@JoinTable(name="film_category", joinColumns=@JoinColumn(name="film_id"), inverseJoinColumns=@JoinColumn(name="category_id"))
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Film_category> film_categories;
    
    private LocalDateTime last_update;
    
    //only thing left, but should not be a column, so not sure how to do this
    //@JsonIgnore
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

    public String getRating() { //Rating
        return rating;
    }

    public void setRating(String rating) { //Rating
        this.rating = rating;
    }

    //this should not be in the database so I don't want this here, 
    //but add for the object itself
    /*public Set<String> getSpecFeatString() {
        return specFeatString;
    }

    public void setSpecFeatString(Set<String> specFeatString) {
        this.specFeatString = specFeatString;
    }*/
    
    
    
    public String getSpecial_features() { 
        /*if (specFeatString == null)
            return null;
        else
            return String.join(",", specFeatString);*/
        return special_features;
    }
    
    public void setSpecial_features(String special_features) {             
        /*String[] tempStrings = special_features.split(",");
        for (int i = 0; 0 < tempStrings.length; i++) {
            if (specFeatString.contains(tempStrings[i]) == false) {
                specFeatString.add(tempStrings[i]);
            }
        }*/ 
        this.special_features = special_features;
    }

    public Set<Film_actor> getFilm_actors() {
        return film_actors;
    }

    public void setFilm_actors(Set<Film_actor> film_actors) {
        this.film_actors = film_actors;
    }

    /*public Set<Film_category> getCategories() {
        return film_categories;
    }

    public void setCategories(Set<Film_category> film_categories) {
        this.film_categories = film_categories;
    }*/ //didn't get it right

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
    
    

    public Film() {
    }
    
    public Film(String title, Language language, Short rental_duration, BigDecimal rental_rate, BigDecimal replacement_cost, LocalDateTime last_update) {
        this.title = title;
        this.language = language;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.replacement_cost = replacement_cost;
        this.last_update = last_update;
    }
    //public Film(Language languageByLanguageId, Language languageByOriginalLanguageId, String title, String description, Date releaseYear, byte rentalDuration, BigDecimal rentalRate, Short length, BigDecimal replacementCost, String rating, String specialFeatures, Date lastUpdate, Set inventories) {
    //int film_id,  //Set<String> specFeatString, //Set<Film_actor> film_actors, Set<Film_category> film_categories, 
    public Film(String title, String description, short release_year, Language language, Language language2, Short rental_duration, BigDecimal rental_rate, Short length, BigDecimal replacement_cost, String rating, String special_features, LocalDateTime last_update, Set<Inventory> inventories) {
        //this.film_id = film_id;
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
        //this.specFeatString = specFeatString;
        this.special_features = special_features;
        //this.film_actors = film_actors;
        //this.film_categories = film_categories;
        this.last_update = last_update;
        this.inventories = inventories;
    }
    
    //added by me#1
    public Film(int film_id, String title, String description, short release_year, Language language, Language language2, Short rental_duration, BigDecimal rental_rate, Short length, BigDecimal replacement_cost, String rating, String special_features, LocalDateTime last_update) {
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
    //added by me#2
    public Film(int film_id, String title, String description, short release_year, Language language, Language language2, Short rental_duration, BigDecimal rental_rate, Short length, BigDecimal replacement_cost, String rating, String special_features, LocalDateTime last_update, Set<Inventory> inventories) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.film_id;
        hash = 67 * hash + Objects.hashCode(this.title);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.release_year);
        hash = 67 * hash + Objects.hashCode(this.language);
        hash = 67 * hash + Objects.hashCode(this.language2);
        hash = 67 * hash + Objects.hashCode(this.rental_duration);
        hash = 67 * hash + Objects.hashCode(this.rental_rate);
        hash = 67 * hash + Objects.hashCode(this.length);
        hash = 67 * hash + Objects.hashCode(this.replacement_cost);
        hash = 67 * hash + Objects.hashCode(this.rating);
        hash = 67 * hash + Objects.hashCode(this.special_features);
        hash = 67 * hash + Objects.hashCode(this.film_actors);
        hash = 67 * hash + Objects.hashCode(this.film_categories);
        hash = 67 * hash + Objects.hashCode(this.last_update);
        hash = 67 * hash + Objects.hashCode(this.inventories);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Film other = (Film) obj;
        if (this.film_id != other.film_id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.special_features, other.special_features)) {
            return false;
        }
        if (!Objects.equals(this.release_year, other.release_year)) {
            return false;
        }
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        if (!Objects.equals(this.language2, other.language2)) {
            return false;
        }
        if (!Objects.equals(this.rental_duration, other.rental_duration)) {
            return false;
        }
        if (!Objects.equals(this.rental_rate, other.rental_rate)) {
            return false;
        }
        if (!Objects.equals(this.length, other.length)) {
            return false;
        }
        if (!Objects.equals(this.replacement_cost, other.replacement_cost)) {
            return false;
        }
        if (!Objects.equals(this.film_actors, other.film_actors)) {
            return false;
        }
        if (!Objects.equals(this.film_categories, other.film_categories)) {
            return false;
        }
        if (!Objects.equals(this.last_update, other.last_update)) {
            return false;
        }
        if (!Objects.equals(this.inventories, other.inventories)) {
            return false;
        }
        return true;
    }

    
    
    
}
