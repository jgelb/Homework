import java.util.*;
import java.io.*;

public class Exec{
	public static void newGame(){
		BaseChar Harry = new BaseChar();
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<4; i++){
			System.out.println(i + " - ");
			switch (i) {
				case 0:
					Harry.warriorTemplate("Harry");
					Harry.displayStats();
					break;
				case 1:
					Harry.mageTemplate("Harry");
					Harry.displayStats();
					break;
				case 2:
					Harry.archerTemplate("Harry");
					Harry.displayStats();
					break;
				case 3:
					Harry.dwarfTemplate("Harry");
					Harry.displayStats();
					break;
				default:
					Harry.displayStats();
					break;
			}
		}
		System.out.println("Choose your class!");
		boolean chosen = false;
		while (!chosen){
			switch ((int)sc.nextInt()) {
				case 0:
					Harry.warriorTemplate("Harry");
					chosen = true;
					break;
				case 1:
					Harry.mageTemplate("Harry");
					chosen = true;
					break;
				case 2:
					Harry.archerTemplate("Harry");
					chosen = true;
					break;
				case 3:
					Harry.dwarfTemplate("Harry");
					chosen = true;
					break;
				default:
					System.out.println("Invalid choice. Please choose again.");
					break;
			}
		}
		System.out.print("Name your character: ");
		Harry.setName(sc.next());
		System.out.println("Welcome " + Harry.name + ".");
		System.out.println("You wake up in a dungeon. You look around and are confused. How do I get out?");
		Labyrinth game = new Labyrinth(Harry);
		game.setStage(1);
		while (game.getStage() < 200) {
			game.move();
		}
	}

	public static void loadGame(){
		try{
			FileInputStream saveFile = new FileInputStream("stuyablosave.txt");
			ObjectInputStream save = new ObjectInputStream(saveFile);
			BaseChar load = new BaseChar();
			Labyrinth gameRes = new Labyrinth(load);
			//RESTORE THE DATA!
			load.setName((String) save.readObject());
			load.setLevel((Integer) save.readObject());
			load.setExperience((Integer) save.readObject());
			load.setMaxHealth((Integer) save.readObject());
			load.setHealth((Integer) save.readObject());
			load.setStrength((Integer) save.readObject());
			load.setSpeed((Integer) save.readObject());
			load.setDexterity((Integer) save.readObject());
			gameRes.setStage((Integer) save.readObject());
			load.setType((String) save.readObject());
			save.close();
			while (gameRes.getStage() < 200) {
                        	gameRes.move();
                	}
		} catch(Exception e) {e.printStackTrace();}
	}

	public static void main(String[] args){
		File f = new File("stuyablosave.txt");
		if (f.exists()){
			boolean checkResp = false;
			Scanner check = new Scanner(System.in);
			while (!checkResp){
				System.out.println("You seem to have a save file. Load the save? (Y/N)");
				String resp = check.next();
				if (resp.toUpperCase().equals("Y") || resp.toUpperCase().equals("YES")){
					System.out.println("Save file detected. Loading save...");
					checkResp = true;
					loadGame();
				}
				else if (resp.toUpperCase().equals("N") || resp.toUpperCase().equals("NO")){
					System.out.println("Starting new game...");
					checkResp = true;
					newGame();
				}
				else{
					System.out.println("Invalid response. Valid responses: Y , Yes , N , No");
				}
			}
		}
		else {
			newGame();
		}
	}
}
