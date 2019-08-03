package moviestore.controllers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import moviestore.entities.Customer;
import moviestore.entities.Payment;
import moviestore.entities.Rental;
import moviestore.entities.Staff;
import moviestore.services.PaymentService;
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
    private PaymentService paymentService;
    
    @GetMapping("/all")
    public Iterable<Payment> getAllStaff() { 
        return paymentService.getAllPayments();
    }
    
    @GetMapping("/add")
    public String addPayment(@RequestParam int id, @RequestParam Customer customer, 
            @RequestParam Staff staff, @RequestParam Rental rental, @RequestParam BigDecimal amount, 
            @RequestParam LocalDateTime payment_date, @RequestParam LocalDateTime updated) {        
        paymentService.savePayment(id, customer, staff, rental, amount, payment_date, updated);
        return "Saved payment";
    }
    
}
