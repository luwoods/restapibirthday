package uielements.game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface FilmRepository extends JpaRepository<Film,Integer>  {
}
