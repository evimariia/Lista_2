//Fazer um programa para ler o caminho de um arquivo .csv contendo os dados de itens
//vendidos. Cada item possui um nome, preço unitário e quantidade, separados por
//vírgula. Você deve gerar um novo arquivo chamado "resumo.csv", localizado em uma
//subpasta chamada "resposta" a partir da pasta original do arquivo de origem, contendo
//apenas o nome e o valor total para aquele item (preço unitário multiplicado pela
//quantidade), conforme exemplo.

package aplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import entidades.Produto;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String[]> resumo = new ArrayList<String[]>();
		
		
		//Informa o caminho do arquivo
		System.out.println("Informe o caminho de um arquivo: ");
		String caminhoArq = sc.nextLine();
		File caminho = new File(caminhoArq);
		
		//Lê o arquivo
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			
			String linha = br.readLine(); //Lê a próxima linha
			
			List<String> lista = new ArrayList<String>(); //Lista dos produtos
			String[] prod = null; //Array auxiliar

			while (linha != null) {				
				if(linha != null) {
					prod  = linha.split(","); //Cria um array de cada produto com suas informações
					lista.add(Arrays.toString(prod)); //Adiciona o array na lista
				}
				linha = br.readLine(); //Lê a próxima linha
			}
			
			
			//Criar um produto para salvar as informações
			Produto produto = new Produto(); 
			
			for(String x : lista) {
				String[] arrayDesejado = x.replaceAll("\\[|\\]", "").split(",");
				
				//Remove espaço em branco entre os elementos do array
				for (int i = 0; i < arrayDesejado.length; i++) {
				    arrayDesejado[i] = arrayDesejado[i].trim();
				}
				
				//Configurar atributos do produto
				String nome = arrayDesejado[0];
				String valor = arrayDesejado[1];
				String qtde = arrayDesejado[2];
				
				produto.setNome(nome); 
				produto.setValor(valor);
				produto.setQtde(qtde);
				String total = produto.total().toString();
				
				String[] resumoProd = {nome, total};
				resumo.add(resumoProd);
				
			}
			
			//Pasta destino
			System.out.println("Informe o caminho da nova pasta: ");
			String caminhoPasta = sc.nextLine();
			File caminhoP = new File(caminhoPasta + "\\resultado");
		
			//Se a pasta não existir no caminho indicado, cria nova pasta
			if(!caminhoP.exists()) {
				System.out.println("Pasta criada com sucesso: " + caminhoP.mkdir());
			}
			
			//Escreve o resumo em novo arquivo
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoP + "\\resumo.csv"))) {
				for (String[] linha1 : resumo) {
					String linhaFormatada = Arrays.toString(linha1)
											.replaceAll("\\[|\\]", ""); //Escreve linhas do arquivo, 
																		//substituindo colchetes por espaços vazios
					
					bw.write(linhaFormatada);
					bw.newLine();
				}
				
				//Lê arquivo criado
				//
				//
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
			//C:\Temp_TP2\produto.csv
		}	
		
		sc.close();

	}

}
