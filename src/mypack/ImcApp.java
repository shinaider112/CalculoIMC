/**

* Unicesumar ? Centro Universit�rio Cesumar

* Curso: An�lise e Desenvolvimento de Sistemas

* Autor(es): Wendell Neander Santos Silva

* Data: 27/11/2016

* Reposit�rio: https://github.com/shinaider112/CalculoIMC.git

* Descri��o: Classe de interface, mostra as op��es do usu�rio, e inicializa o Controlador.

*/

package mypack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImcApp {
	static Scanner s = new Scanner(System.in);
	static String op;
	static boolean opcaoValida;
	static IntDados lerDados;
	static Controlador controle;
	
	public static void criaMenu() throws IOException{

		do{
			System.out.println("1 - Ler Dados");
			System.out.println("2 - Calcular Medias");
			System.out.println("3 - Imprimir Relatorio");
			System.out.println("4 - Dados Individuais");
			System.out.println("9 - Sair");
			
			op = s.nextLine();
			if(op.equals("1") || op.equals("2") || op.equals("3") || op.equals("4") || op.equals("9")){
				opcaoValida = true;
			}else{
				System.out.println("Opcao Invalida\n");
				opcaoValida = false;
			}
			

		}while(!opcaoValida);
		
		if(Integer.parseInt(op) == 1){
			controle.lerDados();
			criaMenu();
		}else if(Integer.parseInt(op) == 2){
			controle.calcularMedias();
			criaMenu();
		}else if(Integer.parseInt(op) == 3){
			controle.imprimirRelatorio();
			criaMenu();
		}else if(Integer.parseInt(op) == 4){
			controle.dadosIndividuais();
			criaMenu();
		}else if(Integer.parseInt(op) == 9){
			System.exit(0);
		}
		
	}	

	public static void main(String[] args) throws IOException {
		controle =  new Controlador();
		criaMenu();

	}

}
