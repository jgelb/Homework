import java.util.*;
import java.io.*;

public class Battle extends World{

	int gamestage;

	public Battle(BaseChar ch , Monster mon , int x){
		gamestage = x;
		while (ch.health() > 0 && mon.health() > 0) {
                	System.out.println(ch.name + " health: " + ch.health + "/" + ch.maxHealth);
                	System.out.println(mon.name + " health: " + mon.health + "/" + mon.maxHealth);
			attack1(ch , mon);
			try{
                                Thread.sleep(450);
                        } catch(Exception e) {}
			if (ch.health() > 0 && mon.health() > 0){
				attack2(mon , ch);
				try{
                                	Thread.sleep(1720);
                        	} catch(Exception e) {}
				System.out.print("\033\143");
			}
		}
	}

        public Battle(BaseChar ch , Monster mon){
		gamestage = 0; //Prevents crash
                while (ch.health() > 0 && mon.health() > 0) {
                        System.out.println(ch.name + " health: " + ch.health + "/" + ch.maxHealth);
                        System.out.println(mon.name + " health: " + mon.health + "/" + mon.maxHealth);
                        attack1(ch , mon);
                        try{
                                Thread.sleep(450);
                        } catch(Exception e) {}
                        if (ch.health() > 0 && mon.health() > 0){
                                attack2(mon , ch);
                                try{
                                        Thread.sleep(1720);
                                } catch(Exception e) {}
                                System.out.print("\033\143");
                        }
                }
        }


	public void endScreenMonster(BaseChar victor){
		System.out.println("You defeated the monster!");
		victor.setExperience(victor.experience + 20);
		System.out.println("You have gained 20 exp!");
		if (victor.experience() >= victor.level * 100){
			victor.setLevel(victor.level + 1);
			if (victor.level() == 3){
				System.out.println("You have unlocked your class special move!");
			}
			victor.setExperience(0);
			System.out.println("You have levelled up!");
			victor.setStrength(victor.strength() + 2);
			victor.setSpeed(victor.speed() + 1);
			victor.setDexterity(victor.dexterity() + 2);
			victor.setMaxHealth(victor.maxHealth() + 15);
		}
		victor.setHealth(victor.maxHealth());
                try{
                        Thread.sleep(1750);
                } catch(Exception e) {}
		System.out.print("\033\143");
	}

	public void endScreenBaseChar(BaseChar loser){
//		try{
//                        Thread.sleep(1750);
//                } catch(Exception e) {}
//                System.out.print("\033\143");
		System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*");
		System.out.println("You have died... Your story has ended.");
		System.out.println("You ended the game with: ");
		System.out.println(loser.level + " levels");
		System.out.println(loser.experience + " Exp");
		int score = loser.level() * 100 + loser.experience();
		System.out.println("Total score: " + score);
		System.out.println("Game exitting... You can respawn from your save file.");
		System.exit(0);
	}
/*
	public void attack1(BaseChar attacker, Monster defender){
		System.out.println(attacker.name + " is attacking " + defender.name);
		int damageTaken = (int)(Math.random() * 10000) % attacker.strength - (defender.dexterity / 5);
		defender.setHealth(defender.health - damageTaken);
		System.out.println(defender.name + " lost " + damageTaken + " health.");
		if (defender.health <= 0) {
			endScreenMonster(attacker);
		}
	}
*/


	public void attack1(BaseChar attacker , Monster defender){
		System.out.flush();
		System.out.println("You have engaged in battle against " + defender.name);
		System.out.println("1 - Basic Attack: Base Damage, Slight chance to heal on hit.");
		System.out.println("2 - Hail Mary: Slight chance to do double damage, but will miss otherwise");
		System.out.println("3 - Class Special: Use your class's signature move!");
		System.out.println("4 - Run: Try to escape the battle, but you will lose exp if you succeed and will get damaged heavily if you fail.");
		boolean checkResp = false;
                while (!checkResp){
                        System.out.print("Choose your action: ");
                        Scanner sc = new Scanner(System.in);
			int response;
			try {
                        	response = (int)sc.nextInt();
			} catch(Exception e) {
				response = -1;
			}
			Random n = new Random();
	                int chance = n.nextInt(100);
                        switch (response) {
				case 1:
					if (chance > defender.speed() - 5) {
						int damageTaken = (int)(Math.random() * 100000) % attacker.strength() - (defender.dexterity / 5);
						damageTaken = Math.abs(damageTaken) + attacker.level();
						defender.setHealth(defender.health - damageTaken);
						System.out.println(defender.name + " lost " + damageTaken + " health.");
						if ((int)(Math.random() * 100) < 30){
							attacker.setHealth(attacker.health() + (int)(damageTaken / 2));
							damageTaken = (int)(damageTaken / 2);
							System.out.println("You gained " + damageTaken + " health from your attack!");
						}
					}
					else {
						System.out.println("Attack missed!");
					}
					checkResp = true;
					break;
				case 2:
                                        if (chance < 15) {
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
					if (attacker.level() >= 3){
						if (attacker.type.equals("WARRIOR")){
							if (chance > defender.speed()) {
	                                                	int damageTaken = Math.abs((int)(Math.random() * 100000) % (attacker.level * 12) - (defender.dexterity / 5));
								damageTaken = damageTaken + attacker.level() * 3;
	                                                	defender.setHealth(defender.health - damageTaken);
								System.out.println("c===(=========>   Whirlwind blade!");
	                                                	System.out.println(defender.name + " lost " + damageTaken + " health.");
								System.out.println("Special move penalty: Take backlash damage!");
								int reflectDmg = (int)(damageTaken / 6);
								if (reflectDmg > 100){reflectDmg = 100;}
								attacker.setHealth(attacker.health - reflectDmg);
								System.out.println(attacker.name + " health: " + attacker.health + "/" + attacker.maxHealth);
	                                        	}
	                                        	else {
	                                                	System.out.println("Attack missed!");
	                                        	}
						}
						else if (attacker.type.equals("MAGE")){
							if (chance > defender.speed()) {
	                                                	int damageTaken = Math.abs((int)(Math.random() * 100000) % (int)(attacker.level * 10 + attacker.strength * 0.5) - (defender.dexterity / 5));
	                                                	damageTaken = damageTaken + attacker.level() * 2 + attacker.strength();
								defender.setHealth(defender.health - damageTaken);
								System.out.println("o-z-z-o-z-o-o-o-z-zo-zo-o-z Lightning fire storm!");
	                                                	System.out.println(defender.name + " lost " + damageTaken + " health.");
								System.out.println("Special move penalty: Electric essense shift!");
								int reflectDmg = attacker.level * 2;
								if (reflectDmg > 100){reflectDmg = 100;}
								attacker.setHealth(attacker.health - reflectDmg);
								System.out.println(attacker.name + " health: " + attacker.health + "/" + attacker.maxHealth);
                                	        	}
                        	                	else {
                	                                	System.out.println("Attack missed!");
        	                                	}
						}
						else if (attacker.type.equals("ARCHER")){
							if (chance > defender.speed()) {
	                                                	int damageTaken = (int)(Math.random() * 100000) % (attacker.speed * 3) - (defender.dexterity / 5);
								damageTaken = Math.abs(damageTaken) + (int)(attacker.level() * 1.5) + (int)(attacker.speed() / 2);
								defender.setHealth(defender.health - damageTaken);
								System.out.println("#~~~~~~~~=~~~~~~~~> Enchanted arrow!");
	                                                	System.out.println(defender.name + " lost " + damageTaken + " health.");
								System.out.println("Special move penalty: Splicing bow string!");
								int reflectDmg = (int)(damageTaken / 2);
								if (reflectDmg > 100){reflectDmg = 100;}
								attacker.setHealth(attacker.health() - reflectDmg);
								System.out.println(attacker.name + " health: " + attacker.health + "/" + attacker.maxHealth);
	                                        	}
	                                        	else {
	                                                	System.out.println("Attack missed!");
	                                        	}
						}
						else if (attacker.type.equals("DWARF")){
							if (chance > defender.speed()) {
	                                                	int damageTaken = (int)(Math.random() * 100000) % (int)(attacker.maxHealth() / 3 + attacker.dexterity) - (defender.dexterity / 5);
	                                                	damageTaken = damageTaken + attacker.level() + attacker.strength();
								damageTaken = Math.abs(damageTaken);
								defender.setHealth(defender.health - damageTaken);
								System.out.println(" -----) Wrath of the Pickaxe!");
	                                                	System.out.println(defender.name + " lost " + damageTaken + " health.");
								System.out.println("Special move penalty: Drunken rage hangover!");
								int reflectDmg = (int)(attacker.dexterity() / 3 + damageTaken / 2);
								if (reflectDmg > 120){reflectDmg = 120;}
								attacker.setHealth(attacker.health - reflectDmg);
								System.out.println(attacker.name + " health: " + attacker.health + "/" + attacker.maxHealth);
	                                        	}
	                                        	else {
	                                                	System.out.println("Attack missed!");
	                                        	}
						}
						else {
							System.out.println("An error occurred, Exception caught: BaseChar TYPE not defined or invalid");
						}
						checkResp = true;
					}
					else {
						System.out.println("You have not unlocked this move yet.");
					}
					break;
				case 4:
                                        if (chance < 5 + attacker.speed() - defender.speed()) {
                                                System.out.println("You ran away successfully!");
						attacker.setExperience(attacker.experience - 50);
						System.out.println("You lost 50 exp :( ");
                                                defender.setHealth(-1000000);
                                        }
                                        else {
                                                System.out.println("Your attempt to escape failed!");
                                        }
                                        checkResp = true;
					break;
/*				case 1337:
					System.out.println("Cheat code activated!");
					defender.setHealth(-9001);
					break;
*/				default:
					System.out.println("Invalid choice.");
					break;
			}
                }
		System.out.println(defender.name + " health: " + defender.health + "/" + defender.maxHealth);
		if (attacker.health <= 0) {
			endScreenBaseChar(attacker);
		}
		if (defender.health <= 0) {
			endScreenMonster(attacker);
		}
	}


	public void attack2(Monster attacker, BaseChar defender){
		Random n = new Random();
                int chance = n.nextInt(100);
                if (chance > defender.speed - 30) {
			System.out.println(attacker.name + " is attacking " + defender.name);
			int damageTaken = (int)(Math.random() * 10000) % attacker.strength - (defender.dexterity / 5);
			damageTaken = Math.abs(damageTaken) + (int)(gamestage / 3);
			defender.setHealth(defender.health - damageTaken);
			System.out.println(defender.name + " lost " + damageTaken + " health.");
			if (attacker.name().toUpperCase().equals("SPIDER") && gamestage > 40) {
				int poisonDmg = (int)(gamestage / 10);
				System.out.println("Spider has toxic fangs! You have taken " + poisonDmg +  " points of poison damage!");
				defender.setHealth(defender.health - poisonDmg);
			}
			if (attacker.name().toUpperCase().equals("KOBOLD") && gamestage > 40) {
				attacker.setStrength(attacker.strength() + gamestage - 40);
				System.out.println("Kobold grows in strength...");
			}
			if (attacker.name().toUpperCase().equals("GOLEM") && gamestage > 40) {
				attacker.setDexterity(attacker.dexterity() + gamestage - 40);
				System.out.println("Golem armor hardens...");
			}
			System.out.println(defender.name + " health: " + defender.health + "/" + defender.maxHealth);
			System.out.println("Waiting for turn end...");
			if (defender.health <= 0) {
				endScreenBaseChar(defender);
			}
		}
		else {
			System.out.println(attacker.name() + " missed!");
		}
	}
}
