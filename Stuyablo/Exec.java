import java.util.*;
import java.io.*;
import mobs.*;
import world.*;

public class Exec{
	public static void main(String[] args){
		BaseChar Harry = new BaseChar();
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<4; i++){
			System.out.print(i + " - ");
			switch (i) {
				case 0:
					Harry.warriorTemplate("Harry").displayStats();
				case 1:
					Harry.mageTemplate("Harry").displayStats();
				case 2:
					Harry.archerTemplate("Harry").displayStats();
				case 3:
					Harry.dwarfTemplate("Harry").displayStats();
				default:
					Harry.displayStats();
			}
		}
		boolean chosen = false;
		while (!chosen){
			switch (sc.nextInt()) {
				case 0:
					Harry.warriorTemplate("Harry");
					chosen = true;
				case 1:
					Harry.mageTemplate("Harry");
					chosen = true;
				case 2:
					Harry.archerTemplate("Harry");
					chosen = true;
				case 3:
					Harry.dwarfTemplate("Harry");
					chosen = true;
				default:
					System.out.println("Invalid choice. Please choose again.");
			}
		}
		System.out.print("Name your character: ");
		Harry.setName(sc.next());
		Labyrinth PLACE = new Labyrinth(Harry);
		PLACE.super.stage = 1;
		while (PLACE.super.stage < 200) {
			PLACE.move(Harry);
		}
	}
}
