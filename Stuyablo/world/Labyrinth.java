import java.util.*;
import java.io.*;

public class Labyrinth extends World{
	public void print(String s){System.out.println(s);}
	public boolean isMonster(){
		Random random = new Random();
    		return random.nextBoolean());
	}
	
	public Monster getMonster(){
		Monster m = new Monster();
		Random n = new Random();
		int chance = random.nextInt(100);
		if (chance < 33) {
			m.koboldTemplate("Kobold" , 1);
		}
		else if (chance < 67 && chance >= 33) {
			m.spiderTemplate("Spider" , 1);
		}
		else if (chance < 100 && chance >= 67) {
			m.golemTemplate("Golem" , 1);
		}
		return m;
	}

	public void move(){
		print("Instructions:");
		print("0/u/U - Up");
		print("1/d/D - Down");
		print("2/l/L - Left");
		print("3/r/R - Right");
		print("s/S/Save/save - Save your current info");
		boolean chosen;
		chosen = false;
		while (!chosen){
			Scanner sc = new Scanner();
			if (sc.next().toUpper.equals("U")) {

			}
			else if (sc.next().equals(0)){

			}
			else if (sc.next().toUpper.equals("D")) {

			}
			else if (sc.next().equals(1)){

			}
			else if (sc.next().toUpper.equals("L")) {

			}
			else if (sc.next().equals(2)){

			{
			else if (sc.next().toUpper.equals("R")) {

			}
			else if (sc.next().equals(3)){

			}
			else {

			} 
		}
	}
}
