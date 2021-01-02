import javax.swing.JOptionPane;

public class FuelGauge {

	private int gallonsOfFuel;
	
	public FuelGauge() {
		gallonsOfFuel = 0;
	}
	
	public int getFuelAmount() {
		return gallonsOfFuel;
	}
	
	public void fillTank(int gallons) {
		
		for(int i = 1; i <= gallons; i++) {
			if(gallonsOfFuel < 15) {
				gallonsOfFuel++;
			}
			else {
				//show message for full tank
				JOptionPane.showMessageDialog(null, "Tank Capacity has been reached");
				break;
			}
		}
	}
	
}
