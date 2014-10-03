public class Driver{
	public static void main(String[] args){
		//Clarifying my variable names: .obj and .mtl are file extensions for Wavefront 3D Modelling files
		MakeFrame OBJ = new MakeFrame();
		System.out.println(OBJ.frame(8, 10));
		CodingBat MTL = new CodingBat();
		System.out.println(MTL.stringSplosion("Explode!"));
		System.out.println(MTL.stringX("xxx"));
		System.out.println(MTL.stringX("xFALCONLORDx"));
		System.out.println(MTL.stringX("xJOINxMYxSNIPERxCLANx"));
	}
}
