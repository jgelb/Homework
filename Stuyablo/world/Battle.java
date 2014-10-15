import java.util.*;
import java.io.*;

public class Battle extends World{

	public Battle(Basechar ch , Monster mon){
		while (ch.health() > 0 || mon.health() > 0) {
			attack(ch , mon);
			attack(mon , ch);
		}
	}

	public void endScreenMonster(BaseChar victor){
		System.out.println("You defeated the monster!");
		victor.setExperience(victor.experience + 20);
		System.out.println("You have gained 20 exp!");
		if (victor.experience() >= victor.level * 100){
			victor.setLevel(victor.level + 1);
			victor.setExperience(0);
			System.out.println("You have levelled up!");
			victor.setStrength(victor.strength() + 1);
			victor.setSpeed(victor.speed() + 1);
			victor.setDexterity(victor.dexterity() + 1);
			victor.setMaxHealth(victor.maxHealth() + 10);
		}
		victor.setHealth(victor.maxHealth());
	}

	public void endScreenBaseChar(BaseChar loser){
		System.out.println("You have died... Your story has ended.");
		System.out.println("You ended the game with: ");
		System.out.println(loser.level + " levels");
		System.out.println(loser.experience + "Exp");
		boolean checkResp = false;
		while (!checkResp){
			System.out.print("Do you wish to be reborn anew?");
			Scanner sc = new Scanner();
			if (sc.next().toUpper.equals("Y") || sc.next().toUpper.equals("YES")){
				//RESTART THE GAME HERE
				checkResp = true;
			}
			else if (sc.next().toUpper.equals("N") || sc.next().toUpper.equals("NO")){
				//Exit cleanly
				checkResp = true;
			}
			else {
				System.out.println("Make a choice! Yes/No, Y/N");
			}
		}
	}

	public void attack(BaseChar attacker, Monster defender){
		System.out.println(attacker.name + " is attacking " + defender.name);
		int damageTaken = (int)(Math.random() * 10000) % attacker.strength - (defender.dexterity / 5);
		defender.setHealth(defender.health - damageTaken);
		System.out.println(defender.name + " lost " + damageTaken + " health.");
		if (defender.health <= 0) {
			endScreenMonster(attacker);
		}
	}

	public void attack(Monster attacker, BaseChar defender){
		System.out.println(attacker.name + " is attacking " + defender.name);
		int damageTaken = (int)(Math.random() * 10000) % attacker.strength - (defender.dexterity / 5);
		defender.setHealth(defender.health - damageTaken);
		System.out.println(defender.name + " lost " + damageTaken + " health.");
		if (defender.health <= 0) {
			endScreenBaseChar(defender);
		}
	}
}
