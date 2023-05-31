package servicos;

public interface ServicoPgtoOnline {
	public Double taxaPgto(Double montante);
	public Double juros(Double quantia, Integer mes);
}
