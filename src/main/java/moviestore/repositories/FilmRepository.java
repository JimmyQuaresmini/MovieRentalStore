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
    
    /*@Query("SELECT new Film(f.title, f.release_year, a.last_name) FROM Film f INNER JOIN f.actors a")
    List<Film> findFilmsInnerJoinedActors();*/
    
    @Query("SELECT a.first_name, a.last_name, f.title FROM Film f JOIN f.actors a WHERE f.film_id = :id ORDER BY f.title")
    List<String> findActorTitleById(@Param("id") int id); 
    
    //@Query("SELECT a FROM Film f JOIN f.actors a WHERE f.film_id = :id ORDER BY a.last_name")
    @Query("SELECT a.first_name, a.last_name, f.title FROM Film f JOIN f.actors a WHERE f.film_id = :id ORDER BY a.last_name")
    List<Object> findActorsFilmsByIdJoined(@Param("id") int id);
    
    @Query("SELECT f.title, f.description, c.name FROM Film f JOIN f.categories c WHERE f.film_id = :id ORDER BY c.name")
    List<String> findFilmCategoriesByIdJoined(@Param("id") int id);
    
    /*@Query("SELECT new Film(f.title, f.description, f.release_year, f.language, f.language2, f.rental_duration, f.rental_rate, " +
            "f.length, f.replacement_cost, f.rating, f.special_features, f.categories, f.last_update) " + 
            "FROM Film f INNER JOIN f.actors a") //, a.last_name
    List<Object> findFilmsInnerJoinedActors();*/  //Film
    
    @Query("SELECT a FROM Film f JOIN f.actors a") 
    List<Object> findActorsInFilmsInnerJoinedExplicit();
}
