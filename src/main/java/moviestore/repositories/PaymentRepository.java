package moviestore.repositories;

import moviestore.entities.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jimmy
 */

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
    
}
