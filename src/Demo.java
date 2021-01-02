import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Demo {
	
	private static void createWindow() {
		//
		
		FuelGauge myGauge = new FuelGauge();
		Odometer myOdometer = new Odometer();
		
		System.out.println(50%24);
		
		JFrame frame = new JFrame("Fuel Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 364, 70);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vehicle Fuel Economy:");
		lblNewLabel.setBounds(10, 28, 135, 14);
		panel.add(lblNewLabel);
		
		JLabel fuelEconomyLbl = new JLabel("24");
		fuelEconomyLbl.setBounds(147, 28, 29, 14);
		panel.add(fuelEconomyLbl);
		
		JButton btnNewButton = new JButton("Change  Value");
		btnNewButton.setBounds(234, 24, 120, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("mpg");
		lblNewLabel_2.setBounds(165, 28, 34, 14);
		panel.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 92, 364, 2);
		frame.getContentPane().add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 103, 364, 147);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Fuel Tank:");
		lblNewLabel_3.setBounds(10, 25, 79, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel fuelAmount = new JLabel(String.valueOf(myGauge.getFuelAmount()));
		fuelAmount.setBounds(110, 25, 19, 14);
		panel_1.add(fuelAmount);
		
		JLabel lblNewLabel_5 = new JLabel("Gallons of fuel");
		lblNewLabel_5.setBounds(155, 25, 110, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Odometer");
		lblNewLabel_6.setBounds(10, 62, 79, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel milesDrivenLbl = new JLabel(String.valueOf(myOdometer.getMileage()));
		milesDrivenLbl.setBounds(110, 62, 38, 14);
		panel_1.add(milesDrivenLbl);
		
		JLabel lblNewLabel_8 = new JLabel("Miles traveled");
		lblNewLabel_8.setBounds(155, 62, 110, 14);
		panel_1.add(lblNewLabel_8);
		
		JButton addFuelBtn = new JButton("Add Fuel");
		addFuelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addedFuel = JOptionPane.showInputDialog(frame, "How much fuel (Gallons) to add?\nEnter a numeric value. (Max capacity: 15 Gallons.)");
				int myFuel = Integer.parseInt(addedFuel);
				
				myGauge.fillTank(myFuel);
				
				fuelAmount.setText(String.valueOf(myGauge.getFuelAmount()));
			}
		});
		addFuelBtn.setBounds(10, 100, 89, 23);
		panel_1.add(addFuelBtn);
		
		JButton btnNewButton_2 = new JButton("Travel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String distanceTraveled = JOptionPane.showInputDialog(frame, "How far will the trip be?\nEnter distance in miles.");
				int myDistance = Integer.parseInt(distanceTraveled);
				String fuelEconomy = fuelEconomyLbl.getText();
				
				myOdometer.addMiles(Integer.parseInt(fuelEconomy), myDistance, myGauge);
				milesDrivenLbl.setText(String.valueOf(myOdometer.getMileage()));
				fuelAmount.setText(String.valueOf(myGauge.getFuelAmount()));
				
			}
		});
		btnNewButton_2.setBounds(140, 100, 89, 23);
		panel_1.add(btnNewButton_2);
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
