package LigaDeFotbal;

import java.io.Serializable;

/**
 * @author MY Clasa Portar care extinde clasa Jucator,avand in plus atributul
 *         inaltime.
 *
 */
public class Portar extends Jucator implements Serializable {
	private double inaltime;

	/**
	 * @param nume
	 * @param varsta
	 * @param tara
	 * @param nrtricou
	 * @param inaltime Constructorul clasei Portar.
	 */
	public Portar(String nume, int varsta, String tara, int nrtricou, double inaltime) {
		super(nume, varsta, tara, nrtricou);
		this.inaltime = inaltime;
	}

	public Portar(String nume) {
		super(nume);
	}

	public double getInaltime() {
		return inaltime;
	}

	public void setInaltime(double inaltime) {
		this.inaltime = inaltime;
	}

	/**
	 * Metoda de afisare.
	 */
	public String toString() {
		return "Portar [inaltime=" + inaltime + ", nume=" + getNume() + ", varsta=" + getVarsta() + ", tara="
				+ getTara() + ", nrtricou=" + getNrtricou() + "]";
	}

}
