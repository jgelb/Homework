public class Driver{
	public static void main(String[] args){
		BaseChar c = new BaseChar();
		c.setHealth(450);
		System.out.println(c.getHealth());
		Warrior w = new Warrior(15);
		System.out.println(w.getHealth());
	}
}
