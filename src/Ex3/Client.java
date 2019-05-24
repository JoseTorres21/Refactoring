package src.Ex3;

import java.util.ArrayList;

public class Client {
	private String nif;
	private String nom;
	private String telefon;
	private ArrayList<Lloguer> lloguers;

	public Client(String nif, String nom, String telefon) {
		this.nif = nif;
		this.nom = nom;
		this.telefon = telefon;
		this.lloguers = new ArrayList<Lloguer>();
	}

	public String getNif()     { return nif;     }
	public String getNom()     { return nom;     }
	public String getTelefon() { return telefon; }

	public void setNif(String nif) { this.nif = nif; }
	public void setNom(String nom) { this.nom = nom; }
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public void afegeix(Lloguer lloguer) {
		if (! lloguers.contains(lloguer) ) {
			lloguers.add(lloguer);
		}
	}
	public void elimina(Lloguer lloguer) {
		if (lloguers.contains(lloguer) ) {
			lloguers.remove(lloguer);
		}
	}
	public boolean conte(Lloguer lloguer) {
		return lloguers.contains(lloguer);
	}

	/*public String informe() {
		// XXX: de moment buit
		return null;
	}*/

	public int totalLloguer(Client c) {
		return lloguers.size();
	}

	public ArrayList<Lloguer> getLloguers() {
		return lloguers;
	}

	public String informe() {
		double total = 0;
		int bonificacions = 0;
		String resultat = "Informe de lloguers del client " +
				getNom() +
				" (" + getNif() + ")\n";
		for (Lloguer lloguer: lloguers) {

			// afegeix lloguers freqüents
			//bonificacions ++;
			//bonificacions = bonificacions + bonificacionsDeLloguer(lloguer);
			bonificacions = bonificacions + lloguer.bonificacions();


			// composa els resultats d'aquest lloguer
			resultat += "\t" +
					lloguer.getVehicle().getMarca() +
					" " +
					lloguer.getVehicle().getModel() + ": " +
					(lloguer.quantitat() * 30) + "€" + "\n";
			total += lloguer.quantitat() * 30;
		}

		// afegeix informació final
		resultat += "Import a pagar: " + total + "€\n" +
				"Punts guanyats: " + bonificacions + "\n";
		return resultat;
	}

	/*private int bonificacionsDeLloguer(Lloguer lloguer) {
		int bonificacions = 0;
		// afegeix bonificació per dos dies de lloguer de Luxe
		if (lloguer.getVehicle().getCategoria() == Vehicle.LUXE &&
				lloguer.getDies()>1 ) {
			bonificacions ++;
		}
		return bonificacions;
	}*/
}
