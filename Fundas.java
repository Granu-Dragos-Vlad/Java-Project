package LigaDeFotbal;

import java.io.Serializable;

/**
 * @author MY Clasa Fundas care mosteneste clasa Jucator,avand in plus atributul
 *         viteza.
 *
 */
public class Fundas extends Jucator implements Serializable {
	private int viteza;

	/**
	 * @param nume
	 * @param varsta
	 * @param tara
	 * @param nrtricou
	 * @param viteza   Constructorul clasei Fundas.
	 */
	public Fundas(String nume, int varsta, String tara, int nrtricou, int viteza) {
		super(nume, varsta, tara, nrtricou);
		this.viteza = viteza;
	}

	public Fundas(String nume) {
		super(nume);
	}

	public int getViteza() {
		return viteza;
	}

	public void setViteza(int viteza) {
		this.viteza = viteza;
	}

	/**
	 * Metoda de afisare.
	 */
	public String toString() {
		return "Fundas [viteza=" + viteza + ", nume=" + getNume() + ", varsta=" + getVarsta() + ", tara=" + getTara()
				+ ", nrtricou=" + getNrtricou() + "]";
	}

}
