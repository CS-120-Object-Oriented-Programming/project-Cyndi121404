import java.util.ArrayList;
import java.util.HashMap;


/**
/**
 * @author Cyndi Sanchez
 * This is the PLAYER CHARECTER
 */
public class Player {
	private	Room currentRoom;
	private	Room previousRoom;
	private HashMap <String, Iteam> inventory;
	private int Weight;
	/** 
	 * this is the players current room.
	 */

	public Player (Room currentRoom){
		this.currentRoom = currentRoom;
		this.setPreviousRoom(null);
		this.setWeight(100);
	}

	public Room getCurrentRoom() {
		return currentRoom;
		

	}
	public void setCurrentRoom(Room currentRoom) {
		this.setPreviousRoom(this.currentRoom);
		this.currentRoom = currentRoom;


	}

	public Room getPreviousRoom() {
		return previousRoom;
	}

	public void setPreviousRoom(Room previousRoom) {
		this.previousRoom = previousRoom;
	}



	public int getWeight() {
		return Weight;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	public HashMap <String, Iteam> getInventory() {
		return inventory;
	}

	public void setInventory(HashMap <String, Iteam> inventory) {
		this.inventory = inventory;
	}
	public boolean addIteam(Iteam object) {
		double totalWeight = 0.1;
		for (Iteam i : inventory.values()) {
			totalWeight = i.getWeight();
	}
		totalWeight t = object.getWeight();
		if (totalweight t = object.getWeight(Max)) {
			incenter.put();
			return true;
		}
		return false;
	}
	public String getName() {
        return getName();
    }
	public void removeItem(String itemName) {
        Iterator<Item> iterator = Iteam.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getName().equals(itemName)) {
                iterator.remove();
                System.out.println("Item removed from inventory: " + itemName);
                return;
            }
        }
        System.out.println("Item not found in inventory: " + itemName);
    }
	
	}
	
























