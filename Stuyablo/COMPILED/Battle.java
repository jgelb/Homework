import java.util.*;
import java.io.*;

public class Battle extends World{

	public Battle(BaseChar ch , Monster mon){
		while (ch.health() > 0 && mon.health() > 0) {
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
			Scanner sc = new Scanner(System.in);
			String response = sc.next();
			if (response.toUpperCase().equals("Y") || response.toUpperCase().equals("YES")){
				//RESTART THE GAME HERE
				checkResp = true;
			}
			else if (response.toUpperCase().equals("N") || response.toUpperCase().equals("NO")){
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


/*
	public void attack(BaseChar attacker , Monster defender) {
		System.out.println("You have engaged in battle against a " + defender.name);
		System.out.println("1 - Basic Attack: Base Damage");
		System.out.println("2 - Hail Mary: Slight chance to do double damage, but will miss otherwise");
		System.out.println("3 - Class Special: Use your class's signature move!");
		System.out.println("4 - Run: Try to escape the battle, but you will lose exp if you succeed and will get damaged heavily if you fail.");
		boolean checkResp = false;
                while (!checkResp){
                        System.out.print("Choose your action: ");
                        Scanner sc = new Scanner(System.in);
                        int response = (int)sc.nextInt();
                        switch (response) {
				case 1:
					Random n = new Random();
			                int chance = n.nextInt(100);
					if (n > defender.speed) {
						int damageTaken = (int)(Math.random() * 100000) % attacker.strength - (defender.dexterity / 5);
						defender.setHealth(defender.health - damageTaken);
						System.out.println(defender.name + " lost " + damageTaken + " health.");
					}
					else {
						System.out.println("Attack missed!");
					}
					checkResp = true;
					break;
				case 2:
                                        Random n = new Random();
                                        int chance = n.nextInt(100);
                                        if (n < 15) {
                                                int damageTaken = attacker.strength * 2;
                                                defender.setHealth(defender.health - damageTaken);
                                                System.out.println(defender.name + " lost " + damageTaken + " health.");
                                        }
                                        else {
                                                System.out.println("Attack missed!");
                                        }
                                        checkResp = true;
					break;
				case 3:
                                        Random n = new Random();
                                        int chance = n.nextInt(100);
                                        if (n > defender.speed) {
                                                int damageTaken = (int)(Math.random() * 100000) % attacker.strength - (defender.dexterity / 5);
                                                defender.setHealth(defender.health - damageTaken);
                                                System.out.println(defender.name + " lost " + damageTaken + " health.");
                                        }
                                        else {
                                                System.out.println("Attack missed!");
                                        }
                                        checkResp = true;
					break;
				case 4:
                                        Random n = new Random();
                                        int chance = n.nextInt(100);
                                        if (n < 2) {
                                                System.out.println("You ran away successfully!");
						attacker.setExperience(attacker.experience - 50);
						System.out.println("You lost 50 exp :( ");
                                                defender.setHealth(-100);
                                        }
                                        else {
                                                System.out.println("Attack missed!");
                                        }
                                        checkResp = true;
					break;
				default:
					System.out.println("Invalid choice.");
					break;
			}
                }
		if (defender.health <= 0) {
			endScreenMonster(attacker);
		}
	}
*/

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
