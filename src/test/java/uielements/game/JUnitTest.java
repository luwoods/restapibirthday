package uielements.game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class JUnitTest {
    @Test
    public void testConstructor() {
    }
    @Test
    public void testActorsAndSetters(){
        Actor actor1 = new Actor();
        actor1.setActorid(5);
        Assertions.assertEquals(5,actor1.getActorid(), "Actor id error");
        actor1.setFirst_name("Firstnametest");
        Assertions.assertEquals("Firstnametest",actor1.getFirst_name(), "First name error");
        actor1.setLast_name("Lastnametest");
        Assertions.assertEquals("Lastnametest",actor1.getLast_name(), "Last name error");
        actor1.setBirthday(Date.valueOf("1900-01-01"));
        Assertions.assertEquals(Date.valueOf("1900-01-01"),actor1.getBirthday(),"Birthday setter/getter error");
        Film film1=new Film();
        Film film2 = new Film();
        List<Film> films = new ArrayList<>();
        films.add(film1);
        films.add(film2);
        actor1.setFilms(films);
        Assertions.assertEquals(films, actor1.getFilms(),"Films list error");
    }
    @Test
    public void filmGetter(){
        Film film = new Film();
        film.setFilmid(1);
        Assertions.assertEquals(1,film.getFilmid(),"Film ID error");
        film.setTitle("Title");
        Assertions.assertEquals("Title",film.getTitle(), "title error");
        film.setRating("PG");
        Assertions.assertEquals("PG",film.getRating(), "Rating error");
        Actor actor1 = new Actor();
        Actor actor2= new Actor();
        List<Actor> actors = new ArrayList<Actor>();
        actors.add(actor1);
        actors.add(actor2);
        film.setActors(actors);
        Assertions.assertEquals(actors,film.getActors(),"Birthday setter/getter error");
    }
}