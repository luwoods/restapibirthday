package uielements.game;

public class FilmsFromActors {
    private String title;
    private String last_name;
    private String first_name;
    FilmsFromActors(Film film, Actor actor){
        setTitle(film.getTitle());
        setFirst_name(actor.getFirst_name());
        setLast_name(actor.getLast_name());
    }
    FilmsFromActors(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
