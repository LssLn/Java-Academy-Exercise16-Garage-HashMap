package garage;

public class Moto extends Veicolo{
	private double tempi;

	public Moto(String marca, int anno, double cilindrata, double tempi) {
		super(marca, anno, cilindrata);
		this.tempi = tempi;
	}

	public double getTempi() {
		return tempi;
	}

	public void setTempi(double tempi) {
		this.tempi = tempi;
	}

	@Override
	public String toString() {
		return "Moto [tempi=" + tempi + ", getMarca()=" + getMarca() + ", getAnno()=" + getAnno() + ", getCilindrata()="
				+ getCilindrata() + "]";
	}
	
}
