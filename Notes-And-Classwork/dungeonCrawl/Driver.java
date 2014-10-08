public class Driver{

	public static void main(String[] args){
/*
		BaseChar c = new BaseChar();
		c.setHealth(450);
		System.out.println(c.getHealth());
		Warrior w = new Warrior(15);
		System.out.println(w.getHealth());
		Mage m = new Mage();
		w.setName("Garen");
		m.setName("Ryze");
		w.attack(m);
*/

		Mage m1 = new Mage();
		Mage m2 = new Mage("Morgana");
		Mage m3 = new Mage(50000);

		System.out.println(m1.getName());
		System.out.println(m2.getName());
		System.out.println(m3.getManna());


	}
}
