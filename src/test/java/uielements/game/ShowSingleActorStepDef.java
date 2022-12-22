package uielements.game;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

@ScenarioScope
public class ShowSingleActorStepDef {
    @Autowired
    ActorRepository actorRepository;
    int actorID;
    Actor chosenActor;
    @Given("an actor exists with id {int}")
    public void an_actor_exists_with_id(int id){
        actorID=id;
        actorRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Actor id does not exist:"+id));

    }
    @When("I request an actors details")
    public void I_request_an_actor_details(){
        chosenActor = actorRepository.findById(actorID)
                .orElseThrow(() -> new ResourceAccessException("Actor id does not exist"));
        Assertions.assertNotEquals(null,chosenActor, "Actor was not retrieved");
    }
    @Then("the webpage should show the actors {string} and {string}")
    public void the_webpage_should_show_the_actors_first_name_and_last_name (String FN, String LN){
        String correctDetails = FN + " "+LN;
        String testDetails = chosenActor.getFirst_name() + " " + chosenActor.getLast_name();
        Assertions.assertEquals(correctDetails,testDetails,"The test returned "+testDetails+" and mismatched");
    }

}
