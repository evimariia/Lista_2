package entidades;

public class Físico extends Contribuinte{
	private Double despesaSaude;

	public Físico() {
		super();
	}

	public Físico(String nome, Double rendimentoAnual, Double despesaSaude) {
		super(nome, rendimentoAnual);
		this.despesaSaude = despesaSaude;
	}
	
	public Físico(Double despesaSaude) {
		super();
		this.despesaSaude = despesaSaude;
	}

	public Double getDespesaSaude() {
		return despesaSaude;
	}

	public void setDespesaSaude(Double despesaSaude) {
		this.despesaSaude = despesaSaude;
	}

	public Double imposto() {
				
		if(getRendimentoAnual() < 20000.00) {
			return (getRendimentoAnual() * 0.15) - (despesaSaude * 0.5);
		}
		
		else if (getRendimentoAnual() >= 20000.00) {
			return (getRendimentoAnual() * 0.25) - (despesaSaude * 0.5);
		}
		
		else {
			return 0.0;
		}
		
	}

}
