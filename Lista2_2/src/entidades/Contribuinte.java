package entidades;

import java.text.DecimalFormat;

public abstract class Contribuinte {
	private String nome;
	private Double rendimentoAnual;
	
	DecimalFormat df = new DecimalFormat("#,###.00");
	
	public Contribuinte() {
		
	}

	public Contribuinte(String nome, Double rendimentoAnual) {
		this.nome = nome;
		this.rendimentoAnual = rendimentoAnual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getRendimentoAnual() {
		return rendimentoAnual;
	}

	public void setRendimentoAnual(Double rendimentoAnual) {
		this.rendimentoAnual = rendimentoAnual;
	}
	
	public abstract Double imposto();
	
	@Override
	public String toString() {
		return getNome() + ": R$" + df.format(imposto());
	}

}
