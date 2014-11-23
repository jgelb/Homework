import java.util.*;
import java.io.*;

public class RoomGen{
	public String[] room = new String[18]; //0-14 = Room, 15 = Blank line, 16 = Console Message , 17 = Blank line
	private BaseChar localCH;
	private Labyrinth gameHost;
	private String consoleMessage;

	public RoomGen(BaseChar bc , Labyrinth l){
		localCH = bc;
		gameHost = l;
		consoleMessage = "";
	}

	public String getConMessage(){return consoleMessage;}

	public String MapGen(int column , int row){

//		BufferedReader br = new BufferedReader(new FileReader("BaseRoom.txt"));
		try{
			int chance;
			BufferedReader br = new BufferedReader(new FileReader("BaseRoom.txt"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			int tick = 1;
			while (line != null) {
                       		while (line.contains("B")){
					chance = (int)(Math.random() * 100);
               	                	if (chance < 2) {
                       	        	        line = line.replaceFirst("B" , "k");
                               		}
                                	else if (chance < 4) {
       	                        	        line = line.replaceFirst("B" , "s");
               	                	}
                       	        	else if (chance < 6) {
                               		        line = line.replaceFirst("B" , "g");
                               		}
	                               	else if (chance < 7) {
	                               	        line = line.replaceFirst("B" , "t");
	                               	}
	                               	else {
	                               	        line = line.replaceFirst("B" , " ");
	                               	}
				}

				room[tick - 1] = line;
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				if (tick == row) {
					line = line.substring(0,column) + "@" + line.substring(column + 1);
				}
				tick++;
			}
			consoleMessage = "You enter a room.";
			room[15] = "";
			room[16] = consoleMessage;
			room[17] = "";
			String everything = sb.toString();
			return everything;
		} catch(Exception e){e.printStackTrace(); return "NULL";}
	}

	public String getUp(int x , int y){
		//Note positive y axis points DOWN
		try {
			return room[y - 1].substring(x , x + 1);
		} catch(Exception e){
			return "OUTOFBOUNDS";
		}
	}

	public String getDown(int x , int y){
		try {
			return room[y + 1].substring(x , x + 1);
		} catch(Exception e){
			return "OUTOFBOUNDS";
		}
	}

	public String getLeft(int x , int y){
		try {
			return room[y].substring(x - 1 , x);
		} catch(Exception e){
			return "OUTOFBOUNDS";
		}
	}

	public String getRight(int x , int y){
		try {
			return room[y].substring(x + 1 , x + 2);
		} catch(Exception e){
			return "OUTOFBOUNDS";
		}
	}

	public void treasureChest(){
		int upgrade = (int)(Math.random() * 100) % 12;
		Random amount = new Random();
		int x = 0;
		System.out.print("You have come across a treasure chest. Open it? (Y/N)");
		Scanner chestChoice = new Scanner(System.in);
		boolean chestChosen = false;
		while (!chestChosen) {
			String chCh = chestChoice.next();
			if (chCh.toUpperCase().equals("YES") || chCh.toUpperCase().equals("Y")){
				switch (upgrade) {
					case 0:
						System.out.println("You have found a Potion of Vitality!");
						x = amount.nextInt(25) + 10;
						System.out.println("You have gained " + x + " health!");
						localCH.setMaxHealth(localCH.maxHealth() + x);
						localCH.setHealth(localCH.maxHealth());
						gameHost.pauseSleep(2000);
						Labyrinth.clrConsole();
						break;
					case 1:
						System.out.println("You have found a Potion of Vorocity!");
						x = amount.nextInt(5) + 5;
						System.out.println("You have gained " + x + " strength!");
						localCH.setStrength(localCH.strength() + x);
                                                gameHost.pauseSleep(2000);
                                                Labyrinth.clrConsole();
						break;
					case 2:
						System.out.println("You have found a Potion of Will!");
						x = amount.nextInt(10) + 3;
						System.out.println("You have gained " + x + " dexterity!");
						localCH.setDexterity(localCH.dexterity() + x);
                                                gameHost.pauseSleep(2000);
                                                Labyrinth.clrConsole();
						break;
					case 3:
						System.out.println("You have found a Potion of Alacrity!");
						x = amount.nextInt(3) + 3;
						System.out.println("You have gained " + x + " speed!");
						localCH.setSpeed(localCH.speed() + x);
                                                gameHost.pauseSleep(2000);
                                                Labyrinth.clrConsole();
						break;
					case 4:
						System.out.println("A mist of ailment comes out of the chest!");
						localCH.setMaxHealth(localCH.maxHealth() - 10);
						localCH.setHealth(localCH.maxHealth());
						System.out.println("Your health has been decreased!");
                                                gameHost.pauseSleep(2000);
                                                Labyrinth.clrConsole();
						break;
					case 5:
						System.out.println("A mist of weakness comes out of the chest!");
						localCH.setStrength(localCH.strength() - 3);
						System.out.println("Your strength has been decreased.");
                                                gameHost.pauseSleep(2000);
                                                Labyrinth.clrConsole();
						break;
					case 6:
						System.out.println("A mist of slowness comes out of the chest!");
						localCH.setSpeed(localCH.speed() - 3);
						System.out.println("Your speed has been decreased.");
                                                gameHost.pauseSleep(2000);
                                                Labyrinth.clrConsole();
						break;
					case 7:
						System.out.println("A mist of deterioration comes out of the chest!");
						localCH.setDexterity(localCH.dexterity() - 4);
						System.out.println("Your dexterity has been decreased.");
                                                gameHost.pauseSleep(2000);
                                                Labyrinth.clrConsole();
						break;
					default:
						System.out.println("You have found a glorious empty bottle.");
                                                gameHost.pauseSleep(2000);
                                                Labyrinth.clrConsole();
						break;
				}
				chestChosen = true;
			}
			else if (chCh.toUpperCase().equals("NO") || chCh.toUpperCase().equals("N")){
				System.out.println("You leave the chest alone.");
                                gameHost.pauseSleep(2000);
                                Labyrinth.clrConsole();
				chestChosen = true;
			}
			else {
				System.out.println("Are you going to open the chest or not? (Y/N)");
			}
		}
	}

	public void move(String dir , BaseChar trans){
		if (dir.toUpperCase().equals("UP")){
/*
			OLD ALGORITHM FROM LABYRINTH.JAVA RELEASE 1.0
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
		        m.setMaxHealth(m.maxHealth() + (int)(super.stage / 2) + (int)(lev / 2.5) + (int)(localCH.maxHealth() / 30));
		        m.setHealth(m.maxHealth());
*/
			int lev = (int)(gameHost.getStage() / 10 + 1);
			Monster m = null;
			if (getUp(trans.xcor() , trans.ycor()).equals("g")){
				m = new Monster();
				consoleMessage = "You fight a golem.";
				m.golemTemplate("Golem" , lev);
				Battle b = new Battle(localCH , m , gameHost.getStage());
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setYCOR(localCH.ycor() - 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);
			}
			else if (getUp(trans.xcor() , trans.ycor()).equals("k")){
				m = new Monster();
				consoleMessage = "You fight a kobold.";
				m.koboldTemplate("Kobold" , lev);
				Battle b = new Battle(localCH , m , gameHost.getStage());
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setYCOR(localCH.ycor() - 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);
			}
			else if (getUp(trans.xcor() , trans.ycor()).equals("s")){
				m = new Monster();
				consoleMessage = "You fith a spider.";
				m.spiderTemplate("Spider" , lev);
				Battle b = new Battle(localCH , m , gameHost.getStage());
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setYCOR(localCH.ycor() - 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);

			}
			else if (getUp(trans.xcor() , trans.ycor()).equals("t")){
				treasureChest();
				consoleMessage = "You find a treasure chest!";
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setYCOR(localCH.ycor() - 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);

			}
			else if (getUp(trans.xcor() , trans.ycor()).equals("#")){
				consoleMessage = "You walked into a wall.";
			}
			else if (getUp(trans.xcor() , trans.ycor()).equals(" ")){
				consoleMessage = "Nothing special here.";
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setYCOR(localCH.ycor() - 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);

			}
			else {
/*
				System.out.println("ERROR - Please shut down game");
				System.out.println("ERROR: Invalid symbol in game map.");
				System.exit(0);
*/
				consoleMessage = "Travel Mechanism returned null error. Invalid symbol in game map";
//				consoleMessage += getUp(trans.xcor() , trans.ycor());
			}
		}
		else if (dir.toUpperCase().equals("DOWN")){
			int lev = (int)(gameHost.getStage() / 10 + 1);
			Monster m = null;
			if (getDown(trans.xcor() , trans.ycor()).equals("g")){
				m = new Monster();
				consoleMessage = "You fight a golem.";
				m.golemTemplate("Golem" , lev);
				Battle b = new Battle(localCH , m , gameHost.getStage());
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setYCOR(localCH.ycor() + 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);
			}
			else if (getDown(trans.xcor() , trans.ycor()).equals("k")){
				m = new Monster();
				consoleMessage = "You fight a kobold.";
				m.koboldTemplate("Kobold" , lev);
				Battle b = new Battle(localCH , m , gameHost.getStage());
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setYCOR(localCH.ycor() + 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);
			}
			else if (getDown(trans.xcor() , trans.ycor()).equals("s")){
				m = new Monster();
				consoleMessage = "You fight a spider.";
				m.spiderTemplate("Spider" , lev);
				Battle b = new Battle(localCH , m , gameHost.getStage());
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setYCOR(localCH.ycor() + 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);
			}
			else if (getDown(trans.xcor() , trans.ycor()).equals("t")){
				treasureChest();
				consoleMessage = "You find a treasure chest!";
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setYCOR(localCH.ycor() + 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);
			}
			else if (getDown(trans.xcor() , trans.ycor()).equals("#")){
				consoleMessage = "You walked into a wall.";
			}
			else if (getDown(trans.xcor() , trans.ycor()).equals(" ")){
				consoleMessage = "Nothing special here.";
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setYCOR(localCH.ycor() + 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);
			}
			else {
/*
				System.out.println("ERROR - Please shut down game");
				System.out.println("ERROR: Invalid symbol in game map.");
				System.exit(0);
*/
				consoleMessage = "Travel Mechanism returned null error. Invalid symbol in game map";
			}
		}
		else if (dir.toUpperCase().equals("LEFT")){
			int lev = (int)(gameHost.getStage() / 10 + 1);
			Monster m = null;
			if (getLeft(trans.xcor() , trans.ycor()).equals("g")){
				m = new Monster();
				consoleMessage = "You fight a golem.";
				m.golemTemplate("Golem" , lev);
				Battle b = new Battle(localCH , m , gameHost.getStage());
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setXCOR(localCH.xcor() - 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);
			}
			else if (getLeft(trans.xcor() , trans.ycor()).equals("k")){
				m = new Monster();
				consoleMessage = "You fight a kobold.";
				m.koboldTemplate("Kobold" , lev);
				Battle b = new Battle(localCH , m , gameHost.getStage());
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setXCOR(localCH.xcor() - 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);

			}
			else if (getLeft(trans.xcor() , trans.ycor()).equals("s")){
				m = new Monster();
				consoleMessage = "You fight a spider.";
				m.spiderTemplate("Spider" , lev);
				Battle b = new Battle(localCH , m , gameHost.getStage());
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setXCOR(localCH.xcor() - 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);

			}
			else if (getLeft(trans.xcor() , trans.ycor()).equals("t")){
				treasureChest();
				consoleMessage = "You find a treasure chest!";
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setXCOR(localCH.xcor() - 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);

			}
			else if (getLeft(trans.xcor() , trans.ycor()).equals("#")){
				consoleMessage = "You walked into a wall.";
			}
			else if (getLeft(trans.xcor() , trans.ycor()).equals(" ")){
				consoleMessage = "Nothing special here.";
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setXCOR(localCH.xcor() - 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);

			}
			else {
/*
				System.out.println("ERROR - Please shut down game");
				System.out.println("ERROR: Invalid symbol in game map.");
				System.exit(0);
*/
				consoleMessage = "Travel Mechanism returned null error. Invalid symbol in game map";
			}
		}
		else if (dir.toUpperCase().equals("RIGHT")){
			int lev = (int)(gameHost.getStage() / 10 + 1);
			Monster m = null;
			if (getRight(trans.xcor() , trans.ycor()).equals("g")){
				m = new Monster();
				consoleMessage = "You fight a golem.";
				m.golemTemplate("Golem" , lev);
				Battle b = new Battle(localCH , m , gameHost.getStage());
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setXCOR(localCH.xcor() + 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);
			}
			else if (getRight(trans.xcor() , trans.ycor()).equals("k")){
				m = new Monster();
				consoleMessage = "You fight a kobold.";
				m.koboldTemplate("Kobold" , lev);
				Battle b = new Battle(localCH , m , gameHost.getStage());
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setXCOR(localCH.xcor() + 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);
			}
			else if (getRight(trans.xcor() , trans.ycor()).equals("s")){
				m = new Monster();
				consoleMessage = "You fight a spider.";
				m.spiderTemplate("Spider" , lev);
				Battle b = new Battle(localCH , m , gameHost.getStage());
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setXCOR(localCH.xcor() + 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);
			}
			else if (getRight(trans.xcor() , trans.ycor()).equals("t")){
				treasureChest();
				consoleMessage = "You find a treasure chest!";
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setXCOR(localCH.xcor() + 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);
			}
			else if (getRight(trans.xcor() , trans.ycor()).equals("#")){
				consoleMessage = "You walked into a wall.";
			}
			else if (getRight(trans.xcor() , trans.ycor()).equals(" ")){
				consoleMessage = "Nothing special here.";
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + " " + room[trans.ycor].substring(trans.xcor + 1);
				localCH.setXCOR(localCH.xcor() + 1);
				room[trans.ycor] = room[trans.ycor].substring(0,trans.xcor) + "@" + room[trans.ycor].substring(trans.xcor + 1);
			}
			else {
/*
				System.out.println("ERROR - Please shut down game");
				System.out.println("ERROR: Invalid symbol in game map.");
				System.exit(0);
*/
				consoleMessage = "Travel Mechanism returned null error. Invalid symbol in game map";
			}
		}
		else{
			System.out.println("Invalid direction");
		}
	}

	public void updateMap(){
		room[16] = consoleMessage;
		boolean rmCleared = false;
		int xenter = 0;
		int yenter = 0;
		if (room[1].substring(17,20).contains("@") || room[0].substring(17,20).contains("@")){
			rmCleared = true;
			xenter = 18;
			yenter = 12;
		}
		if (room[13].substring(17,20).contains("@")){
			rmCleared = true;
			xenter = 18;
			yenter = 2;
		}
		if (room[7].substring(0,2).contains("@")){
			rmCleared = true;
			xenter = 35;
			yenter = 7;
		}
		if (room[7].substring(36,38).contains("@")){
			rmCleared = true;
			xenter = 2;
			yenter = 7;
		}
		if (rmCleared){
			MapGen(xenter , yenter);
			gameHost.setStage(gameHost.getStage() + 1);
			rmCleared = false;
			localCH.setXCOR(xenter);
			localCH.setYCOR(yenter);
		}
		for(int i = 0; i < 18; i++){
			System.out.println(room[i]);
		}
	}
/*
	public static void main(String[] args){
		RoomGen rm = new RoomGen();
		System.out.println(rm.MapGen(2 , 5));
		for(int i = 0; i < 15; i++){
			System.out.println(rm.room[i]);
		}
		System.out.println(rm.getUp(2 , 5));
		System.out.println(rm.getDown(2 , 5));
		System.out.println(rm.getLeft(2 , 5));
		System.out.println(rm.getRight(2 , 5));
	}
*/
}
