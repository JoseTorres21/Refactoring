package Ex3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorLloguersLite {

	public static void main(String[] args) throws Exception {
		Vehicle V1 = new Vehicle("Susuki","Madagascar", Vehicle.BASIC);
		Vehicle V2 = new Vehicle("Mercedes","Benk", Vehicle.GENERAL);
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
		informeClient(C1);

	}

	public static void informeClient(Client cliente) {
		System.out.println("Client: " + cliente.getNom());
		System.out.println("\t" + cliente.getNif());
		System.out.println("\t" + cliente.getTelefon());
		System.out.println("Lloguers: <<num de lloguers del client>> " + cliente.totalLloguer(cliente));

		for( int i = 0; i < cliente.totalLloguer(cliente); i++) {
			
			System.out.println("\nVehicle «marca del vehícle del primer lloguer» «model»");
			System.out.println("Marca: " + cliente.getLloguers().get(i).getVehicle().getMarca());
			System.out.println("Model: " + cliente.getLloguers().get(i).getVehicle().getModel());
		}
	}
}
