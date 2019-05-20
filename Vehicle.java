
public class Vehicle {
	private String model;
	private String marca;
	private Tipocategories categoria;
	public static Tipocategories BASIC = Tipocategories.BASIC;
	public static Tipocategories GENERAL = Tipocategories.GENERAL;
	public static Tipocategories LUXE = Tipocategories.LUXE;

	private enum Tipocategories {
		BASIC, GENERAL, LUXE;
	}
	
	public Vehicle(String model, String marca, Tipocategories categoriaa) {
		this.model = model;
		this.marca = marca;
		this.categoria = categoriaa;
	}

	public String getModel() {
		return model;
	}

	public String getMarca() {
		return marca;
	}

	public Tipocategories getCategoria() {
		return categoria;
	}
}
