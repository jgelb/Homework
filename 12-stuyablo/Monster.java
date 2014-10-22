import java.util.*;
import java.io.*;

public class Monster extends Mob{

/*
	public Monster(int h, String s, int l, int atkdmg, int dex, int spd){
		super.health = h;
		super.name = s;
		super.level = l;
		super.experience = 0;
		super.strength = atkdmg;
		super.dexterity = dex;
		super.speed = speed;
	}
*/

//Data Grabbers
	public int health(){return super.health;}
	public int level(){return super.level;}
	public int experience(){return super.experience;}
	public int dexterity(){return super.dexterity;}
	public int speed(){return super.speed;}
	public int strength(){return super.strength;}
	public int maxHealth(){return super.maxHealth;}
	public String name(){return super.name;}

//Data Setters
	public void setHealth(int n){super.health = n;}
	public void setExperience(int n){super.experience = n;}
	public void setLevel(int n){super.level = n;}
	public void setStrength(int n){super.strength = n;}
	public void setDexterity(int n){super.dexterity = n;}
	public void setSpeed(int n){super.speed = n;}
	public void setMaxHealth(int n){super.maxHealth = n;}
	public void setName(String s){super.name = s;}

//Monster Templates
/*
	Kobold - Object (Attacks fast (more attacks per turn), low health)
	Spider - Object (High Speed, Low Health, Low Dexterity)
	Golem - Object (High Health, High Dexterity, Low Speed)
	**QuestBoss** Dragon - Object (+50 on all stats)
	**QuestBoss** The_Predator - Object (+75 on all stats except speed, +150 speed)
	**QuestBoss** The_GateKeeper - Object [SPECIAL CONDITION: only appears on last level of labyrinth] 
	              (+ 9001 on all stats except speed, Has 0 Speed (cannot avoid attacks)
*/

	public void koboldTemplate(String s, int l){
		super.health = 20 + 2 * l;
		super.maxHealth = super.health;
		super.name = s;
		super.level = l;
		super.experience = 0;
		super.strength = 5 + l;
		super.dexterity = 5 + l;
		super.speed = 15 + l;
	}

	public void spiderTemplate(String s, int l){
		super.health = 20 + 2 * l;
		super.maxHealth = super.health;
		super.name = s;
		super.level = l;
		super.experience = 0;
		super.strength = 5 + l;
		super.dexterity = 1 + l;
		super.speed = 15 + l;
	}

	public void golemTemplate(String s, int l){
		super.health = 40 + 2 * l;
		super.maxHealth = super.health;
		super.name = s;
		super.level = l;
		super.experience = 0;
		super.strength = 7 + l;
		super.dexterity = 8 + l;
		super.speed = 2 + l;
	}

	public void DRAGONTemplate(String s, int l){
		super.health = 150 + 5 * l;
		super.maxHealth = super.health;
		super.name = s;
		super.level = l;
		super.experience = 0;
		super.strength = 50 + l;
		super.dexterity = 50 + l;
		super.speed = 50;
	}

	public void PREDATORTemplate(String s, int l){
		super.health = 175 + 5 * l;
		super.maxHealth = super.health;
		super.name = s;
		super.level = l;
		super.experience = 0;
		super.strength = 75 + l;
		super.dexterity = 75 + l;
		super.speed = 125;
	}

	public void GATEKEEPERTemplate(String s, int l){
		super.health = 9001;
		super.maxHealth = super.health;
		super.name = s;
		super.level = l;
		super.experience = 0;
		super.strength = 9001;
		super.dexterity = 9001;
		super.speed = 0;
	}

    
	public void displayStats(){
  	        System.out.println("Name:       " + super.name);
		System.out.println("Health:        " + super.health);
		System.out.println("Strength:      " + super.strength);
		System.out.println("Dexterity:     " + super.dexterity);
		System.out.println("Speed:         " + super.speed);
		System.out.println("=====================================");
	}
    
}
