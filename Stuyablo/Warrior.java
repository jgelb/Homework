public class Warrior extends Basechar{
    int healthboost=10;
    public Warrior (String n) {
	super(n);
	this.health=this.health + healthboost;
    }
    /*
      public void Attack (Basechar other) {
      System.out.println(this + " is attacking " + other + "!!!");
      }
    */
}