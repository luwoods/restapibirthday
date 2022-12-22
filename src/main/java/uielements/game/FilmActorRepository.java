/*package uielements.game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface FilmActorRepository extends JpaRepository<FilmActor,Integer> {
    @Query(	"SELECT film.* FROM actor " +
            "INNER JOIN film_actor ON actor.actor_id = film_actor.actor_id " +
            "INNER JOIN film ON film_actor.film_id=film.film_id " +
            "WHERE actor.actor_id = :id;")

    public Iterable<Film> PullFromActorFilm(@Param("id") int id)


}*/

