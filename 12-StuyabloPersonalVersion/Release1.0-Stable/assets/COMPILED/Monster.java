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
		super.health = 20 + 3 * l;
		super.maxHealth = super.health;
		super.name = "Kobold";
		super.level = l;
		super.experience = 0;
		super.strength = 5 + 2 * l;
		if (super.strength > 88){
			super.strength = 88;
		}
		super.dexterity = 5 + 2 * l;
		super.speed = 15 + l;
		if (super.speed > 50) {
			super.speed = 50;
		}
//		super.type = "KOBOLD";
	}

	public void spiderTemplate(String s, int l){
		super.health = 20 + 3 * l;
		super.maxHealth = super.health;
		super.name = "Spider";
		super.level = l;
		super.experience = 0;
		super.strength = 5 + 2 * l;
                if (super.strength > 82){
                        super.strength = 82;
                }
		super.dexterity = 1 + 2 * l;
		super.speed = 15 + 2 * l;
		if (super.speed > 50) {
                        super.speed = 50;
                }
//		super.type = "SPIDER";
	}

	public void golemTemplate(String s, int l){
		super.health = 40 + 3 * l;
		super.maxHealth = super.health;
		super.name = "Golem";
		super.level = l;
		super.experience = 0;
		super.strength = 7 + 2 * l;
		super.dexterity = 8 + 2 * l;
		super.speed = 2 + l;
		if (super.speed > 80) {
                        super.speed = 80;
                }
//		super.type = "GOLEM";
                if (super.strength > 125){
                        super.strength = 125;
                }
	}

	public void DRAGONTemplate(String s, int l){
		super.health = 500;
		super.maxHealth = super.health;
		super.name = s;
		super.level = l;
		super.experience = 0;
		super.strength = 28 + l;
		super.dexterity = 10 + l;
		super.speed = 20;
	}

	public void PREDATORTemplate(String s, int l){
		super.health = 1000;
		super.maxHealth = super.health;
		super.name = s;
		super.level = l;
		super.experience = 0;
		super.strength = 75 + l;
		super.dexterity = 5 + l;
		super.speed = 55;
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
}
