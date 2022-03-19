package LigaDeFotbal;

import java.io.Serializable;

/**
 * @author MY
 * Clasa Atacant care mosteneste clasa Jucator,avand in plus atributul numar de goluri.
 *
 */
public class Atacant extends Jucator implements Serializable {
	private int nrgoluri;

	public Atacant(String nume) {
		super(nume);
	}

	/**
	 * @param nume
	 * @param varsta
	 * @param tara
	 * @param nrtricou
	 * @param nrgoluri
	 * Constructorul clasei Atacant
	 */
	public Atacant(String nume, int varsta, String tara, int nrtricou, int nrgoluri) {
		super(nume, varsta, tara, nrtricou);
		this.nrgoluri = nrgoluri;
	}

	public int getNrgoluri() {
		return nrgoluri;
	}

	public void setNrgoluri(int nrgoluri) {
		this.nrgoluri = nrgoluri;
	}

	/**
	 * Metoda de afisare
	 */
	public String toString() {
		return "Atacant [nrgoluri=" + nrgoluri + ", nume=" + getNume() + ", varsta=" + getVarsta() + ", tara="
				+ getTara() + ", nrtricou=" + getNrtricou() + "]";
	}
}
