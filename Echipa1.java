package LigaDeFotbal;
import java.io.Serializable;
import java.util.List;

/**
 * @author MY Clasa Echipa1 cu atributele:
 * -numar de goluri marcate;
 * -numar de goluri primite;
 * -a;
 * -lista de jucatori;
 *
 */
public class Echipa1 implements Serializable {
	private int nrgolurimarcate;
	private int nrgoluriprimite;
	private Antrenor2 a;
	private List<Jucator> listajucatori;
	/**
	 * @param nrgolurimarcate
	 * @param nrgoluriprimite
	 * @param a
	 * @param listajucatori
	 * Constructorul clasei Echipa1
	 */
	public Echipa1(int nrgolurimarcate, int nrgoluriprimite, Antrenor2 a, List<Jucator> listajucatori) {
		this.nrgolurimarcate = nrgolurimarcate;
		this.nrgoluriprimite = nrgoluriprimite;
		this.a = a;
		this.listajucatori = listajucatori;
	}
	public Echipa1(Echipa1 other) {
		this.nrgolurimarcate=other.nrgolurimarcate;
		this.nrgoluriprimite=other.nrgoluriprimite;
		this.a = other.a;
		this.listajucatori = other.listajucatori;
	}
	public void setNrgolurimarcate(int nrgolurimarcate) {
		this.nrgolurimarcate = nrgolurimarcate;
	}
	public int getNrgolurimarcate() {
		return nrgolurimarcate;
	}
	public int getNrgoluriprimite() {
		return nrgoluriprimite;
	}
	public void setNrgoluriprimite(int nrgoluriprimite) {
		this.nrgoluriprimite = nrgoluriprimite;
	}
	public Antrenor2 getA() {
		return a;
	}
	public void setA(Antrenor2 a) {
		this.a = a;
	}
	public List<Jucator> getListajucatori() {
		return listajucatori;
	}
	public void setListajucatori(List<Jucator> listajucatori) {
		this.listajucatori = listajucatori;
	}
	/**
	 * Metoda de afisare
	 */
	public String toString() {
		return "Echipa [nrgolurimarcate=" + nrgolurimarcate + ", nrgoluriprimite=" + nrgoluriprimite + ", " + a
				+ ", listajucatori=" + listajucatori + "]";
	}
}
