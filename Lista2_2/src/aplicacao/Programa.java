package aplicacao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Contribuinte;
import entidades.Físico;
import entidades.Jurídico;

public class Programa {
	public static void main(String[] args) {
		//Definir formato do dinheiro
		DecimalFormat df = new DecimalFormat("#,###.00");
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> contribuintes = new ArrayList<>();
		
		System.out.println("Digite o número de contribuintes: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Tipo de contribuinte:");
			System.out.println("1-Pessoa física\n2-Pessoa jurídica");
			int tipo = sc.nextInt();
			
			if(tipo == 1){				

				
				System.out.println("Nome: ");
				String nome = sc.next();				
				System.out.println("Renda anual: R$");
				Double renda = sc.nextDouble();
				System.out.println("Despesas com saúde: R$");
				Double despesaSaude = sc.nextDouble();
				Contribuinte c = new Físico(nome, renda, despesaSaude);
				contribuintes.add(c);
			}
			
			else if(tipo == 2) {				
				System.out.println("Nome: ");
				String nome = sc.next();			
				System.out.println("Renda anual: R$");
				Double renda = sc.nextDouble();
				System.out.println("Número de funcionários: ");
				Integer numFunc = sc.nextInt();
				Contribuinte c = new Jurídico(nome, renda, numFunc);
				contribuintes.add(c);
			}
			
			else {
				System.out.println("Opção inválida. Tente novamente");
				i--;
			}
		}
		
		Double total = 0.0;
		
		System.out.println("---IMPOSTOS PAGOS---");
		for(Contribuinte c : contribuintes) {
			System.out.println(c.toString());
			total += c.imposto();
		}
		System.out.println("IMPOSTOS TOTAIS: R$" + df.format(total));
		
		sc.close();
	}

}
