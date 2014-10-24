//working
//worked with Tommy Li, Joseph Gelb, and Alice Xue
import java.io.*;
import java.util.*;
import java.util.Scanner;
public class Basechar {
//all variables
public int health = 100;
public int attack = 20;
public int Sandwich = 1;
public int Level = 1;
public int Potion = 3;
//when a attacks b, b will be hit with this much damage as (a's attack - b's defense)
int defense = 10; //let that be the number of points of health points they save
private String name = "default name";
//all the methods to set up
public Basechar(String n){
setName(n);
setHealth(health);
}
public void setName(String name){
this.name= name;
}
public void setHealth(int h){
this.health=h;
}
//all the get methods to get stuff
public String getName(){
return name;
}
public int getAttack(){
return attack;
}
public int getDefense(){
return defense;
}
public String toString(){
return this.getName();
}
//the methods that do stuff
public void Waitaminute(int n){
try{ Thread.sleep(n);
} catch (Exception e) {}
}
public void Sighting(Basechar other){
System.out.println("");
System.out.println("You are just strolling along through a dark scary forest for no apparent reason.");
System.out.println("You have " +this.health +" health.");
System.out.println("A wild "+ other +" with health " + other.health + " appeared. What will you do?");
this.Encounter(other);
}
public void Encounter(Basechar other){
System.out.println("");
System.out.println("Would you like to attack or run or eat a sandwich?");
System.out.println("Enter a to attack, r to run, or e to eat a sandwich");
Scanner scanner= new Scanner(System.in);
String Action = scanner.nextLine();
if (Action.equals("a")) {
while (this.health > 0 && other.health > 0){
this.Choices(other);
}
}
if (Action.equals("r")) {
this.Run(other);
}
if (Action.equals("e")){
this.Sandwich(other);
this.Encounter(other);
}
for (int i = 0; i < 20; i++) {
System.out.print("\f");
}
}
public void Choices (Basechar other){
System.out.println("");
System.out.println("You are now ready to attack");
System.out.println ("What would you like to do?");
System.out.println ("Enter a to attack, e to eat a sandwich, or d to drink a health potion");
Scanner scanner= new Scanner(System.in);
String Action = scanner.nextLine();
if (Action.equals("a")){
this.AttackThingy(other);
}
if (Action.equals("e")){
this.Sandwich(other);
this.Choices(other);
}
if (Action.equals("d")){
int add=(int)Math.ceil(Math.random()*30);
if (Potion > 0){
System.out.println("You just drank a potion");
if(this.health < 100){
this.health = this.health + add + 30;
}
System.out.println("Your health is now " + this.health );
Potion = Potion - 1;
System.out.println("YOU ONLY HAVE "+this.Potion+" POTIONS LEFT!!!");
this.Choices(other);
}
else{
System.out.println("You have no potions");
this.Choices(other);
}
}
}
public void AttackThingy(Basechar other){
if (this.health>0 && other.health>0){
if (this.health > 0){
this.Fight(other);
}
if (other.health > 0){
other.Fight(this);
}
this.Endcheck(other);
}
}
public void Fight(Basechar other){
System.out.println("");
System.out.println(this + " is attacking " + other + "!!!");
Waitaminute(1000);
int damage = this.getAttack()+ (int)Math.ceil(Math.random()*20) - other.getDefense() + 10;
other.health= other.health - damage;
System.out.println(this + " did " + Integer.toString(damage)+" damage to "+other);
Waitaminute(500);
System.out.println(other + "'s health: " + Integer.toString(other.health));
Waitaminute(250);
System.out.println(this + "'s health: " + Integer.toString(this.health));
}
public void Run(Basechar other){
int val = (int) Math.ceil(Math.random()*100000);
Waitaminute(2000);
if (val % 2 == 0){
System.out.println("You weren't fast enough. You know you're not Usain Bolt, right?");
System.out.println("Back to square one. Try again:");
this.Encounter(other);
} else {
this.health = 0;
System.out.println("You escaped, but tripped on a rock and died. Natural selection at its best...");
this.Endcheck(other);
}
}
public void Sandwich(Basechar other){
int random=(int)Math.ceil(Math.random()*10000);
int up= (int)Math.ceil(Math.random()*10);
System.out.println("");
if (this.Sandwich > 0){
System.out.println("Your sandwich is magically delicious. It's so awesome that ");
if (random % 14 == 5 ){
System.out.println("it is a nice sandwich.");
System.out.println("You should probobly get back to that fight you were just in...");
System.out.println("Life and death situations unfortunately don't come with lunch breaks! Sorry.");
}
if (random % 7 == 0 || random % 7 == 2 || random % 7 == 4){
this.health = this.health + (int)Math.ceil(Math.random()*50) + 100;
System.out.println("your health has been restored to " + this.health+ ". It would be pretty sad if you lost now :(");
}
if (random % 7 == 1){
this.defense = this.defense + up;
System.out.println("your defense has gone up by " + Integer.toString(up) + " points. Go get 'em juggernaut!!!");
}
if (random % 7 == 3 || random %7 ==6){
up=up+5;
this.attack = this.attack + up;
System.out.println("your attack has gone up by " + Integer.toString(up) + " points. Now maybe you stand a chance :P");
}
this.Sandwich = this.Sandwich - 1;
System.out.println("YOU HAVE "+this.Sandwich+" SANDWICHES LEFT!!!");
}else{
System.out.println ("You are all out of food. You ate it all without even sharing.");
}
}
public void Endcheck(Basechar other){
if (this.health<=0){
System.out.println(this+", you lost. Wow... That's pretty sad...");
}
if (other.health<=0){
System.out.println("You have vanquished "+other+". Game over and you are now AWESOME!!!");
}
}
}

