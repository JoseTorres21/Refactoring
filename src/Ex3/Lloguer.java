package src.Ex3;

import java.util.Date;

public class Lloguer {
	private static final double COST_QUANTITAT_BASIC = 3;
	private static final int UNITAT_COST__BASIC = 1;
	private static final double COST_QUANTITAT_GENERAL = 4;
	private static final int UNITAT_COST__GENERAL = 2;
	private static final int COST_QUANTITAT_LUXE = 6;
	
	private Date data;
	private int dies;
	private Vehicle vehicle;

	public Lloguer(Date data, int dies, Vehicle vehicle) {
		this.data = data;
		this.dies = dies;
		this.vehicle = vehicle;
		setVehicle(null);
	}

	Lloguer(Date data, int dies) {
		this.setData(data);
		this.setDies(dies);
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getData() {
		return data;
	}

	public void setDies(int dies) {
		this.dies = dies;
	}

	public int getDies() {
		return dies;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void lloga(Vehicle vehicle) {
		this.vehicle = vehicle;
		setVehicle(vehicle);
	}

	public void eliminaLloguer() {
		setVehicle(null);
	}

	public double PreuCost () {
		double quantitat = 0;
		switch(getVehicle().getCategoria()) {
		case Vehicle.BASIC:
			quantitat = quantitat + COST_QUANTITAT_BASIC;
			if(getDies() > COST_QUANTITAT_BASIC) {
				quantitat = quantitat + (getDies() -UNITAT_COST__BASIC) * 1.5;
			}
			break;

		case Vehicle.GENERAL:
			quantitat = quantitat + COST_QUANTITAT_GENERAL;
			if(getDies() > COST_QUANTITAT_GENERAL) {
				quantitat = quantitat + (getDies() -UNITAT_COST__GENERAL) * 2.5;
			}
			break;

		case Vehicle.LUXE:
			quantitat = quantitat + getDies() * COST_QUANTITAT_LUXE;
			break;
		}
		return quantitat;
	}

	public int bonificacions() {
		// TODO Auto-generated method stub
		int bonificacions = 0;
		if (vehicle.getCategoria() == Vehicle.LUXE && dies > 1) {
			bonificacions++;
		}
		return bonificacions;
	}
}
