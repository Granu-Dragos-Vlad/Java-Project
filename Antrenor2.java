package LigaDeFotbal;

import java.io.Serializable;

/**
 * @author MY Clasa Antrenor2 cu atributele: -nume; -varsta; -tara; -numar de
 *         ani experienta.
 *
 */
public class Antrenor2 implements Serializable {
	private String nume;
	private int varsta;
	private String tara;
	private int nraniexperienta;

	/**
	 * @param nume
	 * @param varsta
	 * @param tara
	 * @param nraniexperienta Constructorul clasei
	 */
	public Antrenor2(String nume, int varsta, String tara, int nraniexperienta) {
		this.nume = nume;
		this.varsta = varsta;
		this.tara = tara;
		this.nraniexperienta = nraniexperienta;
	}

	public Antrenor2() {
	}
	public Antrenor2(String nume) {
		this.nume = nume;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public String getTara() {
		return tara;
	}

	public void setTara(String tara) {
		this.tara = tara;
	}

	public int getNraniexperienta() {
		return nraniexperienta;
	}

	public void setNraniexperienta(int nraniexperienta) {
		this.nraniexperienta = nraniexperienta;
	}

	/**
	 * Metoda de afisare
	 */
	public String toString() {
		return "Antrenor [nume=" + nume + ", varsta=" + varsta + ", tara=" + tara + ", nraniexperienta="
				+ nraniexperienta + "]";
	}

}
