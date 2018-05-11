public class Question{
	


	private String pergunta;
	private int resposta;
	private String[] alternativas = new String[4];
	private int level; // >>1 facil>>2 medio>>3dificil
	private boolean foiEscolhida= false;
	private int score;


	public String getPergunta(){
		return this.pergunta;
	}	
	
	public void setPergunta(String pergunta) {
		this.pergunta=pergunta;
	}
	public int getResposta(){
		return this.resposta;
	}
	
	public void setResposta(int resp){
		this.resposta=resp;
	}
	
	public String[] getAlternativas(){
		return alternativas;
	}
	public void setAlternativas(String one,String two,String three,String four) {
		this.alternativas[0]=one;
		this.alternativas[1]=two;
		this.alternativas[2]=three;
		this.alternativas[3]=four;
	}
	
	public int getLevel(){
		return this.level;
	}
	public void setLevel(int level) {
		this.level=level;
	}
	
	public void setFoiEscolhida(boolean x){
		this.foiEscolhida=x;
	}

	public boolean getFoiEscolhida(){
		return this.foiEscolhida;
	}

	public int getQuestionScore() {
		return this.score;
	}
	public void setQuestionScore(int score) {
		this.score=score;
	}
}
