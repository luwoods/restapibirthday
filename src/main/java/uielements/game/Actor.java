package uielements.game;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;


@Entity(name="Actor")
@Table(name="actor")
public class Actor {
    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actorid;
    @Column(name = "first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name = "birthday")
    private java.sql.Date birthday;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JsonIgnore
    @JoinTable(name = "film_actor",
            joinColumns = {
            @JoinColumn(name="actor_id",referencedColumnName = "actor_id",
                    nullable = false, updatable = false)},
            inverseJoinColumns = {
            @JoinColumn(name="film_id", referencedColumnName = "film_id",
            nullable = false,updatable = false)
            }
    )
    private List<Film> films = new ArrayList<>();

    public Actor(){}
    public Actor(String ln, String fn, java.sql.Date BD){
        last_name=ln;
        first_name=fn;
        birthday =BD;
    }

    public String getLast_name() {
        return last_name;
    }

    public long getActorid() {
        return actorid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setActorid(long actorid) {
        this.actorid = actorid;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday){
        this.birthday=birthday;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}

