/* 
 **
 ** Copyright 2014, 
 ** Carlos Andres Jimenez
 ** apps@carlosandresjimenez.co
 ** 
 */
package org.coursera.mutibosvc;

import java.util.Collection;
import org.coursera.mutibosvc.beans.QuestionSet;

import com.google.api.client.util.Lists;

public class TestData {

	static Collection<QuestionSet> qsets;
	
	public static Collection<QuestionSet> fillCollection() {

		qsets = Lists.newArrayList();
		qsets.add(new QuestionSet("American Pie","Mean Girls","Titanic","The Breakfast Club",3,"Genre","Titanic is not a High school movie",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Hunger Games","Breakfast at Tiffany's","Slumdog Millionaire","Django Unchained",2,"Age","While the others movies are quite recent, Breakfast at Tiffany's is a very old movie",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Unbreakable","The Sixth Sense","The Village","12 Monkeys",4,"Director","12 Monkeys is not a movie by M. Night Shyamalan",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Monsters Inc.","Toy Story","Shrek","Finding Nemo",3,"Studio","Shrek is not a movie by Pixar",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Zombieland","Saw","Dawn of the Dead","28 Days Later",2,"Subgenre","Saw is not a zombie movie",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Shining","Pet Sematary","It","Poltergeist",4,"Writer","Poltergeist is not based on a Stephen King book",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Matrix","X-Men: Days of Future Past","Forrest Gump","Lucy",3,"Genre","Forrest Gump is not a science Fiction movie",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Taken","Run","Leon: The Professional","The Transporter",3,"Director","Leon: The Professional is not a movie by Luc Besson",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Mad Max","The Year of Living Dangerously","Braveheart","Revolutionary Road",4,"Actor","Mel Gibson does not appear in Revolutionary Road",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Avatar","Spider-man","Superman","My Name is Khan",4,"Origin","My Name is Khan is the only Bollywood movie",0,0,0,0,0,0));
		qsets.add(new QuestionSet("House of Wax","Cast Away","Paa","What Lies Beneath",3,"Origin","Paa is the only Bollywood movie",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Maverick","Rounders","21","Good Will Hunting",4,"Genre","Good Will Hunting is not a card movie",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Red State","Clerks","Tusk","Office Space",4,"Director","Kevin Smith has directed all the movies except Office Space.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Titanic","Gladiator","American Beauty","King's Speech",1,"Oscar Win","All the rest, won best movie and best Actor",0,0,0,0,0,0));
		qsets.add(new QuestionSet("München","The Last King of Scotland","Argo","The Town",4,"Background","The Town is the only one not based on a real life event",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Matador","GoldenEye","Moonraker","Dr. No",1,"Character","The Matador is not a James Bond movie",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Pledge","The Wolf of Wall Street","Mars Attacks!","One Flew Over the Cuckoo's Nest",2,"Actor","The Wolf of Wall Street is the only one without Jack Nicholson",0,0,0,0,0,0));
		qsets.add(new QuestionSet("JFK","Sleepers","Goodfellas","A Few Good Men",3,"Actor","Kevin Bacon does not appear in Goodfellas.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Ghosts of Mississippi","JFK","This is Spinal Tap","Stand By Me",2,"Director","Rob Reiner did not direct JFK.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Tom Jones","Rocky","Citizen Kane","The Greatest Show on Earth",3,"Oscar Win","Citizen Kane did not win Best Picture",0,0,0,0,0,0));
		qsets.add(new QuestionSet("James Mason","Cary Grant","Rod Taylor","Sean Connery",4,"Actor","All but Sean Connery turned down the James Bond role.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Waterworld","Gigli","The Postman","Mars Needs Moms",1,"Success","While Waterworld is considered a flop, it actually turned a significant profit. The others lost money.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Superman","Batman","Spider-man","Hulk",2,"Story","Batman does not have any \"super\" powers",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Thomas Crowne Affair","Entrapment","Cowboys & Aliens","Master and Commander: The Far Side of the World",4,"Actor","All but Master and Commander: The Far Side of the World featured an actor who played James Bond",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Kill Bill Vol. 1","Reservoir Dogs","Inglourious Basterds","Schindler's List",4,"Director","Quentin Tarantino did not worked in Schindler's List",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Jaws","E.T.","Jurassic Park","King Kong",4,"Director","King Kong was not directed by Steven Spielberg",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Terminator","Commando","Rocky","Predator",3,"Actor","Arnold Schwarzenegger was not in Rocky",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Saving Private Ryan","Black Hawk Down","La Vita e bella","The thin red line",2,"Subgenre","Black Hawk Down is not set in World War II",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Roman Polanski","Stanley Kubric","Steven Spielberg","Martin Scorcese",2,"Director","All but Stanley Kubric are alive",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Matrix","Pulp Fiction","Mad Max","The Godfather",2,"Movie Trilogy","Pulp Fiction is the only one not part of a trilogy",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Black Swan","Melancholia","Virgin Suicides","Marie Antoinette",1,"Actor","Black Swan is starred by Natalie Portman while the others are starred by Kirsten Dunst",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Training Day","Man on Fire","Departed","Deja Vu",3,"Actor","Denzel Washington does not appear in Departed",0,0,0,0,0,0));
		qsets.add(new QuestionSet("A Dangerous Method","Inglourious Basterds","Prometheus","The Grand Budapest Hotel",4,"Actor","Michael Fassbender appears in all but The Grand Budapest Hotel where Ralph Fiennes stars",0,0,0,0,0,0));
		qsets.add(new QuestionSet("X-Men","X-Men 2","X-Men: The Last Stand","X-Men: Days of Future Past",3,"Director","All but X-Men: Last Stand were directed by Bryan Singer",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Fellowship of the Ring","The Two Towers","The Return of the King","An Unexpected Journey",4,"Series","An Unexpected Journey is part of The Hobbit trilogy",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Moneyball","World War Z","Megamind","Mission: Impossible - Ghost Protocol",4,"Actor","Brad Pitt did not appear in Mission: Impossible - Ghost Protocol",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Dark Knight Rises","The Avengers","The Amazing Spider-Man","The Incredible Hulk",4,"Year","All but The Incredible Hulk are 2012 movies",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Iron Man","The Amazing Spider-Man","Captain America: The First Avenger","The Dark Knight",4,"Publisher","All but The Dark Knight are part of the Marvel Universe",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Carrie","Alien","Saw","Titanic",4,"Genre","All but Titanic are Horrors",0,0,0,0,0,0));
		qsets.add(new QuestionSet("12 Monkeys","Mr. Nobody","Butterfly Effect","The Aviator",4,"Theme","All but The Aviator involve time travelling plots",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Family Guy","American Dad","Cleveland Show","South Park",4,"Creator","All but South Park are created by Seth MacFarlene",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Horrible Bosses","Minority Report","In Bruges","The Departed",4,"Actor","Colin Farrell did not appear in The Departed",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Hunger Games","Kill Bill","Salt","The Social Network",4,"Actor","All but The Social Network have a female lead role",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Total Recall","Dredd","Alien","Back to the Future",4,"Time","All but Back to the Future I take place in the future",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Godfather","Scarface","Dog Day Afternoon","Casino",4,"Actor","Al Pacino does not appear on Casino",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Goodfellas","Casino","Taxi Driver","Scarface",4,"Actor","Robert de Niro does not apppear on Scarface",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Exodus: Gods and Kings","Ben Hur","The Passion of Christ","Cleopatra",4,"Theme","All but Cleopatra were based on biblical stories",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Charade","Psycho","Rear Window","Vertigo",1,"Director","All but Charade were directed by Alfred Hitchcock",0,0,0,0,0,0));
		qsets.add(new QuestionSet("2001: A space Odyssey","20,000 Leagues Under the Sea","2012","2010: Moby Dick",2,"Title","Distance, not time",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Harry Potter and the Philosopher's Stone","Harry Potter and the Chamber of Secrets","Harry Potter and the Prisoner of Azkaban","First Blood",4,"Theme","All but First Blood are Harry Potter movies.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Resident Evil","The Fifth Element","The Three Musketeers","Sin City",4,"Actor","Milla Jovovich does not appear in Sin City",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Goal","Escape to Victory","The Game of their Lives","Any Given Sunday",4,"Theme","All but Any Given Sunday are about football",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Ender's Game","Star Wars - A new Hope","The Punisher","Star Trek II - Wrath of Khan",3,"Theme","All the movies but The Punisher are Science-Fiction movies.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Apocalypse Now","Guadalcanal","Midway","Patton",1,"Theme","All the films but the first one are related to the WWII",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Ben-Hur: A Tale of the Christ","Citizen Kane","The Plastic Age","Gone With The Wind",2,"Actor","All but Citizen Kane were starred by Clark Gable",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Dirty Dancing","Commando","The Goonies","The Return of the Living Dead",1,"Year","All but Dirty Dancing were released in 1985",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Bean","Scooby-Doo","Scooby-Doo 2: Monsters Unleashed","Rat Race",3,"Actor","Rowan Atkinson did not appear in Scooby-Doo 2.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Toy Story","Cars","Finding Nemo","Elfen Lied",4,"Genre","Elfen Lied is anime",0,0,0,0,0,0));
		qsets.add(new QuestionSet("True Lies","Red Heat","Rambo","Terminator",3,"Actor","Arnold Schwarzenegger does not appear in Rambo",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Frankenweenie","The Corpse Bride","The Nightmare Before Christmas","Coraline",4,"Director","All but Coraline were directed by Tim Burton",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Sixteen Candles","The Breakfast Club","War Games","Ferris Bueller's Day Off",3,"Director","All but War Games were directed by John Hughes",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Rock and Rule","American Pop","Wizards","Fire and Ice",1,"Director","All but Rock and Rule were directed by Ralph Bakshi",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Gung Ho","Parenthood","Mr Mom","Beetlejuice",2,"Actor","Michael Keaton did not appear in Parenthood",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Wind Rises","My Neighbor Totoro","Tales from Earthsea","Porco Rosso",3,"Director","All but Tales from Earthsea were directed by Hayao Miyazaki",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Number 4","The Number 2","The Number 23","The Number 6",3,"Title","The number 23 is an actual movie title.   It's also the only odd number.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Frozen","Cinderella","Snow White","True Grit",4,"Genre","True Grit is the only western.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("True Grit","Blazing Saddles","Dances With Wolves","The Lion King",4,"Genre","All are westerns except for The Lion King",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Da Vinci Code","Amelie","Sabrina","The Fifth Element",4,"Location","All are set in Paris except the Fifth Element",0,0,0,0,0,0));
		qsets.add(new QuestionSet("A Fistful of Dollars","For a Few Dollars More","The Good, the Bad and the Ugly","Once Upon a Time in America",4,"Movie Trilogy","Once Upon a Time in America is the only one not part of the Dollars Trilogy",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Star Trek: First Contact","Star Trek: The Motion Picture","Star Trek II: The Wrath of Khan","Star Trek III: The Search for Spock",1,"Actor","The other three movies all starred William Shatner.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("The Truman Show","The Godfather","Ace Ventura: Pet Detective","Dumb & Dumber",2,"Actor","The other three movies all starred Jim Carrey.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Skyfall","Casino Royale","The Terminator","The Spy Who Loved Me",3,"Genre","The other three movies are James Bond films.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Captain Phillips","Argo","The Artist","The King's Speech",1,"Oscar Win","The other three movies all won Academy Awards for Best Picture.",0,0,0,0,0,0));
		qsets.add(new QuestionSet("Despicable Me","Toy Story","The Lion King","Back to The Future",4,"Genre","The other three movies are animated productions.",0,0,0,0,0,0));
		
		return qsets;

	}

}
