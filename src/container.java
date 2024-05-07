import java.util.HashMap;

public class container extends Iteam {
	public container() {
        HashMap Iteam = new HashMap<>();
    }

    public void addItem(Iteam iteam) {
        if (Iteam.containsKey(iteam)) {
            int currentQuantity = Iteam.get(iteam);
            Iteam.put(itemName, currentQuantity + iteam);
        } else {
            	Iteam.put(iteam, iteam);
        }
    }
    
    public String removeItem(String Name) {
        if (Iteams.containsKey(Name)) {
            int quantity = Iteams.get(Name);
            if (quantity == 1) {
                Iteams.remove(Name);
            } else {
                Iteams.put(iteamName, quantity - 1);
            }
            return IteamName;
        } else {
            return null;
        }
    }
	
	
}
// needs own hashmap of strings to iteams
//Meathods = add, remove, getter and setters, overide the tostring method so it shows the iteams in the container