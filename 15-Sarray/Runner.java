public class Runner{
    public static void main(String[] args){
	Sarray m = new Sarray();
	for (int i=1;i<10;i++){
	    m.add(i);}
	try {
	    
	    m.add(11);
	    System.out.println(m);
	    System.out.println("Added successfully");
	} catch (Exception e){
	    System.out.println("Error: " + e);
	}
	    
	m.set(33,2);
	System.out.println(m);
	try {
	    m.add(-1,22);
	    System.out.println("Added successfully");
	    System.out.println(m);
	}catch (Exception e){
	    System.out.println("Error: " + e);
	}
	m.remove(5);
	System.out.println(m);
	System.out.println(m.size());
	System.out.println(m.get(2));
    }
}