package src.Ex3;
//Ejericio6
import org.junit.*;
import static org.junit.Assert.*;    // importa una classe static
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;


public class TestInformeClient {
	@Test
	public void TestInforme() throws ParseException {
		Vehicle V1 = new Vehicle("Susuki","Madagascar",Vehicle.BASIC);
		Vehicle V2 = new Vehicle("Mercedes","Benk",Vehicle.GENERAL);
		Vehicle V3 = new Vehicle("Honda","Tunda",Vehicle.LUXE);

		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date D1 = dateFormat.parse("21/12/1998");
		Date D2 = dateFormat.parse("13/04/2000");
		Date D3 = dateFormat.parse("16/12/2018");

		Lloguer Ll1 = new Lloguer(D1,20);
		Lloguer Ll2 = new Lloguer(D2,10);
		Lloguer Ll3 = new Lloguer(D3,30);

		Ll1.lloga(V1);
		Ll2.lloga(V2);
		Ll3.lloga(V3);

		Client C1 = new Client("546669520X","José","665587800");
		C1.afegeix(Ll1);
		C1.afegeix(Ll2);
		C1.afegeix(Ll3);

		equals("Informe de lloguers del client José Torres Ordoñez (546669520X)\n" + 
				"\tSusuki Madagascar: 100.0€\n" + 
				"\tMercedes Benk: 199.0€\n"     + 
				"\tHonda Tunda: 720.0€\n"       + 
				"\tImport a pagar: 1019.0€\n"   + 
				"\tPunts guanyats: 7\n"+ C1.informe());	
	}

	@Test
	public void Clientasinlloguer() {
		Client C1 = new Client("546669520X","José","665587800");
	}

	@Test
	public void Clientaconlloguer() throws ParseException {
		Client C1 = new Client("546669520Y","Cesar","665587801");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date D1 = dateFormat.parse("21/12/1998");
		Vehicle V1 = new Vehicle("Susuki","Madagascar",Vehicle.BASIC);
		Lloguer Ll1 = new Lloguer(D1,20);
		C1.afegeix(Ll1);
		equals("Informe de lloguers del client Cesar Torres Ordoñez (546669520Y)\n" + 
				"\tSusuki Madagascar: 100.0€\n" + 
				"\tImport a pagar: 100.0€\n"   + 
				"\tPunts guanyats: 3\n" + C1.informe());	
	}

	@Test
	public void ClientGeneralDies() throws ParseException {
		Client C1 = new Client("546669520W","Flor","665587802");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date D2 = dateFormat.parse("21/12/1998");
		Vehicle V2 = new Vehicle("Mercedes","Benk",Vehicle.GENERAL);
		Lloguer Ll2 = new Lloguer(D2,20);
		C1.afegeix(Ll2);
		equals("Informe de lloguers del client José Torres Ordoñez (546669520X)\n" + 
				"\tSusuki Madagascar: 70.0€\n" + 
				"\tImport a pagar: 70.0€\n"   + 
				"\tPunts guanyats: 2\n" + C1.informe());
	}

	@Test
	public void ClientVariosGeneralDies() throws ParseException {
		Client C1 = new Client("546669520X","José","665587830");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date D2 = dateFormat.parse("21/12/1998");
		Vehicle V2 = new Vehicle("Mercedes","Benk",Vehicle.GENERAL);
		Lloguer Ll2 = new Lloguer(D2,20);
		C1.afegeix(Ll2);
		equals("Informe de lloguers del client José Torres Ordoñez (546669520X)\n" + 
				"\tSusuki Madagascar: 180.0€\n" + 
				"\tImport a pagar: 180.0€\n"   + 
				"\tPunts guanyats: 1\n"+ C1.informe());		
	}

	@Test
	public void ClientLuxeDies() throws ParseException {
		Client C1 = new Client("546669520X","Melanie","665587889");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date D3 = dateFormat.parse("21/12/1998");
		Vehicle V3 = new Vehicle("Honda","Tunda",Vehicle.LUXE);
		Lloguer Ll3 = new Lloguer(D3,20);
		C1.afegeix(Ll3);
		equals("Informe de lloguers del client José Torres Ordoñez (546669520X)\n" + 
				"\tSusuki Madagascar: 110.0€\n" + 
				"\tImport a pagar: 110.0€\n"   + 
				"\tPunts guanyats: 4\n" + C1.informe());	
	}

	@Test
	public void ClientVariosLuxeDies() throws ParseException {
		Client C1 = new Client("546669520X","Stefan","665587807");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date D3 = dateFormat.parse("21/12/1998");
		Vehicle V3 = new Vehicle("Honda","Tunda",Vehicle.LUXE);
		Lloguer Ll3 = new Lloguer(D3,20);
		C1.afegeix(Ll3);
		equals("Informe de lloguers del client José Torres Ordoñez (546669520X)\n" + 
				"\tSusuki Madagascar: 70.0€\n" + 
				"\tImport a pagar: 70.0€\n"   + 
				"\tPunts guanyats: 2\n" + C1.informe());	
	}

	@Test
	public void InformeHTML(){
		Client C1 = new Client("546669520X","Stefan","665587807");
		equals("<h1>Informe de lloguers</h1>\n" +
				"<p>Informe de lloguers del client <em>José Torres Ordoñez</em> (<strong>54766820x</strong>)</p>\n" +
				"<table>\n" +
				"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>     <tr><td>Tata</td><td>Vista</td><td>90.0€</td></tr>\n" +
				"<tr><td>Mercedes</td><td>Bend</td><td>100.0€</td></tr>\n" +
				"<tr><td>Honda</td><td>Tunda</td><td>300.0€</td></tr>\n" +
				"</table>\n" +
				"<p>Import a pagar: <em>490.0€</em></p>\n" +
				"<p>Punts guanyats: <em>4</em></p>" + C1.versionHTML());

	}
}

