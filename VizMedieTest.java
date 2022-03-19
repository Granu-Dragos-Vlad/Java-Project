package LigaDeFotbal;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class VizMedieTest {

	@Test
	void test() {
		Main test=new Main();
		List<Echipa1> lista = new ArrayList();
		lista.add(new Echipa1(14,34,new Antrenor2("Andrei",40,"Bulgaria",15),
				Arrays.asList(new Atacant("Vlad",20, "Romania",30,10),
						new Fundas("Sorin",23, "Italia",15,40),
						new Fundas("Mihai",17, "Grecia",10,30),
						new Mijlocas("Cristian",23, "Norvegia", 7,true))));
		int output1=test.vizmedie2(lista);
		assertEquals(35,output1);
	}

}