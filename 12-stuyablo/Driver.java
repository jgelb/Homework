import java.io.*;
import java.util.*;


public class Driver{

    public static void main (String[]args){
        newGame();
    }

    //starting a new game

    public static void newGame(){
    	System.out.println("WELCOME TO STUYABLO3979");
    	BaseChar b = new BaseChar();
    	Scanner sc = new Scanner(System.in);
    	//Select type of character
    	System.out.println("Choose the number to your fate!\n");
    	System.out.println("Number 1:\n");
    	b.warriorTemplate("Plum");
    	b.displayStats();
    	System.out.println("Number 2:\n");
    	b.mageTemplate("Plum");
    	b.displayStats();
    	System.out.println("Number 3:\n");
    	b.archerTemplate("Plum");
    	b.displayStats();
    	System.out.println("Number 4:\n");
    	b.dwarfTemplate("Plum");
    	b.displayStats();
        int i = sc.nextInt(); //Note this will crash if user inputs non-integer. Figure out how to prevent crash! - Ethan
        if (i == 1){
            System.out.println("You are now on the road to become a great Warrior");
        }
        if ( i == 2){
            System.out.println("May the magic be with you! You are now a mage!");
        }
        if ( i == 3){
            System.out.println("Aim your bow and arrows, danger is lurking!");
        }
        if (i == 4){
            System.out.println("Do not underestimate small people, there is much adventure in your future!");
         }
        System.out.println("Onwards to the jorney of a lifetime.");
        System.out.println("You have encountered a small hole.");
        System.out.println("Something pulls you into the hole.");
        System.out.println("...What the heck, where am I?");
        System.out.println("FIGHT YOUR WAY OUT OR DIE!");
        //Starts the labyrinth here
        System.out.println("When we say make a move, we mean type move");
        Labyrinth lab = new Labyrinth();
        lab.quest();
    	System.out.println( lab.getStage() );
	lab.setStage(100);
	System.out.println( lab.getStage() );
    }
}

//Cleaned up random whitespace - Ethan
