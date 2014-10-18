import java.util.*;
import java.io.*;

public class ExecOLD{
	public static void main(String[] args){
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
}
