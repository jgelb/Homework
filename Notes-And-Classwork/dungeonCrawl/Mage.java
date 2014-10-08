public class Mage extends BaseChar{
	private int manna = 20;

	public Mage(String n){
		super.setName(n);
	}

	public Mage(){
		super.setName("DefGoon");
	}

	public Mage(int m){
		manna = m;
	}

	public int getManna(){
		return manna;
	}
}
