package uielements.game;
import io.cucumber.java.bs.A;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.sql.Date;
import java.time.LocalDate;
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
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        Actor actor2 = new Actor("test2","test1", date);
        Film film1=new Film();
        Film film2 = new Film();
        List<Film> films = new ArrayList<>();
        films.add(film1);
        films.add(film2);
        actor1.setFilms(films);
        Assertions.assertEquals(films, actor1.getFilms(),"Films list error");
        Assertions.assertEquals("test1",actor2.getFirst_name(),"Actor firstname ");
        Assertions.assertEquals("test2",actor2.getLast_name(),"Actor lastname");
        Assertions.assertEquals(date,actor2.getBirthday(),"Birthday error");
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
    @Test
    public void getBirthdayTester(){
        GetBirthday getBirthday = new GetBirthday();
        Date date = Date.valueOf("1900-01-01");
        getBirthday.setDate(date);
        Assertions.assertEquals(date,getBirthday.getDate(),"Get birthday error");
    }
    @Test
    public void testFilmsFromActor(){
        FilmsFromActors films = new FilmsFromActors();
        films.setFirst_name("1");
        films.setLast_name("2");
        films.setTitle("3");
        Assertions.assertEquals("1",films.getFirst_name(),"First name error");
        Assertions.assertEquals("2",films.getLast_name(),"Last name error");
        Assertions.assertEquals("3",films.getTitle(),"Title error");
    }
    @Test
    public void sendActorTest(){
        SendActors sends = new SendActors();
        Actor actor1 = new Actor();
        Actor actor2= new Actor();
        sends.addActor(actor1);
        sends.addActor(actor2);
        List<Actor> actors = new ArrayList<>();
        actors.add(actor1);
        actors.add(actor2);
        Assertions.assertEquals(actors,sends.getActorList(),"Send actors getter/adder error");
        sends.setActorList(actors);
        Assertions.assertEquals(actors,sends.getActorList(),"Send actors setter error");
    }
    @Test
    public void filmConstructor(){
        Actor actor = new Actor();
        Actor actor1 = new Actor();
        List<Actor> actors = new ArrayList<>();
        actors.add(actor);
        actors.add(actor1);
        Film film = new Film("test1","test2",actors);
        Assertions.assertEquals("test1",film.getTitle(),"Title error");
        Assertions.assertEquals("test2",film.getRating(),"ratingerror");
        Assertions.assertEquals(actors,film.getActors(),"constructor actor list error");
    }
}