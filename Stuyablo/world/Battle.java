import java.util.*;
import java.io.*;

public class Battle{
	public void endScreenMonster(){
		
	}

	public void endScreenBaseChar(){

	}

	public void attack(BaseChar attacker, Monster defender){
		System.out.println(attacker.name() + " is attacking " + defender.name());
		int damageTaken = (int)(Math.random() * 10000) % attacker.strength() - (defender.dexterity() / 5);
		defender.setHealth(defender.health() - damageTaken);
		System.out.println(defender.name() + " lost " + damageTaken + " health.");
		if (defender.health() <= 0) {
			endScreenMonster();
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
