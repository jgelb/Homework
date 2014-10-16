import java.util.*;
import java.io.*;

public class Exec{
	public static void main(String[] args){
		BaseChar Harry = new BaseChar();
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<4; i++){
			System.out.print(i + " - ");
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
		Labyrinth game = new Labyrinth(Harry);
		game.setStage(1);
		while (game.getStage() < 200) {
			game.move();
		}
	}
}
