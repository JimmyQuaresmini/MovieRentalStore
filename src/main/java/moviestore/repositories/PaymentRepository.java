package moviestore.repositories;

import moviestore.entities.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {
    
}
