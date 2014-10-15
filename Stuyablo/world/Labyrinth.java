import java.util.*;
import java.io.*;

public class Labyrinth extends World{
	private BaseChar player;

	public Labyrinth(BaseChar bc){
		player = bc;
	}

	public void print(String s){System.out.println(s);}

	public boolean isMonster(){
		Random random = new Random();
    		return random.nextBoolean();
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

	public void action(){
		if (isMonster()){
                	Battle b = new Battle(player , getMonster());
                }
	}

	public void move(){
		print("Instructions:");
		print("u/U - Up");
		print("d/D - Down");
		print("l/L - Left");
		print("r/R - Right");
		print("s/S/Save/save - Save your current info");
		boolean chosen;
		chosen = false;
		while (!chosen){
			Scanner sc = new Scanner(System.in);
			String response = sc.next();
			if (response.toUpper.equals("U")) {
				chosen = false;
				action();
			}
			else if (response.toUpper.equals("D")) {
				chosen = false;
				action();
			}
			else if (response.toUpper.equals("L")) {
				chosen = false;
				action();
			}
			else if (response.toUpper.equals("R")) {
				chosen = false;
				action();
			}
			else if (response.toUpper().equals("S") || response.toUpper().equals("SAVE")){
				PrintWriter writer = new PrintWriter("stuyablosave.txt", "UTF-8");
				writer.println(player.name());
				writer.println(player.level());
				writer.println(player.experience());
				writer.println(player.maxHealth());
				writer.println(player.health());
				writer.println(player.strength());
				writer.println(player.speed());
				writer.println(player.dexterity());
				writer.println(super.stage);
				writer.close();
			}
			else {
				System.out.println("Invalid Command");
			}
		}
		super.stage = super.stage + 1;
	}
}
