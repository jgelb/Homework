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
			return everything;
		} catch(Exception e){e.printStackTrace(); return "NULL";}
	}

	public static void main(String[] args){
		System.out.println(MapGen());
	}
}
