/**

* Unicesumar ? Centro Universitário Cesumar

* Curso: Análise e Desenvolvimento de Sistemas

* Autor(es): Wendell Neander Santos Silva

* Data: 27/11/2016

* Repositório: https://github.com/shinaider112/CalculoIMC.git

* Descrição: Classe controle, realiza os calculos que o usuario pede na interface.

*/

package mypack;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Controlador {
	private Scanner s = new Scanner(System.in);
	private String op;
	private boolean opcaoValida;
	private IntDados lerDados;
	private ArrayList<Pessoa> pessoas = new ArrayList<>();
	
	public void lerDados() throws IOException {
		
		lerDados = new IntDados();
		pessoas = lerDados.getDados();
	}
	
	public void dadosIndividuais() throws IOException{
		if(lerDados != null){
			int id = 1;
			System.out.println("Digite o id da pessoa: ");
			String sid = s.nextLine();
			if(isInteger(sid)){
				id = Integer.parseInt(sid);
			}else{
				System.out.println("ID Invalido\n");
			}
			
			for (Pessoa pessoa : pessoas) {
				if(pessoa.getId() == id){
					System.out.println("IMC = " + pessoa.getImc());
					System.out.println("Nome = " + pessoa.getNome() + " " + pessoa.getSobrenome());
					System.out.println("Sexo = " + pessoa.getSexo());
					System.out.println("Idade = " + pessoa.getIdade());
					System.out.println("Peso = " + pessoa.getPeso());
					System.out.println("Altura = " + (pessoa.getAltura()/100) + "\n\n");
				}
			}
		}else{
			System.out.println("Voce precisa ler os dados antes.\n\n");
		}
		
	}
	
	public void calcularMedias() throws IOException{
		if(lerDados != null){
			int totalHomens = 0;
			int totalIdadeMasc = 0;
			int totalImcHomens = 0;
			
			int totalMulheres = 0;
			int totalIdadeFem = 0;
			int totalImcMulheres = 0;
			
			for (Pessoa pessoa : pessoas) {
				if(pessoa.getSexo().equals("masculino")){
					totalHomens++;
					totalIdadeMasc += pessoa.getIdade();
					totalImcHomens += pessoa.getImc();
				}else{
					totalMulheres++;
					totalIdadeFem += pessoa.getIdade();
					totalImcMulheres += pessoa.getImc();
				}
				
			}
			System.out.println("\n\nA media de idade para homens e: " + totalIdadeMasc/totalHomens + " anos");
			System.out.println("A media de IMC para homens e: " + totalImcHomens/totalHomens);
			System.out.println("A media de idade para mulheres e: " + totalIdadeFem/totalMulheres + " anos");
			System.out.println("A media de IMC para mulheres e: " + totalImcMulheres/totalMulheres);
			System.out.println("Total de homens: " + totalHomens);
			System.out.println("Total de mulheres: " + totalHomens + "\n\n");
		}else{
			System.out.println("Voce precisa ler os dados antes.");
			//opcaoValida = false;
		}
		
	}
	
	public void imprimirRelatorio() throws IOException{
		int totalAbaixoPeso = 0;
		int totalPesoNormal = 0;
		int totalMargAcimaPeso = 0;
		int totalAcimaPeso= 0;
		int totalObeso = 0;
		
		if(lerDados != null){
			for (Pessoa pessoa : pessoas) {
				System.out.println("Nome: " + pessoa.getNome() + " " + pessoa.getSobrenome());
				System.out.println("Idade: " + pessoa.getIdade());
				System.out.println("Sexo: " + pessoa.getSexo());
				System.out.println("Peso: " + pessoa.getPeso());
				System.out.println("Altura: " + (pessoa.getAltura()/100));
				System.out.println("IMC: " + pessoa.getImc());
				System.out.println("Classificacao: " + pessoa.getClassificacao() + "\n\n");
				if(pessoa.getClassificacao().equals("Abaixo do Peso")){
					totalAbaixoPeso++;
				}	
				else if(pessoa.getClassificacao().equals("Peso Normal")){
					totalPesoNormal++;
				}
				else if(pessoa.getClassificacao().equals("Marginalmente Acima do Peso")){
					totalMargAcimaPeso++;
				}
				else if(pessoa.getClassificacao().equals("Acima do Peso Ideal")){
					totalPesoNormal++;
				}
				else if(pessoa.getClassificacao().equals("Obeso")){
					totalPesoNormal++;
				}
			}
			System.out.println("Total de pessoas Abaixo do Peso: " + totalAbaixoPeso);
			System.out.println("Total de pessoas com Peso Normal: " + totalPesoNormal);
			System.out.println("Total de pessoas Marginalmente Acima do Peso: " + totalMargAcimaPeso);
			System.out.println("Total de pessoas Acima do Peso Ideal: " + totalAcimaPeso);
			System.out.println("Total de pessoas Obeso: " + totalObeso);
			calcularMedias();
		}else{
			System.out.println("Voce precisa ler os dados antes.\n\n");
		}
	}

	public boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s);
	        if(Integer.parseInt(s) == 0){
	        	return false;
	        }
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}


}
