public class Monster extends Basechar{
    int healthboost=(int)Math.ceil(Math.random()*500)+200;
    public Monster (String n) {
	super(n);
	this.health = this.health + healthboost;
	this.attack = this.attack + (int)Math.ceil(Math.random()*5);
    }
    /*
      public void Attack (Basechar other) {
      System.out.println(this + " is attacking " + other + "!!!");
      }
    */
}
