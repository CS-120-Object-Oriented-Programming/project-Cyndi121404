
public class Iteam {
private String name;
private String description;
 private int points;
 private double weight;
 public Iteam(String name, String description, int points, double weight) {
	 this.name = name;
	 this.description = description;
	 this.points = points;
	 this.weight = weight;
	 
 }
 
 public String toString() {
	 return name + ":" + description +"\n" + weight;
 }

 

}
