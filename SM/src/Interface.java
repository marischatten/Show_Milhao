import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Interface {

public void output(int action) {
		
		switch (action) {
			case 1 :
				System.out.println("PARABENS! RESPOSTA CORRETA\n\n\n\n");
				break;
			case 2 :
				System.out.println("RESPOSTA ERRADA!");
			break;
			case 3:
				System.out.println("VOC� PULOU ESTA QUEST�O!");
			break;
			case 4:
				System.out.println("VOC� DESISTIU DO JOGO");
			break;
			case 5:
				System.out.println("VOC� N�O PODE MAIS USAR ESTE RECURSO!");
			break;
			case 6:
				System.out.println("**************************************************");
				System.out.println("**\t\tVOC� VENCEU O JOGO!!\t\t**");
				System.out.println("**************************************************");
			break;
			case 7: 
				System.out.println("**********************************************************");
				System.out.println("**\t\tFIM DE JOGO!VOC� PERDEU!\t\t**");
				System.out.println("**********************************************************");
			break;
			case 8:
				System.out.println("\t\t**************************************************");
				System.out.println("\t\t**\t\t[1]Responder\t\t        **");  //1
				System.out.println("\t\t**\t\t[2]Pular quest�o\t\t**"); //2
				System.out.println("\t\t**\t\t[3]Eliminar\t\t        **");  //3
				System.out.println("\t\t**\t\t[4]Desisir do Jogo\t\t**"); //4
				System.out.println("\t\t**************************************************");	
			break;

			default:
				System.out.println("SUA PONTUA��O FOI: "+action);
		}
	}

	public void questionOutput(Question q, int delete) {
		
		System.out.println(q.getPergunta());
		if(delete==10) {
			for (int i=0;i<4;i++) {
				System.out.println(q.getAlternativas()[i]);
			}
		}else {
				for(int j=0;j<4;j++) {
					if(j != delete ) {
						System.out.println(q.getAlternativas()[j]);
					}
				}
				
		}
		
	}
	
	
	public int input(int action) {
		
		Scanner input = new Scanner(System.in);
		int read=0;
				
		if(action==1) {
			do {
				System.out.println("Qual alternativa est� correta?");	
			 	read=input.nextInt();
				}while(read > 4 || read < 1 );
		}else {
				do {
					System.out.println("Escolha>>_ ");
					read=input.nextInt();
				}while(read > 4 || read < 1 );
				
		}
			
	 	return read;
	}
	

	
	public Question[] inputFile() {
		
		Question q[] = new Question[25];

		int count=0;
		File file = new File("database.txt");
		String linealt1;
		String linealt2;
		String linealt3;
		String linealt4;

		
		try {
			FileReader read = new FileReader(file);
			BufferedReader readb = new BufferedReader(read);
			String line = readb.readLine();
			
			while(line !=null) {
					
				q[count] = new Question();
				q[count].setPergunta(line);
				line = readb.readLine();			
				q[count].setResposta(Integer.parseInt(line)); 
				linealt1 = readb.readLine();
				linealt2 = readb.readLine();
				linealt3 = readb.readLine();
				linealt4 = readb.readLine();
				q[count].setAlternativas(linealt1,linealt2,linealt3,linealt4);
				line = readb.readLine();
				q[count].setLevel(Integer.parseInt(line));  
				line = readb.readLine();
				q[count].setQuestionScore(Integer.parseInt(line));  
				line = readb.readLine();
				q[count].setFoiEscolhida(false);
				count++;		
			}
		}catch (IOException ex) {	
			ex.printStackTrace();
		}
		return q;
	}
	
}
