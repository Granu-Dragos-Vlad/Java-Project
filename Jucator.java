package LigaDeFotbal;

import java.io.Serializable;

/**
 * @author MY Clasa Jucator cu atributele: -nume; -varsta; -tara; -numar tricou.
 *
 */
public abstract class Jucator implements Serializable {
	private String nume;
	private int varsta;
	private String tara;
	private int nrtricou;

	/**
	 * @param nume
	 * @param varsta
	 * @param tara
	 * @param nrtricou Constructorul clasei Jucator.
	 */
	public Jucator(String nume, int varsta, String tara, int nrtricou) {
		super();
		this.nume = nume;
		this.varsta = varsta;
		this.tara = tara;
		this.nrtricou = nrtricou;
	}

	public Jucator() {
	}

	public Jucator(String nume) {
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

	public int getNrtricou() {
		return nrtricou;
	}

	public void setNrtricou(int nrtricou) {
		this.nrtricou = nrtricou;
	}

	/**
	 * Metoda de afisare.
	 */
	public String toString() {
		return "[nume=" + nume + ", varsta=" + varsta + ", tara=" + tara + ", nrtricou=" + nrtricou + "]";
	}

}
