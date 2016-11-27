/**

* Unicesumar ? Centro Universitário Cesumar

* Curso: Análise e Desenvolvimento de Sistemas

* Autor(es): Wendell Neander Santos Silva

* Data: 27/11/2016

* Repositório: https://github.com/shinaider112/CalculoIMC.git

* Descrição: Classe para leitura de dados e instaciamento de objetos Pessoa.

*/

package mypack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IntDados {

	private ArrayList<Pessoa> pessoas = new ArrayList<>();
	
	public ArrayList<Pessoa> getDados() throws IOException{

		InputStream is = new FileInputStream("C:\\Users\\Pai\\Desktop\\AEPPessoas\\lista.csv");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String linha = br.readLine();
		int index = 0;
		
		while (index < 100) {
			
			linha = br.readLine();
			
			String[] dadosPessoa = linha.split(";");
		
			Pessoa pessoa = new Pessoa(Integer.parseInt(dadosPessoa[0].trim()), dadosPessoa[1].trim().toLowerCase(), dadosPessoa[2].trim(), dadosPessoa[3].trim(), 
				Integer.parseInt(dadosPessoa[4]), Double.parseDouble(dadosPessoa[5]), Double.parseDouble(dadosPessoa[6]));
			this.pessoas.add(pessoa);
	
			index++;
		}
		br.close();
		
		System.out.println("\n\nDados lidos com sucesso!\n\n");

		return this.pessoas;

	}
}