import java.util.Random;

public  class  QuestionBase{

	public  Question[] constructQuestions(){

		Question q[] = new Question[25];
		Interface interFace = new Interface();
		
		q=interFace.inputFile();
		return q;
	}

	public Question getEasyQuestion(Question[] questionBase){
		
		Random rand = new Random();
		int id;
		
		do{
			 id=rand.nextInt(23);
		}while (questionBase[id].getLevel() != 1 || questionBase[id].getFoiEscolhida()==true);
		questionBase[id].setFoiEscolhida(true);
		return questionBase[id];
		
	}

	public Question getMediumQuestion(Question[] questionBase){
		
		Random rand = new Random();
		int id;
		
		do{
			 id=rand.nextInt(23);
		}while (questionBase[id].getLevel() != 2 || questionBase[id].getFoiEscolhida()==true);
		questionBase[id].setFoiEscolhida(true);
		return questionBase[id];

	}

	public Question getHardQuestion(Question[] questionBase){
		
		Random rand = new Random();
		int id;
		
		do{
			id=rand.nextInt(23);
		}while (questionBase[id].getLevel() != 3  || questionBase[id].getFoiEscolhida()==true );
		questionBase[id].setFoiEscolhida(true);
		return questionBase[id];
		
	}
}



