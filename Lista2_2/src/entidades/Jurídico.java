package entidades;

public class Jurídico extends Contribuinte{
	private Integer numeroEmpregados;

	
	
	public Jurídico() {
		super();
	}



	public Jurídico(String nome, Double rendimentoAnual, Integer numeroEmpregados) {
		super(nome, rendimentoAnual);
		this.numeroEmpregados = numeroEmpregados;
	}



	public Jurídico(Integer numeroEmpregados) {
		super();
		this.numeroEmpregados = numeroEmpregados;
	}



	public Integer getNumeroEmpregados() {
		return numeroEmpregados;
	}



	public void setNumeroEmpregados(Integer numeroEmpregados) {
		this.numeroEmpregados = numeroEmpregados;
	}
	
	public Double imposto() {
				
		if(numeroEmpregados > 10) {
			return (getRendimentoAnual() * 0.14);
		}
		
		else {
			return (getRendimentoAnual() * 0.16);
		}
		
	}

}
