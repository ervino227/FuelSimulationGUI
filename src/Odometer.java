
public class Odometer {

	private int mileage;
	private int fuelBurned;
	private int lastTrip;
	
	public Odometer() {
		mileage = 0;
		lastTrip = 0;
	}
	
	public void addMiles(int fuelEconomy, int milesDriven, FuelGauge myGauge) {
		
		if(milesDriven > fuelEconomy) {
			fuelBurned = (milesDriven + lastTrip)/fuelEconomy;
			lastTrip = (milesDriven+lastTrip) % fuelEconomy;
			myGauge.burnFuel(fuelBurned);
		}
		else {
			lastTrip += milesDriven;
			if (lastTrip > fuelEconomy) {
				fuelBurned = (milesDriven + lastTrip)/fuelEconomy;
				lastTrip = (milesDriven+lastTrip) % fuelEconomy;
				myGauge.burnFuel(fuelBurned);
			}
		}
		mileage+=milesDriven;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public int getLastTrip() {
		return lastTrip;
	}
}
