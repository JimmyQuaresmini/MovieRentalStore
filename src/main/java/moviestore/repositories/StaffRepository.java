package moviestore.repositories;

import moviestore.entities.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface StaffRepository extends CrudRepository<Staff, Integer> {
    
}
