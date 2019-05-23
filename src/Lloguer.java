package src;

import java.util.Date;
//Ejercicio2
public class Lloguer {
	private Date data;
	private int dies;
	private Vehicle vehicle;

	public Lloguer(Date data, int dies, Vehicle vehicle) {
		this.data = data;
		this.dies = dies;
		this.vehicle = vehicle;
		setVehicle(null);
	}

	public void setData(Date data) { this.data = data; }

	public Date getData() { return data; }

	public void setDies(int dies) { this.dies = dies; }

	public int getDies() { return dies; }

	public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

	public Vehicle getVehicle() { return vehicle; }

	public void lloga(Vehicle vehicle) { setVehicle(vehicle); }

}
