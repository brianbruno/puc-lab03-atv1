package parte2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Arquivo {
	private static int cont = 0;
	private static int contl = 0;
	public void gravar(Pedido pedido) {

		try {
			File arquivo = new File("dados.txt");
			FileWriter fileWriter = new FileWriter(arquivo, true);
			BufferedWriter escrever = new BufferedWriter(fileWriter);
			cont=lerTotal();
			if(cont==0) {
				escrever.write(String.valueOf(cont));
				escrever.newLine();
			}
			escrever.write(pedido.getNome()+"; ");
			escrever.write(String.valueOf(pedido.getPeso())+"; ");
			escrever.write(String.valueOf(pedido.getPreco()));
			escrever.newLine();
			escrever.close();
			fileWriter.close();
			cont++;
			regravar();
			System.out.println("Registro gravado com sucesso");
		}catch(NullPointerException ex){
			System.out.println("N�o foi poss�vel gravar o registro");
		}catch (IOException ex) {
			System.out.println("Arquivo n�o existe");
		}
	}
	private void regravar() {
		try {
			File arquivo = new File("dados.txt");
			File temp = new File("temp.txt");
			FileReader ler = new FileReader(arquivo);
			BufferedReader lerb = new BufferedReader(ler);
			FileWriter fileWriter = new FileWriter(temp, true);
			BufferedWriter escrever = new BufferedWriter(fileWriter);
			lerb.readLine();
			String linha = lerb.readLine();
			escrever.write(String.valueOf(cont));
			escrever.newLine();

			while (linha != null) {
				escrever.write(linha);
				escrever.newLine();
				linha = lerb.readLine();
			}
			lerb.close();
			ler.close();
			escrever.close();
			fileWriter.close();
			arquivo.delete();
			transferir();
		} catch (IOException e) {
			System.out.println("Arquivo n�o existe");
		}
	}
	private void transferir() {
		try {
			File arquivo = new File("dados.txt");
			File temp = new File("temp.txt");
			FileReader ler = new FileReader(temp);
			BufferedReader lerb = new BufferedReader(ler);
			FileWriter fileWriter = new FileWriter(arquivo, true);
			BufferedWriter escrever = new BufferedWriter(fileWriter);
			String linha = lerb.readLine();

			while (linha != null) {
				escrever.write(linha);
				escrever.newLine();
				linha = lerb.readLine();
			}
			lerb.close();
			ler.close();
			escrever.close();
			fileWriter.close();
			temp.delete();
		} catch (IOException e) {
			System.out.println("Arquivo n�o existe");
		}
	}

	public int lerTotal() {
		String linha;
		int total=0;
		try {
			File arquivo = new File("dados.txt");
			FileReader ler = new FileReader(arquivo);
			BufferedReader lerb = new BufferedReader(ler);
			linha=lerb.readLine();
			if(linha==null) {
				total=0;
			}else {
				total=Integer.parseInt(linha);
			}
			lerb.close();
			ler.close();
		} catch (IOException e) {
			System.out.println("Arquivo n�o existe");
		}
		return total;
	}


	public List<Pedido> lerArquivo(int data) {
		String linha = null;
		List<Pedido> pedidos = null;
		try {
			File arquivo = new File("dados/dados" + (10 + data) + ".txt");
			FileReader ler = new FileReader(arquivo);
			BufferedReader lerb = new BufferedReader(ler);

			pedidos = new ArrayList<>();

			while ((linha = lerb.readLine()) != null) {
				String[] pedido = linha.split(";");
				pedido[2] = pedido[2].substring(3).replace(",", ".");
				Pedido px = new Pedido(pedido[0], Double.parseDouble(pedido[1]), 0, Double.parseDouble(pedido[2]));

				pedidos.add(px);
			}

			lerb.close();
			ler.close();
		} catch (IOException e) {
			System.out.println("Arquivo n�o existe");
		}
		return pedidos;
	}

}

