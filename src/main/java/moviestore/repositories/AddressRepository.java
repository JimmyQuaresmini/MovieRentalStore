package moviestore.repositories;

import moviestore.entities.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
    @Query("SELECT a FROM Address a WHERE a.address = :addressName")
    Address findAddressByName(@Param("addressName") String addressName);
}
