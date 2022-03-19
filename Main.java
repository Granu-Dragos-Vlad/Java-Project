package LigaDeFotbal;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author MY Clasa Main cu metoda main de apelare a GUI.
 *
 */
public class Main {

	/**
	 * @param args de tip string.
	 * @throws ClassNotFoundException arunca o eroare in cazul in care nu gaseste clasa.
	 * @throws IOException in cazul unor probleme de I/O.
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		GUI1 gui = new GUI1();
		gui.setVisible(true);
		gui.setLocationRelativeTo(null);

	}

	/**
	 * @param nrechipa
	 * @return
	 * Metoda prin care calculam viteza medie a fundasilor unei echipe.
	 */
	static int vizmedie(int nrechipa) {
		double viz = 0.00;
		double suma = 0;
		int nr = 0;
		int viz1 = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdp3", "root", "");
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from fundasi");
			while (rs.next()) {
				if (rs.getInt(6) / 10 == nrechipa) {
					suma = suma + rs.getInt(5);
					nr++;
				}
			}
			viz = suma / nr;
			viz1 = (int) Math.round(viz);
			return viz1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return viz1;
	}

	/**
	 * @return
	 * Metoda prin care afisam echipa campioana din liga.
	 */
	static String clasament() {
		String s = " ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdp3", "root", "");
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from ech");
			int maxnrgoluri = 0;
			int mingoluriprimite = 1000;
			while (rs.next()) {
				if (rs.getInt(3) > maxnrgoluri && mingoluriprimite > rs.getInt(2)) {
					maxnrgoluri = rs.getInt(3);
					mingoluriprimite = rs.getInt(2);
				}
			}
			rs = stat.executeQuery("select  nrgoluriprimite,nrgolurimarcate from ech");
			while (rs.next()) {
				if (rs.getInt(2) == maxnrgoluri && rs.getInt(1) == mingoluriprimite) {
					s = "Echipa campioana a marcat " + String.valueOf(maxnrgoluri) + " goluri si a primit "
							+ String.valueOf(mingoluriprimite) + " goluri";
				}
			}
			return s;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return s;
	}

	/**
	 * @param contor
	 * @return
	 * Metoda prin care afisam numarul de goluri marcate,numarul de goluri primite si antrenorul echipei.
	 */
	static String afis(int contor) {
		String s = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdp3", "root", "");
			Statement stat = con.createStatement();
			String nr1 = null;
			String nr2 = null;
			String numeant = null;
			ResultSet rs = stat.executeQuery("select * from antrenori WHERE ID='" + contor + "'");
			while (rs.next()) {
				numeant = rs.getString(1);
			}
			rs = stat.executeQuery("select * from ech WHERE nrechipa='" + contor + "'");
			while (rs.next()) {
				nr1 = String.valueOf(rs.getInt(3));
				nr2 = String.valueOf(rs.getInt(2));
			}
			s = "Echipa " + String.valueOf(contor) + " cu nrgolurimarcate " + nr1 + " si nrgoluriprimite " + nr2
					+ " si antrenor " + numeant;
			return s;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return s;

	}

	/**
	 * @return
	 * Metoda prin care afisam varsta medie din liga.
	 */
	static int medieVarstaLiga() {
		double medie = 0.00;
		int medie1 = 0;
		try {
			int suma = 0;
			int nr = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdp3", "root", "");
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select varsta from atacanti");
			while (rs.next()) {
				suma = suma + rs.getInt(1);
				nr++;
			}
			rs = stat.executeQuery("select varsta from fundasi");
			while (rs.next()) {
				suma = suma + rs.getInt(1);
				nr++;
			}
			rs = stat.executeQuery("select varsta from mijlocasi");
			while (rs.next()) {
				suma = suma + rs.getInt(1);
				nr++;
			}
			rs = stat.executeQuery("select varsta from portari");
			while (rs.next()) {
				suma = suma + rs.getInt(1);
				nr++;
			}
			rs = stat.executeQuery("select varsta from antrenori");
			while (rs.next()) {
				suma = suma + rs.getInt(1);
				nr++;
			}
			medie = suma / nr;
			medie1 = (int) Math.round(medie);
			return medie1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return medie1;
	}

	/**
	 * @param listaechipe
	 * @param nr1
	 * @param nr2
	 * @param nrgol1
	 * @param nrgol2
	 * Metoda prin care introducem un meci intre doua echipe din cadrul ligii.
	 */
	static void introduMeci(List<Echipa1> listaechipe, int nr1, int nr2, int nrgol1, int nrgol2) {
		int index = 1;
		for (Echipa1 e : listaechipe) {
			if (index == nr1) {
				int a = e.getNrgolurimarcate() + nrgol1;
				e.setNrgolurimarcate(a);
				int b = e.getNrgoluriprimite() + nrgol2;
				e.setNrgoluriprimite(b);

			} else if (index == nr2) {
				int a = e.getNrgolurimarcate() + nrgol2;
				e.setNrgolurimarcate(a);
				int b = e.getNrgoluriprimite() + nrgol1;
				e.setNrgoluriprimite(b);
			}
			index++;
		}
	}

	/**
	 * @param nr1
	 * @return
	 * Metoda prin care calculam golaverajul unei echipe.
	 */
	static String golaverajEchipe(int nr1) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdp3", "root", "");
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from ech WHERE nrechipa=" + nr1);
			while (rs.next()) {
				return String.valueOf(rs.getInt(3) - rs.getInt(2));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return " ";

	}

	/**
	 * @return
	 * Metoda prin care returnam o lista cu antrenorii care au experienta cea mai mare.
	 */
	static List<Antrenor2> afisAntrenorexp() {
		List<Antrenor2> l1 = new ArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdp3", "root", "");
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select nraniexp from antrenori");
			int maxexp = 0;
			while (rs.next()) {
				if (rs.getInt(1) > maxexp) {
					maxexp = rs.getInt(1);
				}
			}
			rs = stat.executeQuery("select * from antrenori");
			while (rs.next()) {
				if (rs.getInt(4) == maxexp) {
					l1.add(new Antrenor2(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4)));
				}
			}
			return l1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return l1;
	}

	static int medie2(List<Echipa1> l) {
		double medie = 0.00;
		int medie1 = 0;
		int suma = 0;
		int nr = 0;
		for (Echipa1 x : l) {
			for (int i = 0; i < x.getListajucatori().size(); ++i) {
				suma = suma + x.getListajucatori().get(i).getVarsta();
				nr++;
			}
			suma = suma + x.getA().getVarsta();
			nr++;
		}
		medie = suma / nr;
		medie1 = (int) Math.round(medie);
		return medie1;
	}

	static int vizmedie2(List<Echipa1> l) {
		double medie = 0.00;
		int medie1 = 0;
		int suma = 0;
		int nr = 0;
		for (Echipa1 x : l) {
			for (int i = 0; i < x.getListajucatori().size(); ++i) {
				if (x.getListajucatori().get(i) instanceof Fundas) {
					suma = suma + ((Fundas) x.getListajucatori().get(i)).getViteza();
					nr++;
				}
			}
		}
		medie = suma / nr;
		medie1 = (int) Math.round(medie);
		return medie1;
	}

}