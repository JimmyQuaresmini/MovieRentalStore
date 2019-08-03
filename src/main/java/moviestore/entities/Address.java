package moviestore.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jimmy
 */

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int address_id;
    private String address;
    private String address2;
    private String district;
    @ManyToOne
    @JoinColumn(name="city_id", referencedColumnName="city_id")
    private City city; 
    @Column(nullable = true)
    private String postal_code;
    @Column(nullable = true)
    private Long phone; //String   
    private byte[] location;
    private LocalDateTime last_update;

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }    
    
    public City getCity() { 
        return city; 
    }

    public void setCity(City city) { 
        this.city = city; 
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public Long getPhone() { //String
        return phone;
    }

    public void setPhone(Long phone) { //String
        this.phone = phone;
    }

    public byte[] getLocation() { 
        return location;
    }

    public void setLocation(byte[] location) { 
        this.location = location;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
    
    public Address() {
        
    }
    
    public Address(City city, String address, String district, Long phone, byte[] location, LocalDateTime lastUpdate) {
        this.city = city;        
        this.address = address;
        this.district = district;
        this.phone = phone;
        this.location = location;
        this.last_update = lastUpdate;
    }
    
    public Address(City city, String address, String address2, String district, String postalCode, Long phone, byte[] location, LocalDateTime lastUpdate) {
       this.city = city;    
       this.address = address;
       this.address2 = address2;
       this.district = district;
       this.postal_code = postalCode;
       this.phone = phone;
       this.location = location;
       this.last_update = lastUpdate;
    }
        
    //all posts seem to have address, district, city(_id), location(blob) and last_update(apart from id)
    public Address(String address, City city, String postal_code) {
        this.address = address;
        this.city = city;
        this.postal_code = postal_code;
        
        district = "My District";
        phone = 199514580428L;
        //this byte[] is for address id 602 in West Greece just to compare or use temporarily
        location = new byte[]{0, 0, 0, 0, 1, 1, 0, 0, 0, -86, -63, -22, 126, 4, -68, 53, 64, -26, 95, 38, -27, 73, 31, 67, 64};
        last_update = LocalDateTime.now();
    }
    
    
}
