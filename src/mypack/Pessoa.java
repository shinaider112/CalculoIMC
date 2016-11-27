package mypack;

public class Pessoa {
	private String sexo, nome , sobrenome;
	private double peso, altura;
	private int idade, id;
	private double imc;
	private String classificacao;

	public Pessoa(int id, String sexo, String nome, String sobrenome, int idade, double peso, double altura){
		this.id = id; 
		this.sexo = sexo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.peso = peso;
		this.altura = altura;
		calcularImc();
	}

	public double calcularImc(){
		this.imc = this.peso/((this.altura/100) * (this.altura/100));
		if(sexo.equals("feminino")){
			if(this.imc < 19.1){
				this.classificacao = "Abaixo do Peso";
			}else if(this.imc >= 19.1 && this.imc < 25.8){
				this.classificacao = "Peso Normal";
			}else if(this.imc >= 25.8 && this.imc < 27.3){
				this.classificacao = "Marginalmente Acima do Peso";
			}else if(this.imc >= 27.3 && this.imc < 32.2){
				this.classificacao = "Acima do Peso Ideal";
			}else if(this.imc >= 32.2 ){
				this.classificacao = "Obeso";
			}
		}else if(sexo.equals("masculino")){
			if(this.imc < 20.7){
				this.classificacao = "Abaixo do Peso";
			}else if(this.imc >= 20.7 && this.imc < 26.4){
				this.classificacao = "Peso Normal";
			}else if(this.imc >= 26.4 && this.imc < 27.8){
				this.classificacao = "Marginalmente Acima do Peso";
			}else if(this.imc >= 27.8 && this.imc < 31.1){
				this.classificacao = "Acima do Peso Ideal";
			}else if(this.imc >= 31.1 ){
				this.classificacao = "Obeso";
			}
		}
		return this.imc;
	}

	public int getId(){
		return this.id;
	}

	public String getSexo(){
		return this.sexo;
	}

	public String getNome(){
		return this.nome;
	}

	public String getSobrenome(){
		return this.sobrenome;
	}

	public double getPeso(){
		return this.peso;
	}

	public double getAltura(){
		return this.altura;
	}

	public int getIdade(){
		return this.idade;
	}

	public double getImc(){
		return this.imc;
	}
	
	public String getClassificacao(){
		return this.classificacao;
	}

}
