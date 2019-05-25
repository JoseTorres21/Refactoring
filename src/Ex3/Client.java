package src.Ex3;

import java.util.ArrayList;

public class Client {
	private static final double EUROS_PER_UNITAT_DE_COST = 30;
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
		return composaCapsalera() + composaDetalle() + composaPreu();
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

	private double importTotal() {
		// TODO Auto-generated method stub
		double total = 0;
		for (Lloguer lloguer: lloguers){
			total = total + lloguer.quantitat() * EUROS_PER_UNITAT_DE_COST;
		}
		return total;
	}

	public int bonificacionsTotals() {
		int bonificacions = 0;
		for (Lloguer lloguer:lloguers) {
			bonificacions = bonificacions + lloguer.bonificacions();
		}
		return bonificacions;
	}

	private String composaCapsalera() {
		// TODO Auto-generated method stub
		return "Informe de lloguers del client " + getNom() + " (" + getNif() + ")\n";
	}

	private String composaDetalle() {
		// TODO Auto-generated method stub
		String resultat = " ";
		// composa els resultats d'aquest lloguer
		for (Lloguer lloguer: lloguers){
			resultat += "\t" +
					lloguer.getVehicle().getMarca() +
					" " +
					lloguer.getVehicle().getModel() + ": " +
					(lloguer.quantitat() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
		}
		return resultat;
	}

	private String composaPreu() {
		// TODO Auto-generated method stub
		return "Import a pagar: " + importTotal() + "€\n" +
		"Punts guanyats: " + bonificacionsTotals() + "\n";
	}
}
