public class BaseChar{
	private int health = 20;
	private String name;
/*
	public BaseChar(String n){
		setName(n);
	}

	public BaseChar(){
		setName("DefGoon");
	}
*/
	public void setName(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void attack(BaseChar other) {
		System.out.println(this.getName() + " is attacking " + other.getName());
	}

	public int getHealth(){
		return health;
	}
	public void setHealth(int i){
		health = i;
	}
}

