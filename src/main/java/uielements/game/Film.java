package uielements.game;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@Entity
@Table(name="film")
public class Film {
    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmid;
    @JsonIgnore
    @ManyToMany(mappedBy = "films", fetch = FetchType.LAZY)
    private List<Actor> actors ;

    @Column(name = "title")
    private String title;
    @Column(name = "rating")
    private String rating;

    public Film() {
    }

    public Film(String t, String r, List<Actor> actors) {
        title = t;
        rating = r;
        this.actors = actors;
    }

    public int getFilmid() {        return filmid;    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}


