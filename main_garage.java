package garage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*Si realizzi una applicazione java per la gestione di un garage secondo le specifiche:
il garage ha al max 15 posti ognuno dei quali è identificato da un num a partire da 0 e per motivi di capienza può ospitare solo auto moto e furgoni partendo dalla classe base veicolo a motore V; la si estenda, realizzando anche le classi che modellano le entità furgone (F) auto (A) e moto (M).
Ridefinire il metodo toString in modo che ogni entità possa esternalizzare in forma di stringa tutte le informazioni che la riguardano.
Si implementi una classe che modelli il garage sopradescritto offrendo le seguenti operazioni di gestione
1] immissione di un nuovo veicolo
2] estrazione dal garage del veicolo che occupa un determinato posto (ritornare l'istanza del veicolo stesso)
3] stampa della situazione corrente dei posti nel garage veicolo:
marca,anno,cilindrata;
auto:porte, alimentazione (diesel/benzina)
moto:tempi
furgone:capacità*/
public class main_garage {
	
	public static void menu() {
		final String ANSI_WHITE="\u001b[37m";
		//final String ANSI_GREEN="\u001b[32m";
		final String ANSI_CYAN="\u001b[36m";
		final String ANSI_RED="\u001b[31m";
		final String ANSI_YELLOW="\u001b[33m";
		System.out.println(ANSI_CYAN+"\n1]Immissione nuovo veicolo");
		System.out.println(ANSI_RED+"\n2]Estrazione dal garage del veicolo che occupa che occupa un determinato posto (ritorna l'istanza del Veicolo)");
		System.out.println(ANSI_YELLOW+"\n3]Stampa i posti nel garage");
		System.out.println(ANSI_WHITE+"\n4]Menu");
		System.out.println("\n0]Esci");
	}
	public static void main(String[] args) {
		final String ANSI_WHITE="\u001b[37m";
		final String ANSI_GREEN="\u001b[32m";
		final String ANSI_CYAN="\u001b[36m";
		final String ANSI_RED="\u001b[31m";
		final String ANSI_YELLOW="\u001b[33m";

		//ArrayList<Veicolo> garage = new ArrayList<>(15);
		HashMap<Integer,Veicolo> garage = new HashMap<>(15);

		System.out.println("GARAGE\nMassima capienza: 15.\n");
		menu();
		int scelta=0;
		
		int posto = 1;

		do {
			System.out.println(ANSI_WHITE+"\n--> ");
			Scanner scanner1 = new Scanner(System.in);
			scelta=scanner1.nextInt();
			switch(scelta) {
			case 1:
				System.out.println(ANSI_CYAN+"\nImmetti nuovo Veicolo:\n"
						+ "1) Auto\t2) Furgone\t3) Moto\t0) Torna al menu\n");
				Scanner scanner1_2 = new Scanner(System.in);
				int scelta1_2=scanner1_2.nextInt();
				String marca="";
				int anno=0;
				double cilindrata=0.0;
				if(scelta1_2!=0) {
					Scanner scanner1_a = new Scanner(System.in);
					System.out.println("\nInserisci marca: ");
					marca=scanner1_a.nextLine();
					System.out.println("anno: ");
					anno=scanner1_a.nextInt();
					System.out.println("cilindrata: ");
					cilindrata = scanner1_a.nextInt();
				}
				
				switch(scelta1_2) {
				case 1:
					Scanner scanner1_a1 = new Scanner(System.in);
					System.out.println("numero porte: ");
					int porte=scanner1_a1.nextInt();
					Scanner scanner1_b1 = new Scanner(System.in);
					System.out.println("alimentazione: ");
					String alimentazione=scanner1_b1.nextLine();
					//public Auto(String marca, int anno, double cilindrata, int porte, String alimentazione) {
					Auto auto = new Auto(marca,anno,cilindrata, porte,alimentazione);
					System.out.println("\nAuto registrata");
					garage.put(posto,auto);
					System.out.println(ANSI_GREEN+"\nAuto parcheggiata al posto "+posto+" di 15");
					posto++;

					break;
				case 2:
					Scanner scanner1_a2 = new Scanner(System.in);
					System.out.println("capacita: ");
					int capacita=scanner1_a2.nextInt();
					//	public Furgone(String marca, int anno, double cilindrata, double capacita) {
					Furgone furgone = new Furgone(marca,anno,cilindrata, capacita);
					System.out.println(ANSI_GREEN+"\nFurgone registrato");
					garage.put(posto,furgone);
					System.out.println("\nFurgone parcheggiato al posto "+posto+" di 15");
					posto++;
					break;
				case 3:
					Scanner scanner1_a3 = new Scanner(System.in);
					System.out.println("tempi: ");
					int tempi=scanner1_a3.nextInt();
					//	public Moto(String marca, int anno, double cilindrata, double tempi) {
					Moto moto = new Moto(marca,anno,cilindrata, tempi);
					System.out.println("\nMoto registrata");
					garage.put(posto,moto);
					System.out.println(ANSI_GREEN+"\nMoto parcheggiata al posto"+posto+" di 15");
					posto++;
					break;
				case 0:
					System.out.println("\nFine immissione");
					break;
				case 4:
					menu();
					break;
				default:
					System.out.println(ANSI_WHITE+"\nScelta non valida.");
					break;
				}
				break;
			case 2:
				System.out.println(ANSI_RED+"\nEstrazione veicolo: immetti il posto dove "
						+ "il tuo veicolo è parcheggiato: ");
				Scanner scanner2 = new Scanner(System.in);
				int posto_ritiro = scanner2.nextInt();
				Veicolo veicolo = garage.remove(posto_ritiro);
				if(veicolo==null) {
					System.out.println("\nNon è presente alcun veicolo al posto");
				}
				if(posto_ritiro>15) {
					System.out.println("\nI posti sono fino a 15");
				}
				if(veicolo!=null){System.out.println(ANSI_GREEN+"\nIl veicolo "+veicolo+
						" è stato ritirato.");}
				break;
			case 3:
				//stampa mappa
				System.out.println(ANSI_YELLOW+"\nStampa Garage: ");
				System.out.println("\n---------------------------------------");
				Set<Integer> set = garage.keySet();
				for(Integer i:set) {
					System.out.println("Al posto "+i+" c'è il veicolo "+garage.get(i));
				}
				System.out.println("\n---------------------------------------");

				break;
			}
		}while(scelta!=0);
		
		
		
	}
}
