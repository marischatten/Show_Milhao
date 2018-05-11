public class Player{


	public  int  decision(Game play){
		
		Interface interFace = new Interface();
		int inp;
		
		interFace.output(8);
		inp=interFace.input(2);
			
		while((inp==2 && play.getSkip()>3) || (inp==3 && play.getDelete()==1)) {
			 	interFace.output(5);
				inp = interFace.input(2);
		}
		return inp;
	}





}
