import java.util.*;
import java.io.*;

public class RoomGen{
	String[] room = new String[15];
	BaseChar localCH;
	Labyrinth gameHost;

	public RoomGen(BaseChar bc , Labyrinth l){
		localCH = bc;
		gameHost = l;
	}

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
               	                	if (chance < 3) {
                       	        	        line = line.replaceFirst("B" , "k");
                               		}
                                	else if (chance < 6) {
       	                        	        line = line.replaceFirst("B" , "s");
               	                	}
                       	        	else if (chance < 9) {
                               		        line = line.replaceFirst("B" , "g");
                               		}
	                               	else if (chance < 12) {
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
					line = line.substring(0,column) + "@" + line.substring(5);
				}
				tick++;
			}
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

	public static void move(String dir , BaseChar trans){
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
                m.setMaxHealth(m.maxHealth() + (int)(super.stage / 2) + (int)(lev / 2.5) + (int)(player.maxHealth() / 30));
                m.setHealth(m.maxHealth());
*/
			int lev = (int)(gameHost.getStage() / 10 + 1);
			Monster m = null;
			if (getUp(trans.xcor() , trans.ycor()).equals("g")){
				m = new Monster();
				m.golemTemplate("Golem" , lev);
				//Battle
			}
			else if (getUp(trans.xcor() , trans.ycor()).equals("k")){

			}
			else if (getUp(trans.xcor() , trans.ycor()).equals("s")){

			}
		}
		else if (dir.toUpperCase().equals("DOWN")){

		}
		else if (dir.toUpperCase().equals("LEFT")){

		}
		else if (dir.toUpperCase().equals("RIGHT")){

		}
		else{

		}
	}

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
}
