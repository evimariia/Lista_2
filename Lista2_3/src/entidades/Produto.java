package entidades;

public class Produto {
	private String nome;
	private Double valor;
	private Integer qtde;
	
	public Produto() {
		
	}

	public Produto(String nome, Double valor, Integer qtde) {
		this.nome = nome;
		this.valor = valor;
		this.qtde = qtde;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(String valor) {
		Double valorD = Double.parseDouble(valor);
		this.valor = valorD;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(String qtde) {
		Integer qtdeInt = Integer.parseInt(qtde);
		this.qtde = qtdeInt;
	}
	
	public Double total() {
		return valor * qtde;
	}

}
