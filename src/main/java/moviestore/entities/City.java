package moviestore.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jimmy
 */

@Entity
public class City {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int city_id;
    private String city;
    @ManyToOne
    @JoinColumn(name="country_id", referencedColumnName="country_id")
    private Country country; 
    private LocalDateTime last_update;

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public Country getCountry() { 
        return country; 
    }

    public void setCountry(Country country) { 
        this.country = country; 
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
}
