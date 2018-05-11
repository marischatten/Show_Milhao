import java.util.Random;
public class Game{

	private int roundNumber=0;
	private int score=0; 
	private int skip=0;
	private int delete=0;
	private int exit=0;

	public void setScore(Question q){
		int questionScore = q.getQuestionScore();
		this.score = this.score+questionScore;
	}

	public int getScore(){
		return this.score;
	}

	public int getRoundNumber(){
		return this.roundNumber;
	}

	public void setRoundNumber(int r){
		if(r!= 10){
			this.roundNumber++;
		}else{
			this.roundNumber= 10;
		}
	}

	public int getSkip(){
		return this.skip;
	}

	public void setSkip(){
			this.skip++;
		}
	
	public int getDelete() {
		return this.delete;
	}
	
	public void setDelete() {
		this.delete=1;
	}
	
	public int getExit() {
		return this.exit;
	}
	
	public void setExit(int type) {
		this.exit=type;
	}
	
	public void roundControl(QuestionBase questionBase, Player player){
		
		Interface interFace = new Interface();
		Question[] arrayQuestion= new Question[24];
		arrayQuestion= questionBase.constructQuestions();
			
		do{
			this.setRoundNumber(0);
			//System.out.println("RODADA "+this.getRoundNumber());
			this.round(arrayQuestion,player,questionBase);
			}while (this.getRoundNumber() >=1 && this.getRoundNumber() <8 );  
			
		if(this.getExit()==1) {
			interFace.output((this.getScore())/2);
		}else {
			if(this.getExit()==2) {
				interFace.output(0);
			}else {
				interFace.output(this.getScore());
			}
		}

		if(this.getRoundNumber()==8){
			interFace.output(6);
		}else{
			interFace.output(7);
		}

	}

	public void round(Question[] arrayQuestion , Player player, QuestionBase qb){

		Question q = new Question();
		
		q = (this.viewQuestion(this.selectQuestion(this.getRoundNumber(), arrayQuestion,qb )));
		int decision =player.decision(this);
		
		if (decision==1) {
			//responder
			this.answerQuestion(q,player);
		}else{
			if(decision==2){
				//pular
				this.skipQuestion(arrayQuestion,player,qb);
			}else{
				if(decision==3){
					//eliminar
					this.deleteQuestion(q,player);
				}else{
					//desistir
					this.exitGame();
				}
			}
		}
	}	


	public Question viewQuestion( Question q){
		
		Interface interFace = new Interface();
		
		interFace.questionOutput(q,10);

		return q;
	}

	public Question selectQuestion(int round,Question[] arrayQuestion,QuestionBase qb){ //tem que passar o arrayQuestion

		Question q= new Question(); 
		
			if(round <=4){
				q=qb.getEasyQuestion(arrayQuestion);
			}else{
				if(round>=5 && round<=7){
					q=qb.getMediumQuestion(arrayQuestion);
				}else{
					if(round==8) {
						q=qb.getHardQuestion(arrayQuestion);	
					}
				}
			}
		return q;	
	}


	public boolean checkAnswer(Question q,int resposta){

			if(q.getResposta() == resposta){
			return true;
		}else{
			return false;
		}
	}


	public void answerQuestion(Question q,Player player){
		
		Interface interFace = new Interface();
		int resposta = interFace.input(1);
		
			if((this.checkAnswer(q,resposta))==true){
				interFace.output(1);
				this.setScore(q);
			}else{
				interFace.output(2);
				this.setRoundNumber(10);
				this.setExit(2);
			}
	}
	
	public void skipQuestion(Question[] arrayQuestion, Player player, QuestionBase qb ){
		
			Interface interFace = new Interface();
		
			interFace.output(3);
			this.setSkip();
			this.round(arrayQuestion,player,qb);		
	}

	public void deleteQuestion(Question q,Player player){
		
		Interface interFace = new Interface();
		int delete;
		Random rand = new Random();
		
		do{
			delete = (rand.nextInt(3));
		}while(delete== q.getResposta());
		
		this.setDelete();
		interFace.questionOutput(q,delete);
		this.answerQuestion(q, player);
	}
	
	public void exitGame(){
		
		Interface interFace = new Interface();
		interFace.output(4);
		this.setRoundNumber(10);
		this.setExit(1);		
	}

}
