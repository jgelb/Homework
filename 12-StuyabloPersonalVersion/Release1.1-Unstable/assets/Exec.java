import java.util.*;
import java.io.*;

public class Exec{

	public static void titleScreen(){
		Labyrinth.clrConsole();
		System.out.println("                                                                              ");
		System.out.println(" @@@@@@   @@@@@@@  @@@  @@@  @@@ @@@   @@@@@@   @@@@@@@   @@@        @@@@@@   ");
		System.out.println("@@@@@@@   @@@@@@@  @@@  @@@  @@@ @@@  @@@@@@@@  @@@@@@@@  @@@       @@@@@@@@  ");
		System.out.println("!@@         @@!    @@!  @@@  @@! !@@  @@!  @@@  @@!  @@@  @@!       @@!  @@@  ");
		System.out.println("!@!         !@!    !@!  @!@  !@! @!!  !@!  @!@  !@   @!@  !@!       !@!  @!@  ");
		System.out.println("!!@@!!      @!!    @!@  !@!   !@!@!   @!@!@!@!  @!@!@!@   @!!       @!@  !@!  ");
		System.out.println(" !!@!!!     !!!    !@!  !!!    @!!!   !!!@!!!!  !!!@!!!!  !!!       !@!  !!!  ");
		System.out.println("     !:!    !!:    !!:  !!!    !!:    !!:  !!!  !!:  !!!  !!:       !!:  !!!  ");
		System.out.println("    !:!     :!:    :!:  !:!    :!:    :!:  !:!  :!:  !:!  :!:       :!:  !:!  ");
		System.out.println(":::::::      ::    ::::: ::     ::    ::   :::  ::: ::::  :: ::::   ::::::::  ");
		System.out.println("::::::       :      : :  :      :     ::   : :  :::::::   : :: ::    ::::::   ");
		System.out.println("");
		System.out.println("                       Tale of the Land of R' Meot");
		//Easter egg! R 'Meot = Rm EOT = Rm 307
		System.out.println("");
		System.out.println("OpenSource Software, Created by Ethan Cheng");
		System.out.println("Press Enter to continue...");
		try {
			System.in.read();
		} catch(Exception e){e.printStackTrace();}
	}

	public static void newGame(){
		Labyrinth.clrConsole();
		BaseChar Harry = new BaseChar();
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the number that corresponds to the class. (0-3)");
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
		int choice = 0;
		try {
			choice = (int)sc.nextInt();
			chosen = true;
		} catch(Exception e){
			//System.out.println("Invalid choice. Choose an integer between 0 and 3.");
			while (!chosen) {
				String cho = sc.next();
				if (cho.equals("0") || cho.equals("1") || cho.equals("2") || cho.equals("3")){
					choice = Integer.parseInt(cho);
					chosen = true;
				}
				else {
					System.out.println("Invalid choice. Choose an integer between 0 and 3.");
				}
			}
		}
		switch (choice) {
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
		System.out.print("Name your character: ");
		Harry.setName(sc.next());
		Labyrinth.clrConsole();
		System.out.println("Welcome " + Harry.name + ".");
		System.out.println("You wake up in a dungeon. You look around and are confused. How do I get out?");
		Labyrinth game = new Labyrinth(Harry);
		game.setStage(1);
		while (game.getStage() < 200 && Harry.health() > 0) {
			game.move();
		}
                if (Harry.health() <= 0){
			Labyrinth.clrConsole();
			System.out.println("Sorry this is a roguelike! You can't respawn! If you want, load up from your save file if you made one.");
			System.exit(0);
		}
                else if(game.getStage() >= 200){
                        System.out.println("You walk out the portal created by Zim 'Ann Skior's body...");
                        game.pauseSleep(2000);
                        System.out.println("You take a deep breath...");
                        game.pauseSleep(2000);
                        System.out.print("...");
                        game.pauseSleep(2000);
                        System.out.println("... No...");
                        game.pauseSleep(2100);
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Thanks for playing Stuyablo!");
                        System.out.println("Credits:");
                        System.out.println("Everything: Ethan Cheng");
                        System.out.println("Game exitting...");
                        System.exit(0);
                }

	}

	public static void loadGame(){
		Labyrinth.clrConsole();
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
			gameRes.currRm.room = (String[]) save.readObject();
			load.setXCOR((Integer) save.readObject());
			load.setYCOR((Integer) save.readObject());
			save.close();
			while (gameRes.getStage() < 200 && load.health() > 0) {
                        	gameRes.move();
                	}
			if (load.health() <= 0){
				Labyrinth.clrConsole();
				newGame();
			}
			else if(gameRes.getStage() >= 200){
				System.out.println("You walk out the portal created by Zim 'Ann Skior's body...");
				gameRes.pauseSleep(2000);
				System.out.println("You take a deep breath...");
				gameRes.pauseSleep(2000);
				System.out.print("...");
				gameRes.pauseSleep(2000);
				System.out.println("... No...");
				gameRes.pauseSleep(2100);
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Thanks for playing Stuyablo!");
				System.out.println("Credits:");
				System.out.println("Everything: Ethan Cheng");
				System.out.println("Game exitting...");
				System.exit(0);
			}
		} catch(Exception e) {e.printStackTrace();}
	}

	public static void main(String[] args){
		titleScreen();
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
					try{
	                                        Thread.sleep(1000);
        	                        } catch(Exception e) {}
                	                System.out.print("\033\143");
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
