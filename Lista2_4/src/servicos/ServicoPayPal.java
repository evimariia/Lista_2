package servicos;

public class ServicoPayPal implements ServicoPgtoOnline {
	
	public Double taxaPgto(Double montante) {
		return montante * 0.02;
	}
	
	public Double juros(Double quantia, Integer mes) {
		return quantia * 0.01 * mes;
	}

}
