public class Mob{
	public int health;
	public String name;
	public int dexterity; //Damage redux
	public int strength; //Attack Damage
	public int speed; //Movement and attack speed
	public int level;
	public int experience;

	public Mob(int h, String s, int l, int atkdmg, int dex, int spd){
		health = h;
		name = s;
		level = l;
		experience = 0;
		strength = atkdmg;
		dexterity = dex;
		speed = speed;
	}

	public attack(Mob attacker, Mob defender){
		System.out.println(attacker.name + " is attacking " + defender.name);
		int damageTaken = attacker.strength + (defender.dexterity / 5);
		defender.health = defender.health - damageTaken;
		System.out.println(defender.name + " lost " + damageTaken);
		if (defender.health <= 0) {
			
		}
	}
}
