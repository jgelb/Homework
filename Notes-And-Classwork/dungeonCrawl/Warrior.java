//Subclass of superclass BaseChar
public class Warrior extends BaseChar{ //Takes info from class Character
	private int healthBoost = 5;
	//Subclass can access public things in superclass, but not PRIVATE
	//via the variable 'super', indicating 1 class higher

	public Warrior(int h){
		super.setHealth(healthBoost + h);
	}
}
