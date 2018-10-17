package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcela;
import model.services.ContratoService;
import model.services.PayPalService;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Informe os dados do contrato");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor do contrato: ");
		double valorTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valorTotal);
		
		System.out.print("Informe o número de parcelas: ");
		int n = sc.nextInt();
		
		ContratoService contratoService = new ContratoService(new PayPalService());
		
		contratoService.processaContrato(contrato, n);
		
		System.out.println("\nParcelas:");
		for (Parcela x : contrato.getParcelas()) {
			System.out.println(x);
		}
		
		sc.close();
		

	}

}
