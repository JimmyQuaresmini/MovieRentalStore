package moviestore.repositories;

import moviestore.entities.Staff;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jimmy
 */

public interface StaffRepository extends CrudRepository<Staff, Integer> {
    
}
