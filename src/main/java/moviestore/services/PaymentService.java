package moviestore.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import moviestore.entities.Customer;
import moviestore.entities.Payment;
import moviestore.entities.Rental;
import moviestore.entities.Staff;
import moviestore.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    
    public Iterable<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    
    public void savePayment(int id, Customer customer, Staff staff, Rental rental, 
            BigDecimal amount, LocalDateTime payment_date, LocalDateTime updated) {
        Payment p = new Payment();
        p.setPayment_id(id);
        p.setCustomer(customer); 
        p.setStaff(staff); 
        p.setRental(rental); 
        p.setAmount(amount);
        p.setPayment_date(payment_date);
        p.setLast_update(updated);
        paymentRepository.save(p);
    }
    
    //used by RentalService when renting film
    public void savePaymentWithObject(Payment p) {
        paymentRepository.save(p);
    }
}
