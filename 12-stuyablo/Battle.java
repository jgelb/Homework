import java.io.*;
import java.util.*;

//<<<<<<< HEAD

public class Battle extends World {

    public Battle(BaseChar b , Monster m){
	while (b.health() > 0 && m.health() > 0){
	    charAttackMonster(b , m);
	    monsterAttackChar(m , b);
	}
	if (m.health() <= 0) {
	    b.setHealth(b.maxHealth());
	    b.setLevel(b.level() + 1);
	}
	else {
	    System.out.println("You ded.");
	    System.exit(0);
	}
    }

    	public void charAttackMonster(BaseChar b , Monster m){
		boolean gotaway = false;
		boolean turn = true;
		System.out.println("1. Attack");
		System.out.println("2. Run Away");
		System.out.println("Choose 1 or 2");
		Scanner sc = new Scanner(System.in);
		int response = (int)(sc.nextInt());
		if (!gotaway && turn) {
			switch (response) {
				case 1:
	  			        //m.setHealth((m.health() - (b.strength()- m.dexterity()))); - Old code - Changes made by Ethan
					int damageTaken = b.strength() - m.dexterity(); // - Ethan
					damageTaken = Math.abs(damageTaken); //PREVENT NEGATIVE DAMAGE!!! - Ethan
					m.setHealth(m.health() - damageTaken); // - Ethan
			    		System.out.println("Monster has " + m.health() + " health."); //Fixed printout
			    		turn = false;
					break;
				case 2:
					int randNum = (int)(Math.random() * 100);
			    		if (randNum > 50) {
						System.out.println("You can't run away.");
						turn = false;
			    		}
					else {
						System.out.println("You got away safely.");
						gotaway = true;
			    		}
					break;
				default:
			    		System.out.println("Wrong input, try again.");
					break;
			}
		}
    	}

    	public void monsterAttackChar(Monster m , BaseChar b){
		boolean turn = true;
		int damageTaken = m.strength() - b.dexterity(); // Ethan
		damageTaken = Math.abs(damageTaken); // Ethan
		b.setHealth(b.health() - damageTaken); // Ethan
		System.out.println("You have " + b.health() + " health."); // Ethan
    	}
    /*switch (basechar.health()>0 && gotaway == false){
      case 1:
      break;
      case 2:
      break;
      default:
      break;
    */
}
