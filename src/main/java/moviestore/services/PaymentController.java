package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Customer;
import moviestore.entities.Payment;
import moviestore.entities.Rental;
import moviestore.entities.Staff;
import moviestore.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jimmy
 */

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;
    
    @GetMapping("/all")
    public Iterable<Payment> getAllStaff() { 
        return paymentRepository.findAll();
    }
    
    @GetMapping("/add")
    public String addPayment(@RequestParam int id, @RequestParam Customer customer, 
            @RequestParam Staff staff, @RequestParam Rental rental, @RequestParam float amount, 
            @RequestParam LocalDateTime payment_date, @RequestParam LocalDateTime updated) {
        Payment p = new Payment();
        p.setPayment_id(id);
        p.setCustomer(customer); 
        p.setStaff(staff); 
        p.setRental(rental); 
        p.setAmount(amount);
        p.setPayment_date(payment_date);
        p.setLast_update(updated);
        paymentRepository.save(p);
        return "Saved payment";
    }
    
}
