package moviestore.repositories;

import java.util.List;
import moviestore.entities.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; //JpaRepository
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jimmy
 */

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> { 
    @Query("SELECT f.title FROM Film f WHERE f.film_id = :id")
    String findTitleById(@Param("id") int id);
    
    //moved 3 queries to Film_actorRepository after changes to the Many-to-Many relation
    
    //temporary
    //@Query("SELECT f.title, f.description, c.category_id.name FROM Film f JOIN f.film_categories c WHERE f.film_id = :id ORDER BY c.category_id.name")
    //List<String> findFilmCategoriesByIdJoined(@Param("id") int id);//den hittar inte "name" nu för det är i Category och inte i Film_category
    
    /*@Query("SELECT new Film(f.title, f.description, f.release_year, f.language, f.language2, f.rental_duration, f.rental_rate, " +
            "f.length, f.replacement_cost, f.rating, f.special_features, f.categories, f.last_update) " + 
            "FROM Film f INNER JOIN f.actors a") //, a.last_name
    List<Object> findFilmsInnerJoinedActors();*/  //Film
        
    //@Query("SELECT DISTINCT a FROM Film_actor fa INNER JOIN fa.actor a") //ordered by actor_id
    @Query("SELECT DISTINCT a FROM Film_actor fa LEFT JOIN fa.actor a") //outer, not ordered by actor_id
    List<Object> findActorsInFilmsInnerJoinedExplicit();
    
    //"SELECT ph FROM Employee e JOIN e.phones ph WHERE ph LIKE '1%'" //alias //wildcard    
    //"SELECT d FROM Employee e, Department d" //cartesian
    
}
