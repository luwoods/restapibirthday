package uielements.game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ActorRepository extends JpaRepository<Actor,Integer> {

}
