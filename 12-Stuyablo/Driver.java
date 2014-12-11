//working
import java.util.Scanner;
public class Driver{
    public static void main (String[] args){
	System.out.println("Welcome to Stuyablo Deluxe Super Swag 6.9");
	System.out.println("Please enter your name:");
	Scanner scannerp1= new Scanner(System.in);
	String p1= scannerp1.nextLine()+" the Boss";
	Warrior yolo= new Warrior(p1);
	System.out.println("");
	System.out.println("Please enter the name of your enemy:");
	Scanner scannerai= new Scanner(System.in);
	String ai= scannerai.nextLine();
	Monster aslo= new Monster(ai);
	yolo.Sighting(aslo);
    }
}