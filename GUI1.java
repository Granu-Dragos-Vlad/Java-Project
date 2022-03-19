package LigaDeFotbal;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI1 extends JFrame {
	
	JButton antrenormaxexp;
	JButton golaverajechipe;
	JButton introdumeci;
	JButton varstamedieliga;
	JButton vizualizareechipe;
	JButton campliga;
	JButton vitezafundasi;
	JButton schAnt;
	
	private void adaugaButoane() {
		this.antrenormaxexp = new JButton("Max Exp Antrenor");
		this.antrenormaxexp.setPreferredSize(new Dimension(150, 30));
		this.golaverajechipe = new JButton("Golaveraj echipe");
		this.golaverajechipe.setPreferredSize(new Dimension(150, 30));
		this.introdumeci = new JButton("Introduceti un meci");
		this.introdumeci.setPreferredSize(new Dimension(150, 30));
		this.varstamedieliga = new JButton("Varsta medie");
		this.varstamedieliga.setPreferredSize(new Dimension(150, 30));
		this.vizualizareechipe = new JButton("Vizualizeaza echipe");
		this.vizualizareechipe.setPreferredSize(new Dimension(150, 30));
		this.campliga = new JButton("Echipa campioana");
		this.campliga.setPreferredSize(new Dimension(150, 30));
		this.vitezafundasi = new JButton("Viteza medie fundasi din echipa");
		this.vitezafundasi.setPreferredSize(new Dimension(220, 30));
		this.schAnt = new JButton("Schimba antrenorul");
		this.schAnt.setPreferredSize(new Dimension(150, 30));

		JPanel mid = new JPanel(new FlowLayout(FlowLayout.LEFT));
		mid.setPreferredSize(new Dimension(750, 150));
		mid.add(this.antrenormaxexp);
		mid.add(this.golaverajechipe);
		mid.add(this.introdumeci);
		mid.add(this.varstamedieliga);
		mid.add(this.vizualizareechipe);
		mid.add(this.campliga);
		mid.add(this.vitezafundasi);
		mid.add(this.schAnt);
		this.add(mid);
		/**
		 * Implementarea butonului schAnt.
		 */
		this.schAnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame1 = new JFrame("Schimba antrenorul unei echipe");
				frame1.setLayout(new FlowLayout(FlowLayout.LEFT));
				frame1.setSize(750, 105);
				frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame1.setResizable(false);
				frame1.setLocationRelativeTo(null);
				frame1.setVisible(true);

				JButton buton1 = new JButton("Schimba numele");
				buton1.setPreferredSize(new Dimension(150, 30));

				JButton buton2 = new JButton("Schimba varsta");
				buton2.setPreferredSize(new Dimension(150, 30));

				JButton buton3 = new JButton("Schimba tara");
				buton3.setPreferredSize(new Dimension(150, 30));

				JButton buton4 = new JButton("Schimba nraniexp");
				buton4.setPreferredSize(new Dimension(150, 30));

				frame1.add(buton1);
				frame1.add(buton2);
				frame1.add(buton3);
				frame1.add(buton4);

				buton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame1.dispose();
						JFrame frame2 = new JFrame("Schimba numele antrenorului");
						frame2.setLayout(new FlowLayout(FlowLayout.LEFT));
						frame2.setSize(750, 105);
						frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						frame2.setResizable(false);
						frame2.setLocationRelativeTo(null);
						frame2.setVisible(true);

						JLabel label1 = new JLabel("Numarul echipei:");
						JTextField labelnr1 = new JTextField(10);

						JLabel label2 = new JLabel("Numele antrenorului:");
						JTextField labelnr2 = new JTextField(10);

						frame2.add(label1);
						frame2.add(labelnr1);

						frame2.add(label2);
						frame2.add(labelnr2);

						JButton buton5 = new JButton("Executa modificarea");
						buton5.setPreferredSize(new Dimension(150, 30));
						frame2.add(buton5);
						buton5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e3) {
								int val1 = Integer.parseInt(labelnr1.getText());
								String num = labelnr2.getText();
								try {
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdp3", "root",
											"");
									Statement stat = con.createStatement();
									String q1 = "UPDATE antrenori set nume='" + num + "' WHERE ID = '" + val1 + "'";
									stat.executeUpdate(q1);
								} catch (Exception e1) {
									System.out.println(e1.getMessage());
								}
								frame2.dispose();
							}

						});
					}
				});
				buton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame1.dispose();
						JFrame frame2 = new JFrame("Schimba varsta antrenorului");
						frame2.setLayout(new FlowLayout(FlowLayout.LEFT));
						frame2.setSize(750, 105);
						frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						frame2.setResizable(false);
						frame2.setLocationRelativeTo(null);
						frame2.setVisible(true);

						JLabel label1 = new JLabel("Numarul echipei:");
						JTextField labelnr1 = new JTextField(10);

						JLabel label2 = new JLabel("Varsta antrenorului:");
						JTextField labelnr2 = new JTextField(10);

						frame2.add(label1);
						frame2.add(labelnr1);

						frame2.add(label2);
						frame2.add(labelnr2);

						JButton buton5 = new JButton("Executa modificarea");
						buton5.setPreferredSize(new Dimension(150, 30));
						frame2.add(buton5);
						buton5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e3) {
								int val1 = Integer.parseInt(labelnr1.getText());
								int varsta = Integer.parseInt(labelnr2.getText());
								try {
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdp3", "root",
											"");
									Statement stat = con.createStatement();
									String q1 = "UPDATE antrenori set varsta='" + varsta + "' WHERE ID = '" + val1
											+ "'";
									stat.executeUpdate(q1);
								} catch (Exception e1) {
									System.out.println(e1.getMessage());
								}
								frame2.dispose();
							}

						});

					}
				});
				buton3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame1.dispose();
						JFrame frame2 = new JFrame("Schimba tara antrenorului");
						frame2.setLayout(new FlowLayout(FlowLayout.LEFT));
						frame2.setSize(750, 105);
						frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						frame2.setResizable(false);
						frame2.setLocationRelativeTo(null);
						frame2.setVisible(true);

						JLabel label1 = new JLabel("Numarul echipei:");
						JTextField labelnr1 = new JTextField(10);

						JLabel label2 = new JLabel("Tara antrenorului:");
						JTextField labelnr2 = new JTextField(10);

						frame2.add(label1);
						frame2.add(labelnr1);

						frame2.add(label2);
						frame2.add(labelnr2);

						JButton buton5 = new JButton("Executa modificarea");
						buton5.setPreferredSize(new Dimension(150, 30));
						frame2.add(buton5);
						buton5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e3) {
								int val1 = Integer.parseInt(labelnr1.getText());
								String tara = labelnr2.getText();
								try {
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdp3", "root",
											"");
									Statement stat = con.createStatement();
									String q1 = "UPDATE antrenori set tara='" + tara + "' WHERE ID = '" + val1 + "'";
									stat.executeUpdate(q1);
								} catch (Exception e1) {
									System.out.println(e1.getMessage());
								}
								frame2.dispose();
							}

						});

					}
				});

				buton4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame1.dispose();
						JFrame frame2 = new JFrame("Schimba nraniexp antrenor");
						frame2.setLayout(new FlowLayout(FlowLayout.LEFT));
						frame2.setSize(750, 105);
						frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						frame2.setResizable(false);
						frame2.setLocationRelativeTo(null);
						frame2.setVisible(true);

						JLabel label1 = new JLabel("Numarul echipei:");
						JTextField labelnr1 = new JTextField(10);

						JLabel label2 = new JLabel("Nraniexp antrenor:");
						JTextField labelnr2 = new JTextField(10);

						frame2.add(label1);
						frame2.add(labelnr1);

						frame2.add(label2);
						frame2.add(labelnr2);

						JButton buton5 = new JButton("Executa modificarea");
						buton5.setPreferredSize(new Dimension(150, 30));
						frame2.add(buton5);
						buton5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e3) {
								int val1 = Integer.parseInt(labelnr1.getText());
								int nraniexp = Integer.parseInt(labelnr2.getText());
								try {
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdp3", "root",
											"");
									Statement stat = con.createStatement();
									String q1 = "UPDATE antrenori set nraniexp='" + nraniexp + "' WHERE ID = '" + val1
											+ "'";
									stat.executeUpdate(q1);
								} catch (Exception e1) {
									System.out.println(e1.getMessage());
								}
								frame2.dispose();
							}

						});

					}
				});

			}
		});
		/**
		 * Implementarea butonului vitezafundasi.
		 */
		this.vitezafundasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame1 = new JFrame("Viteza medie");
				frame1.setLayout(new FlowLayout(FlowLayout.LEFT));
				frame1.setSize(450, 105);
				frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame1.setResizable(false);
				frame1.setLocationRelativeTo(null);
				frame1.setVisible(true);

				JLabel label1 = new JLabel("Numarul echipei:");
				JTextField labelnr1 = new JTextField(10);

				frame1.add(label1);
				frame1.add(labelnr1);
				JButton buton1 = new JButton("Afiseaza");
				buton1.setPreferredSize(new Dimension(150, 30));
				frame1.add(buton1);
				buton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int nre = Integer.parseInt(labelnr1.getText());
						if (nre >= 1 && nre <= 5) {
							JFrame frame2 = new JFrame("Viteza medie");
							frame2.setLayout(new FlowLayout(FlowLayout.LEFT));
							frame2.setSize(300, 100);
							frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							frame2.setResizable(false);
							frame2.setLocationRelativeTo(null);
							frame2.setVisible(true);
							JLabel label2 = new JLabel("Viteza medie este:");
							JTextArea labelnr2 = new JTextArea();
							labelnr2.setPreferredSize(new Dimension(60, 20));
							labelnr2.setText(String.valueOf(Main.vizmedie(nre)));
							frame2.add(label2);
							frame2.add(labelnr2);
						}
						frame1.dispose();
					}

				});
			}
		});
		/**
		 * Implementarea butonului campliga.
		 */
		this.campliga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame1 = new JFrame("Campioana");
				frame1.setLayout(new FlowLayout(FlowLayout.LEFT));
				frame1.setSize(750, 205);
				frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame1.setResizable(false);
				frame1.setLocationRelativeTo(null);
				frame1.setVisible(true);
				JLabel label1 = new JLabel("Campioana ligii:");
				JTextArea labelnr1 = new JTextArea();
				labelnr1.setPreferredSize(new Dimension(400, 100));
				labelnr1.setText(Main.clasament());
				frame1.add(label1);
				frame1.add(labelnr1);
			}
		});
		/**
		 * Implementarea butonului antrenormaxexp.
		 */
		this.antrenormaxexp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame1 = new JFrame("Antrenori");
				frame1.setLayout(new FlowLayout(FlowLayout.LEFT));
				frame1.setSize(1050, 205);
				frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame1.setResizable(false);
				frame1.setLocationRelativeTo(null);
				frame1.setVisible(true);
				JLabel label1 = new JLabel("Cei mai experimentati antrenori:");
				JTextArea labelnr1 = new JTextArea();
				labelnr1.setPreferredSize(new Dimension(500, 100));
				List<Antrenor2> lista = Main.afisAntrenorexp();
				for (int i = 0; i < lista.size(); ++i) {
					if (i == 0) {
						labelnr1.append(String.valueOf(lista.get(i)));
					} else {
						labelnr1.append("\n" + String.valueOf(lista.get(i)));
					}
				}
				frame1.add(label1);
				frame1.add(labelnr1);
			}
		});
		
		this.golaverajechipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame1 = new JFrame("Golaveraj");
				frame1.setLayout(new FlowLayout(FlowLayout.LEFT));
				frame1.setSize(1050, 205);
				frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame1.setResizable(false);
				frame1.setLocationRelativeTo(null);
				frame1.setVisible(true);
				JLabel label1 = new JLabel("Golaveraj echipe:");
				JTextArea labelnr1 = new JTextArea();
				labelnr1.setPreferredSize(new Dimension(500, 100));
				labelnr1.setText("Echipa 1 are golaverajul  " + Main.golaverajEchipe(1));
				labelnr1.append("\n" + "Echipa 2 are golaverajul  " + Main.golaverajEchipe(2));
				labelnr1.append("\n" + "Echipa 3 are golaverajul  " + Main.golaverajEchipe(3));
				labelnr1.append("\n" + "Echipa 4 are golaverajul  " + Main.golaverajEchipe(4));
				labelnr1.append("\n" + "Echipa 5 are golaverajul  " + Main.golaverajEchipe(5));
				frame1.add(label1);
				frame1.add(labelnr1);
			}

		});
	
		this.introdumeci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Introduceti meci");
				frame.setLayout(new FlowLayout(FlowLayout.LEFT));
				frame.setSize(650, 105);
				frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

				JLabel nrechipa1 = new JLabel("Numarul primei echipe:");
				JTextField nr1 = new JTextField(10);

				JLabel nrechipa2 = new JLabel("Numarul celei de a doua echipe:");
				JTextField nr2 = new JTextField(10);

				JLabel goluriechipa1 = new JLabel("Nr goluri echipa 1:");
				JTextField nrgoluriechipa1 = new JTextField(10);

				JLabel goluriechipa2 = new JLabel("Nr goluri echipa 2:");
				JTextField nrgoluriechipa2 = new JTextField(10);
				frame.add(nrechipa1);
				frame.add(nr1);
				frame.add(nrechipa2);
				frame.add(nr2);
				frame.add(goluriechipa1);
				frame.add(nrgoluriechipa1);
				frame.add(goluriechipa2);
				frame.add(nrgoluriechipa2);
				JButton finish = new JButton("Salveaza");
				finish.setPreferredSize(new Dimension(150, 30));
				frame.add(finish);
				finish.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (nr1.getText().compareTo(nr2.getText()) != 0) {
							int val1 = Integer.parseInt(nr1.getText());
							int val2 = Integer.parseInt(nr2.getText());
							int val3 = Integer.parseInt(nrgoluriechipa1.getText());
							int val4 = Integer.parseInt(nrgoluriechipa2.getText());
							if (val1 >= 1 && val1 <= 5 && val2 >= 1 && val2 <= 5) {
								try {
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdp3", "root",
											"");
									String q1 = "UPDATE ech set nrgolurimarcate=nrgolurimarcate+'" + val3
											+ "' WHERE nrechipa = '" + val1 + "'";
									String q2 = "UPDATE ech set nrgoluriprimite=nrgoluriprimite+'" + val4
											+ "' WHERE nrechipa = '" + val1 + "'";
									String q3 = "UPDATE ech set nrgolurimarcate=nrgolurimarcate+'" + val4
											+ "' WHERE nrechipa = '" + val2 + "'";
									String q4 = "UPDATE ech set nrgoluriprimite=nrgoluriprimite+'" + val3
											+ "' WHERE nrechipa = '" + val2 + "'";
									Statement stat = con.createStatement();
									stat.executeUpdate(q1);
									stat.executeUpdate(q2);
									stat.executeUpdate(q3);
									stat.executeUpdate(q4);
								} catch (Exception e1) {
									System.out.println(e1.getMessage());
								}
							}
						} else {
							JFrame frame3 = new JFrame("ERROR");
							frame3.setLayout(new FlowLayout(FlowLayout.LEFT));
							frame3.setSize(650, 105);
							frame3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							frame3.setResizable(false);
							frame3.setLocationRelativeTo(null);
							frame3.setVisible(true);
							JLabel a = new JLabel("Eroare:");
							JTextField a1 = new JTextField(100);
							a1.setText("Numerele echipelor trebuie sa fie diferite!");
							frame3.add(a);
							frame3.add(a1);
						}
						frame.dispose();
					}

				});

			}

		});
	
		this.varstamedieliga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame1 = new JFrame("Varsta");
				frame1.setLayout(new FlowLayout(FlowLayout.LEFT));
				frame1.setSize(400, 150);
				frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame1.setResizable(false);
				frame1.setLocationRelativeTo(null);
				frame1.setVisible(true);
				JLabel label1 = new JLabel("Varsta medie a ligii este:");
				JTextArea labelnr1 = new JTextArea();
				labelnr1.setPreferredSize(new Dimension(100, 40));
				labelnr1.setText(String.valueOf(Main.medieVarstaLiga()));
				frame1.add(label1);
				frame1.add(labelnr1);
			}

		});
		
		this.vizualizareechipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame1 = new JFrame("Vizualizeaza echipele");
				frame1.setLayout(new FlowLayout(FlowLayout.LEFT));
				frame1.setSize(700, 300);
				frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame1.setResizable(false);
				frame1.setLocationRelativeTo(null);
				frame1.setVisible(true);
				JLabel label1 = new JLabel("Echipele din liga sunt:");
				JTextArea labelnr1 = new JTextArea();
				labelnr1.setPreferredSize(new Dimension(500, 150));
				for (int i = 1; i <= 5; ++i) {
					if (i == 1) {
						labelnr1.setText(Main.afis(i));
					} else {
						labelnr1.append("\n" + Main.afis(i));
					}
				}
				frame1.add(label1);
				frame1.add(labelnr1);
			}

		});
	}

	public GUI1() throws IOException, ClassNotFoundException {
		super("Meniu");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setSize(730, 150);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		adaugaButoane();
	}
}
