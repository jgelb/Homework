import java.util.*;
import java.io.*;

public class RoomGen{
	String room;
	public static String MapGen(int column , int row){

//		BufferedReader br = new BufferedReader(new FileReader("BaseRoom.txt"));
		try{
			BufferedReader br = new BufferedReader(new FileReader("BaseRoom.txt"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			int tick = 1;
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				if (tick == row) {
					line = line.substring(0,column) + "@" + line.substring(5);
				}
				tick++;
			}
			String everything = sb.toString();
			int chance;
                       	while (everything.contains("B")){
				chance = (int)(Math.random() * 100);
               	                if (chance < 3) {
                       	                everything = everything.replaceFirst("B" , "k");
                               	}
                                else if (chance < 6) {
       	                                everything = everything.replaceFirst("B" , "s");
               	                }
                       	        else if (chance < 9) {
                               	        everything = everything.replaceFirst("B" , "g");
                               	}
                               	else if (chance < 12) {
                               	        everything = everything.replaceFirst("B" , "t");
                               	}
                               	else {
                               	        everything = everything.replaceFirst("B" , " ");
                               	}
			}
			return everything;
		} catch(Exception e){e.printStackTrace(); return "NULL";}
	}

	public static move(String dir , BaseChar trans){
		if (dir.toUpperCase().equals("UP")){

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
		System.out.println(MapGen(2 , 5));
	}
}
