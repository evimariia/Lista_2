package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {
	private LocalDate data;
	private Double valor;
	
	public Parcela() {
		
	}

	public Parcela(LocalDate data, Double valor) {
		this.data = data;
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Override
	public String toString() {
		return "\n----------------------------\n" +
			   "VALOR    | Data de pagamento\n" +  
			   "R$" + String.format("%.2f", valor) + " | " + data.format(fmt);
	}

}
