package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto{
	private Date dataFabricacao;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ProdutoUsado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoUsado(String nome, double preco) {
		super(nome, preco);
		// TODO Auto-generated constructor stub
	}

	public ProdutoUsado(String nome, double preco, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	@Override
	public String etiqueta() {
		return getNome() + " R$" + getPreco() + " (Data de fabricação: " + sdf.format(getDataFabricacao()) + ")";
	}
	
	
	
}
