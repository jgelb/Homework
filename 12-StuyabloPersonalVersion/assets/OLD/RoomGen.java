import java.util.*;
import java.io.*;

public class RoomGen{
	String room;
	public static String MapGen(){

//		BufferedReader br = new BufferedReader(new FileReader("BaseRoom.txt"));
		try{
			BufferedReader br = new BufferedReader(new FileReader("BaseRoom.txt"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			while (everything.contains(".")){
				// k = kobold
				// s = spider
				// g = golem
				// t = treasure chest
				Random x = new Random();
				int chance = x.nextInt(100);
				if (chance < 7) {
					everything.replaceFirst("." , "k");
				}
				else if (chance < 14) {
					everything.replaceFirst("." , "s");
				}
				else if (chance < 21) {
					everything.replaceFirst("." , "g");
				}
				else if (chance < 26) {
					everything.replaceFirst("." , "t");
				}
				else {
					everything.replaceFirst("." , " ");
				}
			}
			return everything;
		} catch(Exception e){e.printStackTrace(); return "NULL";}
	}

	public static void main(String[] args){
		System.out.println(MapGen());
	}
}
