package moviestore.repositories;

import java.util.List;
import moviestore.entities.Film_actor;
import moviestore.entities.Film_actorPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface Film_actorRepository extends CrudRepository<Film_actor, Film_actorPK> { 
    //from FilmRepository:    
    @Query("SELECT a.first_name, a.last_name, f.title FROM Film_actor fa JOIN fa.actor a JOIN fa.film f WHERE " + 
            "f.release_year = :year ORDER BY f.title")
    List<String> findActorTitleByYear(@Param("year") Short year); 
    
    /*@Query("SELECT new Film(f.title, f.release_year, a.last_name) FROM Film f INNER JOIN f.actors a")
    List<Film> findFilmsInnerJoinedActors();*/
        
    @Query("SELECT a.first_name, a.last_name, f.title FROM Film_actor fa JOIN fa.film f JOIN fa.actor a " + 
            "WHERE f.film_id = :id ORDER BY f.title")
    List<String> findActorTitleById(@Param("id") int id); 
        
    @Query("SELECT a.first_name, a.last_name, f.title FROM Film_actor fa JOIN fa.film f JOIN fa.actor a WHERE f.film_id = :id " + 
            "ORDER BY a.last_name")
    List<Object> findActorsFilmsByIdJoined(@Param("id") int id);
}
