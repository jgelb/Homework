public class BattleTest {
    public static void main(String[] args){
	
	BaseChar b = new BaseChar();
	Monster m = new Monster();
	Battle bat = new Battle(b,m);
	
	System.out.println(bat);
	bat.charAttackMonster(b,m);
	bat.monsterAttackChar(m,b);
	
    }
}
