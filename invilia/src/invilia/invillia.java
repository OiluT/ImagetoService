package invilia;
import java.util.Scanner;

public class invillia {
	
	 public static void main(String[] args) {
	      
	        
	        Scanner ler = new Scanner(System.in); // 2. instanciando e criando um objeto Scanner
	        int pistaMetros, totalVoltas, reabastecimentos, carroTanqueL = 30, litrosMl = 1000;
	        double consumoCarro;

	        System.out.printf("Informe o tamanho da pista em metros: ");
	        pistaMetros = ler.nextInt(); // 3. entrada de dados (lendo um valor inteiro)

	        System.out.printf("Informe o total de Voltas do Grande Prêmio.: ");
	        totalVoltas = ler.nextInt(); // 3. entrada de dados (lendo um valor inteiro)
	        
	        System.out.printf("Informe a quantidade de Reabastecimentos esperado: ");
	        reabastecimentos = ler.nextInt(); // 3. entrada de dados (lendo um valor inteiro)
	        
	        System.out.printf("Informe o consumo do Carro por KM rodado: ");
	        consumoCarro = ler.nextDouble(); // 3. entrada de dados (lendo um valor inteiro)
	        
	       
	        int totalVoltasKM = (pistaMetros*totalVoltas);
	        int reaDesejado = (totalVoltasKM/reabastecimentos);
	        double kmLitro = ( litrosMl/consumoCarro);
	        double LitrosNecessários = (reaDesejado*kmLitro);
	        
	        
	        
	       System.out.print("Litros necessários minimos para o próximo abastecimento é de: "+LitrosNecessários);
	        
	        

	  
	    }
	}

