package moviestore.repositories;

import java.util.List;
import moviestore.entities.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Jimmy
 */

public interface FilmRepository extends CrudRepository<Film, Integer> {
    @Query("SELECT f.title FROM Film f WHERE f.film_id = :id")
    String findTitleById(@Param("id") int id);
    
    @Query("SELECT a.first_name, a.last_name, f.title FROM Film f JOIN f.actors a WHERE f.release_year = :year ORDER BY f.title")
    List<Film> findActorTitleByYear(@Param("year") short year);
    
    /*@Query("SELECT new moviestore.entities.Film(f.title, f.release_year, a.last_name) FROM Film f INNER JOIN f.actors a")
    List<Film> findFilmsInnerJoinedActors();*/
    
    @Query("SELECT a.first_name, a.last_name, f.title FROM Film f JOIN f.actors a WHERE f.film_id = :id ORDER BY f.title")
    List<String> findActorTitleById(@Param("id") int id); 
}
