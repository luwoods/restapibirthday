package uielements.game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;

public class JUnitTest {
    @Test
    public void testConstructor() {
    }
    @Test
    public void testGettersAndSetters(){
        Actor actor1 = new Actor();
        actor1.setActorid(5);
        Assertions.assertEquals(5,actor1.getActorid(), "Actor id error");
        actor1.setFirst_name("Firstnametest");
        Assertions.assertEquals("Firstnametest",actor1.getFirst_name(), "First name error");
        actor1.setLast_name("Lastnametest");
        Assertions.assertEquals("Lastnametest",actor1.getLast_name(), "Last name error");
        actor1.setBirthday(Date.valueOf("1900-01-01"));
        Assertions.assertEquals(Date.valueOf("1900-01-01"),actor1.getBirthday(),"Birthday setter/getter error");
    }

}