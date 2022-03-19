package LigaDeFotbal;

import java.io.Serializable;

/**
 * @author MY Clasa Mijlocas mosteneste clasa Jucator,avand in plus atributul
 *         pase de gol.
 *
 */
public class Mijlocas extends Jucator implements Serializable {
	private boolean pasedegol;

	/**
	 * @param nume
	 * @param varsta
	 * @param tara
	 * @param nrtricou
	 * @param pasedegol Constructorul clasei Mijlocas.
	 */
	public Mijlocas(String nume, int varsta, String tara, int nrtricou, boolean pasedegol) {
		super(nume, varsta, tara, nrtricou);
		this.pasedegol = pasedegol;
	}

	public Mijlocas(String nume) {
		super(nume);
	}

	public boolean isPasedegol() {
		return pasedegol;
	}

	public void setPasedegol(boolean pasedegol) {
		this.pasedegol = pasedegol;
	}

	/**
	 * Metoda de afisare.
	 */
	public String toString() {
		return "Mijlocas [pasedegol=" + pasedegol + ", nume=" + getNume() + ", varsta=" + getVarsta() + ", tara="
				+ getTara() + ", nrtricou=" + getNrtricou() + "]";
	}

}
