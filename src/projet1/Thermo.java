package projet1;

import java.util.Scanner;

public class Thermo {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		char reponse = 'O';
		int mode = ' ';
		int temperature = ' ';
		int resultat = ' ';
		
		System.out.println("CONVERTISSEUR DEGRES CELSIUS ET DEGRES FAHRENHEIT");
		System.out.println("-------------------------------------------------");
		
		do {
			do {
		System.out.println("Choisissez le mode de conversion :");
		System.out.println("1 - Convertisseur Celsius - Fahrenheit");
		System.out.println("2 - Convertisseur Fahrenheit - Celsius");
		mode = sc.nextInt();
			}while(mode != 1 && mode != 2);
		System.out.println("Température à convertir :");
		sc.nextLine();
		temperature = sc.nextInt();
		
		if(mode == 1) {
			resultat = ((9/5*temperature)+32);
			System.out.println(temperature + " °C correspond à : " + resultat + " °F.");
		}
		else if(mode == 2) {
			resultat = ((temperature-32)*5/9);
			System.out.println(temperature + " °F correspond à : " + resultat + " °C.");
		}
			do{
		    System.out.println("Souhaitez-vous convertir une autre température ? (O/N)");
		    sc.nextLine();
		    reponse = sc.nextLine().charAt(0);
		  }while(reponse != 'O' && reponse != 'N');
		
		}while (reponse == 'O');
		
		System.out.println("Au revoir !");

	}

}
