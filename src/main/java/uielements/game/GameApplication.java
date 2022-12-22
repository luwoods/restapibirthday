package uielements.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.time.*;
import java.util.*;
import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;


@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class GameApplication {


	@Autowired
	private ActorRepository actorRepository;
	private FilmRepository filmRepository;

	public GameApplication(ActorRepository ar, FilmRepository fr){
		actorRepository=ar; filmRepository=fr;
	}

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
	}
	@GetMapping("/allactors")
	public @ResponseBody List<Actor> getAllActors(){
		return actorRepository.findAll();
	}
	@GetMapping("/oneactor/{id}")
	public @ResponseBody Actor getOneActor(@PathVariable int id)
			 {

		Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new ResourceAccessException("Employee not found for this id :: " + id));

		return actor;}

	@PutMapping("/update_one_actor/{id}")
	Optional<Actor> updateActor(@RequestBody Actor newActor, @PathVariable int id) {
		return actorRepository.findById(id)
				.map(actor -> {
					newActor.getActorid();
					return actorRepository.save(newActor);
				});
	}

	@PostMapping("/newactor")
	Actor addNewActor(@RequestBody Actor newActor){
		return actorRepository.save(newActor);
	}
	@DeleteMapping(value = "/removeactor/{id}")
	public String deletePost(@PathVariable int id) {
			Actor actor = actorRepository.findById(id)
					.orElseThrow(() -> new ResourceAccessException("Employee not found for this id :: " + id));


		return "Delete called for actor " + actor.getFirst_name() + " " + actor.getLast_name();

		//actorRepository.delete(actor);
	}
	@GetMapping("/GetRelFilm/{id}")
	public @ResponseBody Iterable<FilmsFromActors>getFilmsRel(@PathVariable int id) throws Exception {
		Actor actor = getOneActor(id);
		ArrayList<FilmsFromActors> filmsFromActors = new ArrayList<FilmsFromActors>();
		for(Film filmcount: actor.getFilms()){
			filmsFromActors.add(new FilmsFromActors(filmcount,actor));
		}
				return filmsFromActors;
	}

	@GetMapping("/films")
	Iterable<Film> getAllFilms(){return filmRepository.findAll();}

	@GetMapping("/film/{id}")
	public @ResponseBody Optional<Film> getOneFilm(@PathVariable int id) {
		return filmRepository.findById(id);
	}

	@PutMapping("/genbds/")
	Iterable<Actor> genbds() {
		List<Actor> allActors = actorRepository.findAll();
		int totalActors = allActors.size();
		Instant today = Instant.now();
		ZoneId zoneId = ZoneId.of( "America/Montreal" );
		ZonedDateTime zdt = ZonedDateTime.ofInstant( today , zoneId );
		Instant TwentyYears = zdt.minusYears(20).toInstant();
		Instant HundredYears = zdt.minusYears(100).toInstant();
		Instant newBD;
		for (Actor allActor : allActors) {
			newBD = GenRanDate(HundredYears, TwentyYears); // Actors GENERALLY will be between 20 and 100 years of age so the famous ones will be too
			LocalDate localDate = LocalDate.ofInstant(newBD, ZoneId.systemDefault());
			Date sendBD = Date.valueOf(localDate);
			allActor.setBirthday(sendBD);
			actorRepository.save(allActor);
		}
		return actorRepository.findAll();
	}

	@RequestMapping(value="/postBD", method=RequestMethod.POST)
	public SendActors post(@RequestBody GetBirthday input) {

		java.util.Date birthday = input.getDate();
		SendActors sendActors = new SendActors();
		List<Actor> allActors = actorRepository.findAll();

		for (Actor allActor : allActors) {

			java.util.Date actorBD  = allActor.getBirthday();
			LocalDate localDateActorBD = ConvertToLocalDate(actorBD);
			LocalDate localDateBirthday = ConvertToLocalDate(birthday);

			if (CheckBirthdayIsEqual(localDateActorBD,localDateBirthday)){
				sendActors.addActor(allActor);
			}
		}
		return sendActors;
	}
	public static LocalDate ConvertToLocalDate(java.util.Date date){
		return  Instant.ofEpochMilli(date.getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}

	public static Instant GenRanDate(Instant startDate, Instant endDate) {
			long startSeconds = startDate.getEpochSecond();
			long endSeconds = endDate.getEpochSecond();
			long random = ThreadLocalRandom
					.current()
					.nextLong(startSeconds, endSeconds);

			return Instant.ofEpochSecond(random);
		}

	public static boolean CheckBirthdayIsEqual (LocalDate date1, LocalDate date2){
		int a = date1.getDayOfMonth();
		int b = date2.getDayOfMonth();
		Month c = date1.getMonth();
		Month d = date2.getMonth();
		return (a == b)&&(c.equals(d));
	}
}