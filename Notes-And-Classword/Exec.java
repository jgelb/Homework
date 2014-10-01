public class Exec{
	public String box(int r,int c){
		String RIVEN = new String("");
		while (RIVEN.length() < c) {
			RIVEN = RIVEN + "#";
		}
		int i = 0;
		String save = new String(RIVEN);
		while (i < r) {
			RIVEN = RIVEN + "\n" + save;
			i++;
		}
		return RIVEN;
	}
	public static void main(String[] args){
		Exec bleah = new Exec();
		System.out.println(bleah.box(4,3));
	}
}
