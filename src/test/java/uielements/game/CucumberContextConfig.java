package uielements.game;

import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.internal.Classes;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes= GameApplication.class)



public class CucumberContextConfig {
}
