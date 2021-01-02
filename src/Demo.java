import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class Demo {
	
	private static void createWindow() {
		
		FuelGauge myGauge = new FuelGauge();
		Odometer myOdometer = new Odometer();
		
		JFrame frame = new JFrame("Fuel Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 284);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 364, 70);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel fuelEconomyLbl = new JLabel("Vehicle Fuel Economy:");
		fuelEconomyLbl.setBounds(10, 28, 135, 14);
		panel.add(fuelEconomyLbl);
		
		JLabel myFuelEconomy = new JLabel("24");
		myFuelEconomy.setBounds(147, 28, 29, 14);
		panel.add(myFuelEconomy);
		
		JButton changeMpgButn = new JButton("Change  Value");
		changeMpgButn.setBounds(234, 24, 120, 23);
		panel.add(changeMpgButn);
		
		JLabel mpgLbl = new JLabel("mpg");
		mpgLbl.setBounds(165, 28, 34, 14);
		panel.add(mpgLbl);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 92, 364, 2);
		frame.getContentPane().add(separator);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(10, 103, 364, 131);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JLabel fuelAmount = new JLabel(String.valueOf(myGauge.getFuelAmount()));
		fuelAmount.setBounds(110, 25, 89, 14);
		panel2.add(fuelAmount);
		
		JLabel gallonsLbl = new JLabel("Gallons of fuel");
		gallonsLbl.setBounds(10, 25, 110, 14);
		panel2.add(gallonsLbl);
		
		JLabel milesDrivenLbl = new JLabel(String.valueOf(myOdometer.getMileage()));
		milesDrivenLbl.setBounds(110, 62, 89, 14);
		panel2.add(milesDrivenLbl);
		
		JLabel milesTraveledLbl = new JLabel("Vehicle mileage");
		milesTraveledLbl.setBounds(10, 62, 110, 14);
		panel2.add(milesTraveledLbl);
		
		JLabel rangeLbl = new JLabel(String.valueOf(myGauge.getFuelRange(Integer.parseInt(myFuelEconomy.getText()),myOdometer.getLastTrip() )));
		rangeLbl.setBounds(151, 96, 48, 14);
		panel2.add(rangeLbl);
		
		JButton addFuelBtn = new JButton("Add Fuel");
		addFuelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addedFuel = JOptionPane.showInputDialog(frame, "How much fuel (Gallons) to add?\nEnter a numeric value. (Max capacity: 15 Gallons.)");
				int myFuel = Integer.parseInt(addedFuel);
				
				myGauge.fillTank(myFuel);
				
				fuelAmount.setText(String.valueOf(myGauge.getFuelAmount()));
				String fuelEconomy = myFuelEconomy.getText();
				rangeLbl.setText(String.valueOf(myGauge.getFuelRange(Integer.parseInt(fuelEconomy) ,myOdometer.getLastTrip())));
			}
		});
		addFuelBtn.setBounds(265, 21, 89, 23);
		panel2.add(addFuelBtn);
		
		JButton btnNewButton_2 = new JButton("Travel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String distanceTraveled = JOptionPane.showInputDialog(frame, "How far will the trip be?\nEnter distance in miles.");
				int myDistance = Integer.parseInt(distanceTraveled);
				String fuelEconomy = myFuelEconomy.getText();
				
				myOdometer.addMiles(Integer.parseInt(fuelEconomy), myDistance, myGauge);
				milesDrivenLbl.setText(String.valueOf(myOdometer.getMileage()));
				fuelAmount.setText(String.valueOf(myGauge.getFuelAmount()));
				rangeLbl.setText(String.valueOf(myGauge.getFuelRange(Integer.parseInt(fuelEconomy),myOdometer.getLastTrip())));
			}
		});
		btnNewButton_2.setBounds(265, 58, 89, 23);
		panel2.add(btnNewButton_2);
		
		JLabel fuelRangeLbl = new JLabel("Current fuel range");
		fuelRangeLbl.setBounds(10, 96, 130, 14);
		panel2.add(fuelRangeLbl);
		
		
		JLabel lblNewLabel_1 = new JLabel("miles");
		lblNewLabel_1.setBounds(209, 96, 48, 14);
		panel2.add(lblNewLabel_1);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createWindow();
            }
        });

	}
}
