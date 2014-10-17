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
		int chance = n.nextInt(100);
		int lev = (int)((super.stage / 10) + 1);
		if (chance < 33) {
			m.koboldTemplate("Kobold" , lev);
		}
		else if (chance < 67 && chance >= 33) {
			m.spiderTemplate("Spider" , lev);
		}
		else if (chance < 100 && chance >= 67) {
			m.golemTemplate("Golem" , lev);
		}
		return m;
	}

	public int potionRoom(){
		Random room = new Random();
		int upgrade = room.nextInt(100);
		return upgrade;
	}

	public void action(){
//		try{
//	                Thread.sleep(650);
//		} catch(Exception e) {}
                System.out.print("\033\143");
		if (getStage() == 99){
			Monster drag = new Monster();
			drag.DRAGONTemplate("Ebonmaw" , 1);
			Battle boss1 = new Battle(player , drag);
		}
		else if (getStage() == 149){
			Monster pred = new Monster();
			pred.PREDATORTemplate("Rangor" , 1);
			Battle boss2 = new Battle(player , pred);
		}
		else if (getStage() == 199){
			Monster gate = new Monster();
			gate.GATEKEEPERTemplate("Zim 'Ann Skior" , 1);
			Battle boss3 = new Battle(player , gate);
		}
		else if (isMonster()){
                	Battle b = new Battle(player , getMonster());
                }
		else if (potionRoom() < 15){
			int upgrade = potionRoom() % 4;
			Random amount = new Random();
			int x = 0;
			switch (upgrade) {
				case 0:
					System.out.println("You have found a Potion of Vitality!");
					x = amount.nextInt(25) + 10;
					System.out.println("You have gained " + x + " health!");
					player.setMaxHealth(player.maxHealth() + x);
					player.setHealth(player.maxHealth());
					break;
				case 1:
					System.out.println("You have found a Potion of Vorocity!");
					x = amount.nextInt(5) + 5;
					System.out.println("You have gained " + x + " strength!");
					player.setStrength(player.strength() + x);
					break;
				case 2:
					System.out.println("You have found a Potion of Will!");
					x = amount.nextInt(10) + 3;
					System.out.println("You have gained " + x + " dexterity!");
					player.setDexterity(player.dexterity() + x);
					break;
				case 3:
					System.out.println("You have found a Potion of Alacrity!");
					x = amount.nextInt(3) + 3;
					System.out.println("You have gained " + x + " speed!");
					player.setSpeed(player.speed() + x);
					break;
				default:
					System.out.println("You have found a glorious empty bottle.");
					break;
			}
		}
	}

        public int getStage() {
                return super.stage;
        }

        public void setStage(int n) {
                super.stage = n;
        }

	public void move(){
		print("Instructions:");
		print("u/U -        Up");
		print("d/D -        Down");
		print("l/L -        Left");
		print("r/R -        Right");
		print("s/save -     Save your current info");
		print("Stat -       Displays your stats");
		print("quit -       Quits the game without saving");
		System.out.println("Stage:       " + getStage() + "/200");
		boolean chosen;
		chosen = false;
		while (!chosen){
			System.out.print(player.name() + "@stuyablo $ ");
			Scanner sc = new Scanner(System.in);
			String response = sc.next();
			if (response.toUpperCase().equals("U")) {
				chosen = true;
				action();
			}
			else if (response.toUpperCase().equals("D")) {
				chosen = true;
				action();
			}
			else if (response.toUpperCase().equals("L")) {
				chosen = true;
				action();
			}
			else if (response.toUpperCase().equals("R")) {
				chosen = true;
				action();
			}
			else if (response.toUpperCase().equals("S") || response.toUpperCase().equals("SAVE")){
				try {
					FileOutputStream saveFile = new FileOutputStream("stuyablosave.txt");
					ObjectOutputStream save = new ObjectOutputStream(saveFile);
					save.writeObject(player.name());
					save.writeObject(player.level());
					save.writeObject(player.experience());
					save.writeObject(player.maxHealth());
					save.writeObject(player.health());
					save.writeObject(player.strength());
					save.writeObject(player.speed());
					save.writeObject(player.dexterity());
					save.writeObject(super.stage);
					save.writeObject(player.type());
					save.close();
				} catch(Exception e) {e.printStackTrace();}
			}
			else if (response.toUpperCase().equals("STAT")){
				System.out.println("Level:         " + player.level);
				System.out.println("Experience:    " + player.experience);
				player.displayStats();
			}
			else if (response.toUpperCase().equals("QUIT")){
				System.out.println("Exiting... ");
				System.exit(0);
			}
			else {
				System.out.println("Invalid Command");
			}
		}
		setStage(getStage() + 1);
	}
}
