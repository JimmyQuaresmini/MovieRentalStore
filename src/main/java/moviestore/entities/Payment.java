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
public class Payment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int payment_id;
    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName="customer_id")
    private Customer customer; 
    @ManyToOne
    @JoinColumn(name="staff_id", referencedColumnName="staff_id")
    private Staff staff; 
    @ManyToOne
    @JoinColumn(name="rental_id", nullable=false, referencedColumnName="rental_id")
    private Rental rental; 
    private float amount;
    private LocalDateTime payment_date;
    private LocalDateTime last_update;
    
    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public Customer getCustomer() { 
        return customer; 
    }

    public void setCustomer(Customer customer) { 
        this.customer = customer; 
    }

    public Staff getStaff() { 
        return staff; 
    }

    public void setStaff(Staff staff) { 
        this.staff = staff; 
    }

    public Rental getRental_id() { 
        return rental; 
    }

    public void setRental(Rental rental) { 
        this.rental = rental; 
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDateTime getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDateTime payment_date) {
        this.payment_date = payment_date;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }    
}
