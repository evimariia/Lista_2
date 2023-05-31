package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Programa {

	public static void main(String[] args) throws ParseException {
		List<Produto> listaProdutos = new ArrayList<Produto>();
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Digite o número de interações: ");
		int n = sc.nextInt();
		
		int i = 0;
		while(i < n) {
			System.out.println("Comum, usado ou importado? (c/u/i)");
			String op = sc.next();
			
			switch (op){
				case "c":
					System.out.println("Nome: ");
					String nome = sc.next();
					System.out.println("Preço: ");
					Double preco = sc.nextDouble();

					Produto produto = new Produto(nome, preco);
					listaProdutos.add(produto);
					
					break;
					
				case "u":
					System.out.println("Nome: ");
					String nomeUsado = sc.next();
					System.out.println("Preço: ");
					Double precoUsado = sc.nextDouble();
					System.out.println("Data de fabricação (DD/MM/AAAA): ");
					Date dataFabricacao = sdf.parse(sc.next());

					ProdutoUsado produtoUsado = new ProdutoUsado(nomeUsado, precoUsado, dataFabricacao);
					listaProdutos.add(produtoUsado);
					
					break;
					
				case "i":
					System.out.println("Nome: ");
					String nomeImportado = sc.next();
					System.out.println("Preço: ");
					Double precoImportado = sc.nextDouble();
					System.out.println("Taxa alfandegária: ");
					Double taxa = sc.nextDouble();

					ProdutoImportado produtoImportado = new ProdutoImportado(nomeImportado, precoImportado, taxa);
					listaProdutos.add(produtoImportado);
					
					break; 
					
				default:
					System.out.println("Opção inválida");
					break;
			}
			
			i++;
				
		}
		
		System.out.println("-----ETIQUETAS DE PREÇO-----");
		for(Produto prod : listaProdutos) {
			System.out.println(prod.etiqueta());
		}		
		
		sc.close();
	}

}
