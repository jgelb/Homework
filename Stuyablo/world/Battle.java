import java.util.*;
import java.io.*;

public class Battle extends World{
	public void endScreenMonster(BaseChar victor){
		System.out.println("You defeated the monster!");
		victor.setExperience(victor.experience() + 20);
		System.out.println("You have gained 20 exp!");
		if (victor.experience() >= victor.level() * 100){
			victor.setLevel(victor.level() + 1);
			victor.setExperience(0);
			System.out.println("You have levelled up!");
		}
	}

	public void endScreenBaseChar(){

	}

	public void attack(BaseChar attacker, Monster defender){
		System.out.println(attacker.name() + " is attacking " + defender.name());
		int damageTaken = (int)(Math.random() * 10000) % attacker.strength() - (defender.dexterity() / 5);
		defender.setHealth(defender.health() - damageTaken);
		System.out.println(defender.name() + " lost " + damageTaken + " health.");
		if (defender.health() <= 0) {
			endScreenMonster(attacker);
		}
	}

	public void attack(Monster attacker, BaseChar defender){
		System.out.println(attacker.name() + " is attacking " + defender.name());
		int damageTaken = (int)(Math.random() * 10000) % attacker.strength() - (defender.dexterity() / 5);
		defender.setHealth(defender.health() - damageTaken);
		System.out.println(defender.name() + " lost " + damageTaken + " health.");
		if (defender.health() <= 0) {
			endScreenBaseChar();
		}
	}
}
