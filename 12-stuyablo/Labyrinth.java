/*
  What LABYRINTH does:
  increments stage number
  selects random monster to battle
  Note: use LabyrinthTest to run
  Note: type "move" to move to next level
*/

import java.io.*;
import java.util.*;

public class Labyrinth extends World{
    
    public int getStage() {
	return super.stage;
    }
    
    public void setStage(int n){
	super.stage = n;
    }

    public void quest(){
	while (getStage() < 5) {
	    	
	    String input = new String();
	    //input = "This is the input var right now";
	    //System.out.println(input);
	    Scanner sc = new Scanner(System.in);
	    while (!input.equals("move")) {
		System.out.println("Make your next move!");
		input = sc.nextLine();
	    }
	
	
	    int randNum = (int)(Math.random() * 100);
	    System.out.println(randNum);
	

	    Monster m = new Monster();
	    if (randNum<=34) {
		m.koboldTemplate("I am kobold", 1);
	    }
	    else if (randNum<=67) {
		m.spiderTemplate("I am spider", 1);
	    }
	    else {
		m.golemTemplate("I am golem", 1);
	    }
	    m.displayStats();

	    setStage( getStage() + 1 );
	    
	    BaseChar b = new BaseChar(); //basechar should be set to either warrior or mage
	    b.warriorTemplate("I am warrior"); //this really shouldn't be here. This should be in the Driver and user-selected
	    b.displayStats();
	    Battle bat = new Battle(b,m);	    
	    bat.charAttackMonster(b,m);
	    bat.monsterAttackChar(m,b);	    

	}
    }
}
