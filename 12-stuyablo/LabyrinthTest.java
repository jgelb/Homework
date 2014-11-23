public class LabyrinthTest{
    public static void main (String[] args){
	Labyrinth lab = new Labyrinth();
	
	lab.quest();
	System.out.println( lab.getStage() );
	lab.setStage(100);
	System.out.println( lab.getStage() );



    }
}
