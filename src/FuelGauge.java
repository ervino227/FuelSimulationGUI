
public class FuelGauge {

	private int gallonsOfFuel;
	private int fuelEconomy;
	
	public FuelGauge(int mpg) {
		gallonsOfFuel = 0;
		fuelEconomy = mpg;
	}
	
	public int getFuelAmount() {
		return gallonsOfFuel;
	}
	
	public void fillTank(int gallons) {
		for(int i = 0; i <= 15; i++) {
			if(gallonsOfFuel < 15) {
				gallonsOfFuel++;
			}
			else {
				//show message for full tank
				break;
			}
		}
	}
	
	public void burnFuel(int milesTraveled) {
		if ( gallonsOfFuel> 0) {
			int fuelUsed = milesTraveled/fuelEconomy;
		}
	}
	
}
