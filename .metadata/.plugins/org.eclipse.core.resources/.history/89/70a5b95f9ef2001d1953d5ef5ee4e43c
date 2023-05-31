package servicos;

import java.time.LocalDate;

import entidades.Contrato;
import entidades.Parcela;

public class ServicoContrato {
	
	private ServicoPgtoOnline servicoPgtoOnline;

	public ServicoContrato(ServicoPgtoOnline servicoPgtoOnline) {
		this.servicoPgtoOnline = servicoPgtoOnline;
	}
	
	public void processarContrato(Contrato contrato, Integer meses) {
		
		Double parcela = contrato.getValorTotal()/meses;
		
		for(int i = 1; i <= meses; i++) {
			Double juros = servicoPgtoOnline.juros(parcela, i);
			Double taxa = servicoPgtoOnline.taxaPgto(parcela + juros);
			Double pgto = parcela + juros + taxa;
			
			LocalDate vencimento = contrato.getData().plusMonths(i);
			
			contrato.getParcelas().add(new Parcela(vencimento, pgto));
		}
	}

}
