public class Exec{
	public static void main(String[] args){
		BaseChar Harry = new BaseChar();
		Scanner sc = new Scanner();
		for (int i=0; i<4; i++){
			System.out.print(i + " - ");
			switch (i) {
				case 0:
					Harry.warriorTemplate().displayStats();
				case 1:
					Harry.mageTemplate().displayStats();
				case 2:
					Harry.archerTemplate().displayStats();
				case 3:
					Harry.dwarfTemplate().displayStats();
				default:
					Harry.displayStats();
			}
		}
		boolean chosen = false;
		while (!chosen){
			switch (sc.nextInt()) {
				case 0:
					Harry.warriorTemplate();
					chosen = true;
				case 1:
					Harry.mageTemplate();
					chosen = true;
				case 2:
					Harry.archerTemplate();
					chosen = true;
				case 3:
					Harry.dwarfTemplate();
					chosen = true;
				default:
					System.out.println("Invalid choice. Please choose again.");
			}
		}
		System.out.print("Name your character: ");
		Harry.setName(sc.next());
		Labyrinth PLACE = new Labyrinth(Harry);
		
	}
}
