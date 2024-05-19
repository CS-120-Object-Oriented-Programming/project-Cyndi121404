import java.util.HashMap;

/**
 * This class represents the entire world that makes up the "Campus of Kings"
 * application. "Campus of Kings" is a very simple, text based adventure game.
 * Users can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 *
 * This world class creates the world where the game takes place.
 *
 * @author Maria Jump
 * @version 2015.02.01
 *
 * Used with permission from Dr. Maria Jump at Northeastern University
 */
public class World {
	/** The rooms in the world. */
	private HashMap<String, Room> rooms;

	/**
	 * Constructor for the world.
	 */
	public World() {
		rooms = new HashMap<String, Room>();
		createRooms();
	}

	/**
	 * This method takes care of creating all of the aspects of the world for
	 * the "Campus of Kings" application.
	 *
	 * @param name
	 *            The provided name of the room.
	 * @return The room associated with the provided name
	 */
	public Room getRoom(String name) {
		return rooms.get(name.toLowerCase());
	}

	/////////////////////////////////////////////////////////////////////////////////////
	// Start of private helper methods

	/**
	 * Helper method for recreating a Room. Ensure that the room is created and
	 * installed in to the collection of Rooms
	 *
	 * @param theRoom
	 *            The room to add to the world.
	 */
	private void addRoom(Room theRoom) {
		rooms.put(theRoom.getName().toLowerCase(), theRoom);
	}

	
	
	
	private void createDoor(Room from, String direction, Room to) {
		Door theDoor = new Door(to);
		from.setExit(direction, theDoor);
	}
	
	
	
	
	private void createRooms() {
		// Creating all the rooms.
		Room centerOfMaze = new Room("center of maze","You wake up and cannot recognize where you are. You cannot remember anything besides that your name is thomas. Through the new group of boys you met you discover that you are inside a maze. Every night the maze changes. Everyone is trying to discover a way out while trying to survive. If someone got  close to discovering the way out they end up sick and passing");
		Room monsterBattle = new Room("nasty monster","You have entered the maze with your new found brothers. It is the dead of night, a monster is after you. You must find a way to get you and your brothers out without being killed.");
		Room foundDoor = new Room("finding door","You may have found the door. A password must be answered. You must find the password to the door before the other monsters catch up with you. What could the password be?");
		Room runAway = new Room("running",",You were able to open the door! You must run through the door, find a way to get rid of the monsters, escape all with your new found family. What could possibly be a solution. ");
		Room whereDoor = new Room("finding door", "You enter a very long hallway that seems to stretch for miles. The walls are bland and it gives off an eerie feeling.  You start to run and come across multiple doors. Which door can it possibly be?");
		Room enterRoom = new Room("entering room","You Finally have gotten a door to open!! You enter a room with many computers, lab equipment and more. What could have possibly been happening in here you continue to move forward through the room.");
		Room video = new Room("watching Video",("A woman with white hair and wrinkly skin appears on a projector. You visualize people in the background that seem as though they are in a hurry for something hurriedly leaving. You then find out what the Rush Sickness is and everything else…."));
		Room rid = new Room("Destroy him","Mitch just Murdered Alex. He is aiming for you next. What is your next step?");
		Room kidnapped = new Room("hehehe","Multiple men armed start rushing in. They say they are Here to save you and rescue you. You must follow them to their helicopter outside and make a run for it. You step outside for the first time. The true outside and are surrounded by nothing but sand. You must make a run to the helicopter cause people are about to attack you. Infected people who are barely people anymore.");
		Room sus = new Room("suspicious","You are now inside the new facility. It is guarded like no other. The main leader calls 12 people every week to take them to a new place and be free? Where do they go? No one knows. Take a peek and find out. Trust the wrong people and it will be the last thing you choose.");
		Room mysteryRoom = new Room("mystery","You  have met a new kid named Munch. Munch wats you to follow him through an air vent to take a look of the outside of this mysterious room. He wants to break in but needs your help. What will you decide to choose?")	;
		Room actionPlan = new Room("into action","You saw what happens when you are taken to this place. You were able to break into the room. You and your brothers want to escape. How will you accomplish it?");
		Room mall = new Room("mall","While running you have discovered an abandoned mall in the dessert. Lets see what the mall is about and if it has anything to offer.");
		Room exploring = new Room("explore","While exploring you see that there are still things inside the mall that are resourceful. You and everyone else either change clothes or grab everything that can be carried. Munch discovers a large switch inside. Should he turn it on?");	
		Room escaping = new Room("wow","Wowwwwww . Great. You just had to turn on the light. Now we must think fast and come up with an escape because you are being chased with what seems to be around 50 people infected with the rush.");
		Room observe = new Room("im here","You find yourself in what seems to be an old city. It has been so long since people dwelled here that it looks sad. Everything is coming apart. You are finally able to rest… kinda… and just walks around trying to find your next destination.");	
		Room underRock = new Room("rockunder","The men from the facility are near. You see their Helicopter nearby. There you discover someone close to you has gotten infected with the Rush. He is begging you to end his misery before he hurts someone. What will you do?");
		Room trade = new Room("the trade", "While wondering you come across this unknown building. When you enter there are many beings that have been infected with the rush. They are tied up in chains as though they are animals. Suddenly the lights turn on. You see someone in the light. Do you trust these unknown people or do you make a run for it?. ");			
		Room mountains = new Room("mountains","You were able to travel to the mountains and find the last few people alive that are not a part of Wicked.");	
		Room savingTruth = new Room("truth","After one of your friends is infected. they are given a serum that contains your blood. Normally soon after people revert back and the rush takes over. Why has it not come back yet");
		Room capture = new Room("captured","You are still in the mountains. There you live happily. But… someone let wicked people know where you are and they captured one of your brothers. Now you must get him back");			
		Room partyHardy = new Room("partyhardy","You have traveled to the city where over a 3000 people live. They risk being infected everyday. You go to a building searching for information. You are sucked into partying and being on substances. Will you make it out");	
		Room wall = new Room("wall","To get into the last city you must Go over the great wall that is over 100 feet tall. Will you make it into the last city? What will change once you are over the wall?");
		Room saving = new Room("save","You have gotten your brother back. Now what is your next move? Stay or go?");			
		Room backtoMountains = new Room("backtoMountains","You must get back to the mountains safely. Whatever happens do not catch the Rush. \r\n");	
		Room shipSails = new Room("sails","Everyone gets on the ship. It is finally time to get away from the rest of the world. Where no one is at risk and everyone can live in peace. ");
		Room greatRock = new Room("yay","You carve the peoples name that have passed along the way. They are not physically here but they carry on with you. The End");			
				
						
								
				
				
				
				
				
				
				
				
				
				
		// Adding all the rooms to the world.
		this.addRoom(centerOfMaze);
		this.addRoom(monsterBattle);
		this.addRoom(foundDoor);
		this.addRoom(runAway);
		this.addRoom(whereDoor);
		this.addRoom(enterRoom);
		this.addRoom(video);
		this.addRoom(rid);
		this.addRoom(kidnapped);
		this.addRoom(sus);
		this.addRoom(mysteryRoom);
		this.addRoom(actionPlan);
		this.addRoom(mall);
		this.addRoom(exploring);
		this.addRoom(escaping);
		this.addRoom(observe);
		this.addRoom(underRock);
		this.addRoom(trade);
		this.addRoom(mountains);
		this.addRoom(savingTruth);
		this.addRoom(capture);
		this.addRoom(partyHardy);
		this.addRoom(wall);
		this.addRoom(saving);
		this.addRoom(backtoMountains);
		this.addRoom(shipSails);
		this.addRoom(greatRock);
		


		// Creating all the doors between the rooms.
		this.createDoor(centerOfMaze ,"north", monsterBattle);
		

		this.createDoor(monsterBattle,"north", foundDoor);
		
		this.createDoor(foundDoor ,"north", runAway);
		
		this.createDoor(runAway ,"north", whereDoor);
		
		this.createDoor(whereDoor ,"north", enterRoom);
		
		this.createDoor(enterRoom ,"north", video);
		
		this.createDoor(video ,"north", rid);
		
		this.createDoor(rid ,"north", kidnapped);
		
		this.createDoor(kidnapped ,"north", sus);
		
		this.createDoor(sus ,"north", mysteryRoom);
		
		this.createDoor(mysteryRoom ,"north", actionPlan);
		
		this.createDoor(actionPlan ,"north", mall);
		
		this.createDoor(mall ,"north", exploring);
		
		this.createDoor(exploring ,"north", escaping);
		
		this.createDoor(escaping ,"north", observe);
		
		this.createDoor(observe ,"north",underRock);
		
		this.createDoor(underRock ,"north", trade);
		
		this.createDoor(trade ,"north", mountains);
		
		this.createDoor(mountains ,"north", savingTruth);
		
		this.createDoor(savingTruth ,"north", capture);
		
		this.createDoor(capture ,"north", partyHardy);
		
		this.createDoor(partyHardy ,"north", wall);
		
		this.createDoor(wall ,"north", saving);
		
		this.createDoor(saving ,"north", backtoMountains);
		
		this.createDoor(backtoMountains ,"north", shipSails);
		
		this.createDoor(shipSails ,"north", greatRock);
		
		this.createDoor(greatRock,"north",greatRock);
		
		
	}	
		
	
private void createIteams() {
	//create all iteams
	Iteam key = new Iteam("neighbor key" , "blahblah blahhhhh" , 500, .05);
	Iteam knife = new Iteam("In gunthers hand" , "blahblah blahhhhh" , 500, .1);
	Iteam bow_and_arrow = new Iteam("In gunthers hand" , "blahblah blahhhhh" , 500, 5.00);
	Iteam pills = new Iteam("In gunthers hand" , "blahblah blahhhhh" , 500, 0.01);
	Iteam book = new Iteam("In gunthers hand" , "blahblah blahhhhh" , 500, 5.00);
	Iteam lantern = new Iteam("In gunthers hand" , "blahblah blahhhhh" , 500, 2.00);
	
	
	
	// add iteams to room
	rooms.get("centerOfMaze").addIteam(key);
	rooms.get("underRock ").addIteam(knife);
	rooms.get("rid ").addIteam(bow_and_arrow);
	rooms.get(" partyHardy").addIteam(pills);
	rooms.get(" foundDoor").addIteam(book);
	rooms.get("mall").addIteam(lantern);
	
	// st key to unlock right door
	((Object) rooms.get("monsterBattle").getDirection("north")).setLock(true);
	((Object) ((Room) Room.get("monsterBattle")).getDirection("north")).setKey(key);
	
	
	((Object) rooms.get("underRock ").getDirection("north")).setLock(true);
	((Object) ((Room) Room.get("underRock ")).getDirection("north")).setKey(knife);
	
	((Object) rooms.get("rid ").getDirection("north")).setLock(true);
	((Object) ((Room) Room.get("rid ")).getDirection("north")).setKey(bow_and_arrow);
	
	((Object) rooms.get("partyHardy ").getDirection("north")).setLock(true);
	((Object) ((Room) Room.get("partyHardy")).getDirection("north")).setKey(pills);
	
	((Object) rooms.get("foundDoor ").getDirection("north")).setLock(true);
	((Object) ((Room) Room.get("foundDoor")).getDirection("north")).setKey(book);
	
	((Object) rooms.get("mall").getDirection("north")).setLock(true);
	((Object) ((Room) Room.get("mall")).getDirection("north")).setKey(lantern);
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
