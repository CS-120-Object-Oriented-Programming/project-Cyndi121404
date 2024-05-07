/**
 * This class is the main class of the "Campus of Kings" application.
 * "Campus of Kings" is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all. It should really be extended to make it more
 * interesting!
 *
 * This game class creates and initializes all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 *
 * @author Maria Jump
 * @author Cyndi Sanchez
 * @version 2015.02.01
 *
 * Used with permission from Dr. Maria Jump at Northeastern University
 */

public class Game {
	/** The world where the game takes place. */
	private World world;
	/** The room the player character is currently in. */
	private Player Thomas;
	private int score = 0; 
	private int turn = 0; 
	/**
	 * Create the game and initialize its internal map.
	 */
	public Game() {
		world  = new World();
		Thomas = new Player (world.getRoom("centerOfMaze"));
		// set the starting room
		//Thomas = world.getRoom("centerOfMaze");  
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();

		// Enter the main game loop. Here we repeatedly read commands and
		// execute them until the game is over.
		boolean wantToQuit = false;
		while (!wantToQuit) {
			Command command = Reader.getCommand();
			wantToQuit = processCommand(command);
			turn++;
			// other stuff that needs to happen every turn can be added here.
		}
		printGoodbye();
	}
	
	///////////////////////////////////////////////////////////////////////////
	// Helper methods for processing the commands

	/**
	 * Given a command, process (that is: execute) the command.
	 *
	 * @param command
	 *            The command to be processed.
	 * @return true If the command ends the game, false otherwise.
	 */
	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		if (command.isUnknown()) {
			Writer.println("I don't know what you mean...");
		} else {
			commandenum CommandWord = CommandWords.getCommand(command.getCommandWord());
			switch(CommandWord) {
			case HELP:
				printHelp();
				break;
			case GO:
				goRoom(command);
				break;
			case QUIT:
				wantToQuit = quit(command);
				break;
			case LOOK:
				look();
				break;
			case STATUS:
				status();
				break;
			case BACK:
				back();
				break;
			case UNPACK:
				unpack();
				break;
			case LOCK:
				 lock();
				break;
			case EXAMINE:
				examine();
				break;
			case PACK:
				pack();
				break;
			case UNLOCK:
				unlock();
				break;
			case TAKE:
				take();
				break;
			case DROP:
				drop();
				break;
			case INVENTORY:
				inventory();
				break;
				default:
						Writer.println(CommandWord + " is not implemented yet!");
			}
			}
		return wantToQuit;
			
	}
	private void printLocationInformation(){
	Writer.println(Thomas.getCurrentRoom().getName() + ":");
	Writer.println("You are " + Thomas.getCurrentRoom().getDescription());
	Writer.print("Exits: ");
	
	if (Thomas.getCurrentRoom() != null) {
		Writer.print("north ");
	}
	if (Thomas.getCurrentRoom() != null) {
		Writer.print("east ");
	}
	if (Thomas.getCurrentRoom() != null) {
		Writer.print("south ");
	}
	if (Thomas.getCurrentRoom() != null) {
		Writer.print("west ");
	}
	Writer.println("");
	}
		

	

	///////////////////////////////////////////////////////////////////////////
	// Helper methods for implementing all of the commands.
	// It helps if you organize these in alphabetical order.

	//swap previous and current room and continue
	

	/**
	 * Try to go to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 *
	 * @param command
	 *            The command to be processed.
	 */
	private void goRoom(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			Writer.println("Go where?");
		} else {
			String direction = command.getRestOfLine();

			// Try to leave current.
			Door doorway = Thomas.getCurrentRoom().getExit(direction);
			

			if (doorway == null) {
				Writer.println("There is no door!");
			} 
			else if (doorway.isLocked()) {
				Writer.println("The Door Is locked);");
			}
			else {
				Room newRoom = doorway.getDestination();
				Thomas.setCurrentRoom(newRoom); 
				printLocationInformation();
			}
			
		}
	}

	private void lock(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			Writer.println("Lock What?");
		} else {
			String direction = command.getRestOfLine();

			// Try to leave current.
			Door doorway = Thomas.getCurrentRoom().getExit(direction);

			if (doorway == null) {
				Writer.println("There is no door!");
			} 
			else if (doorway.isLocked()) {
				Writer.println("The Door Is locked);");
			}
			else if (doorway.getKey() == null) {
				Writer.println ("door cannot be locked");
			}
			else {//there is a door that can be locked. do they have the key?
				Writer.println("With what?");
				String res = Reader.getResponse(); // iteam they want to use
			
				//cheack is key is in the inventory
				Iteam key = Thomas.getIteam(res);
				
				if (key == null) {
					Writer.println("you dont have that key!");

				} 
				else if (key != doorway.getKey()) {
					Writer.println("you have the wrong key!");
				}
				else {
					doorway.setLocked(true);
					Writer.println("door is locked");
				}
			}
			
		}
	}
	
	
	
	
	/**
	 * Print out the closing message for the player.
	 */
	private void printGoodbye(){
		Writer.println("you have earned points and turns"+ turn +score);
		Writer.println("I hope you weren't too bored here on the Campus of Kings!");
		Writer.println("Thank you for playing.  Good bye.");
	}

	/**
	 * Print out some help information. Here we print some stupid, cryptic
	 * message and a list of the command words.
	 */
	private void printHelp() {
		Writer.println("You are lost. You are alone. You wander");
		Writer.println("around at the university.");
		Writer.println();
		Writer.println("Your command words are:");
		Writer.println("   go quit help");
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		printLocationInformation();
		Writer.println();
		Writer.println("Welcome to the Campus of Kings!");
		Writer.println("Campus of Kings is a new, incredibly boring adventure game.");
		Writer.println("Type 'help' if you need help.");
		Writer.println();
		
	}

	
	/**
	 * "Quit" was entered. Check the rest of the command to see whether we
	 * really quit the game.
	 *
	 
	 * @param command
	 *            The command to be processed.
	 * @return true, if this command quits the game, false otherwise.
	 */
	//private void look(){
	//print lovation info
	// prints out location information
	private void look(){
		printLocationInformation();
		
		
		
	}
	private void status(){
		printLocationInformation();
		Writer.println("your score is " + score + " and you have been playing for " + turn);
	}
	private void back() {
		if (Thomas.getPreviousRoom() != null && Thomas.getPreviousRoom() != Thomas.getCurrentRoom()) {
			Thomas.setCurrentRoom(Thomas.getPreviousRoom());
			printLocationInformation();
			}
		else {
			Writer.println("You cant go back any further!");
		}
		
	}
	private void examine (Command command) {
		if (!command.hasSecondWord()) {
			Writer.println("Examine What");
			return;
		}
	}
	
	private void take() {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			Writer.println("Take what?");
		} else {
			String direction = command.getRestOfLine();

			// Try to leave current.
			Door doorway = Thomas.getCurrentRoom().getExit(direction);
			

			if (doorway == null) {
				Writer.println("No such iteam");
			} 
			else if (doorway.isLocked()) {
				Writer.println("Carrying too much");
			}
			else {
				Room newRoom = doorway.getDestination();
				Thomas.setCurrentRoom(newRoom); 
				printLocationInformation();
			}
			
		}
	    }
		
	
		
	
	private void drop() {
		if (parts.length == 1) {
            System.out.println("Which item?");
        } else {
            String itemToDrop = parts[1];
            if (!inventory.contains(itemToDrop)) {
                System.out.println("You don't have it.");
            } else {
                inventory.remove(itemToDrop);
                currentRoomItems.add(itemToDrop);
                System.out.println("You dropped the " + itemToDrop + ".");
            }
        }
    }

		
	
		
	private void inventory(){
		
		Writer.println("you have the following iteams in your inventory:");
		for (IteamName : Thomas.getInventory().keySet) {
			Writer.println(IteamName);
		}
		
	}
	
	
	private boolean quit(Command command) {
		boolean wantToQuit = true;
		if (command.hasSecondWord()) {
			Writer.println("Quit what?");
			wantToQuit = false;
		}
		return wantToQuit;
	}
	private void unlock(String direction) {
		if (!doorLocked) {
            System.out.println("The door is not locked.");
        } else {
            if (direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")) {
                if (inventory.contains("Key")) {
                    System.out.println("You unlocked the door to the " + direction + ".");
                    doorLocked = false;
                } else {
                    System.out.println("You don't have the key to unlock the door.");
                }
            } else {
                System.out.println("There is no door in that direction.");
            }
        }
    }	
		
	private void lock(String direction) {
		 if (doorLocked) {
	            System.out.println("The door is already locked.");
	        } else {
	            if (direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")) {
	                if (inventory.contains("Key")) {
	                    System.out.println("You locked the door to the " + direction + ".");
	                    doorLocked = true;
	                } else {
	                    System.out.println("You do not have the key to lock the door.");
	                }
	            } else {
	                System.out.println("No door in that direction.");
	            }
	        }
	    }
		
	private void unpack(String containerName) {
		if (containerContents == null) {
            System.out.println("You don't see it.");
        } else {
            System.out.print("Enter item to unpack: ");
            Scanner scanner = new Scanner(System.in);
            String itemToUnpack = scanner.nextLine().toLowerCase();

            if (!containerContents.contains(itemToUnpack)) {
                System.out.println("You don't find it.");
            } else {
                if (itemToUnpack.equals("Gold")) {
                    System.out.println("You are already carrying too much.");
                } else {
                    containerContents.remove(itemToUnpack);
                    inventory.add(itemToUnpack);
                    System.out.println("You unpacked the " + itemToUnpack + ".");
                }
            }
        }
    }
		
		
		
	}
		
		
	
		
		
		
	

