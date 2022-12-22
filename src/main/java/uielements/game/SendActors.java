package uielements.game;
import java.util.ArrayList;
import java.util.List;



public class SendActors {
    private List<Actor> actorList = new ArrayList<>();

    public SendActors() {
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }
    public void addActor(Actor actor) {

        actorList.add(actor);
        return;
    }
}