package garage;
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
public class Veicolo {
	private String marca;
	private int anno;
	private double cilindrata;
	public Veicolo(String marca, int anno, double cilindrata) {
		this.marca = marca;
		this.anno = anno;
		this.cilindrata = cilindrata;
	}
	public Veicolo() {
		
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public double getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(double cilindrata) {
		this.cilindrata = cilindrata;
	}
	@Override
	public String toString() {
		return "Veicolo [marca=" + marca + ", anno=" + anno + ", cilindrata=" + cilindrata + "]";
	}
	
	
}
