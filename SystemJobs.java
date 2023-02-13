import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SystemJobs {

	public class vehicleCheckIN {
		private JFrame frame;
		private JPanel checkInPanel;
		private JLabel instructions; 
		private JButton backButton, checkIn; 
		private JComboBox<String> list;
		//public static Vehicle currentState = new Vehicle();
		List<Vehicle> vehicleList = FileReader.Vehicle("SavedInfo/CarInfo.txt");
		ArrayList<Vehicle> checkedIn = new ArrayList<Vehicle>();
		
		public vehicleCheckIN() {
			frame = new JFrame(); 
			frame.setSize(500, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setTitle("Vehicle CheckIn");
			
			checkInPanel = new JPanel();  
			frame.add(checkInPanel);
			checkInPanel.setLayout(null);
			instructions = new JLabel("<html>Vehicle Check In</html>");
			instructions.setBounds(10, 10, 320, 35);
			Font font = new Font("Times New Roman", Font.BOLD, 16);
			instructions.setFont(font);
			checkInPanel.add(instructions); 
			checkInPanel.setBackground(new Color(128,111,176));
			
			ArrayList<String> options = new ArrayList<String>(); 
			List<Vehicle> vehicleList = FileReader.Vehicle("SavedInfo/CarInfo.txt");
			int size = vehicleList.size();
			for(Vehicle car: vehicleList) {
				options.add(car.getVehicleVIN());}
			
			list = new JComboBox<String>();
			list.setModel(new DefaultComboBoxModel<String>(options.toArray(new String[size])));
			list.setBounds(10,60,140,30);
	        checkInPanel.add(list);
	        
	        checkIn = new JButton("CheckIN"); 
	        checkIn.setBounds(160, 60, 100, 30); 
	        checkInPanel.add(checkIn);
	        ActionListener listener = new checkINListener();
			checkIn.addActionListener(listener);
			
			backButton = new JButton("Home");
			backButton.setBounds(360, 300, 100, 25);
			ActionListener listener1 = new backListener();
			backButton.addActionListener(listener1);
			checkInPanel.add(backButton);

	        
	        frame.setVisible(true);
		}
		public Vehicle findByVIN(String id) {
			for (Vehicle car : vehicleList) {
				if (car.getVehicleVIN().equals(id)) {
					return car;
				}
			}
			return null;
		}
		
		public class backListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HomePage.VehicleOwnerHome home = new HomePage().new VehicleOwnerHome();
			}
		}

		public class checkINListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Vehicle testCar = new Vehicle();
		for (Vehicle car: vehicleList) {
			String x = (String)list.getSelectedItem();
			
			if (x.equals(car.getVehicleVIN()));{	
				testCar = findByVIN(x);
			}

			} 
		
		File file = new File("SavedInfo/VehicleCheckedIn.txt"); // create new file where info will be stored
		file.getParentFile().mkdirs(); // use getParentFile().mkdirs() to have location where file is stored created
										// automatically
										// if it does not exist

		try { // catch exception when printing into file
			PrintWriter fileWriter = new PrintWriter(new FileWriter(file, true)); // create writer
			Timestamp time = new Timestamp(System.currentTimeMillis());
			fileWriter.println();
			fileWriter.print(testCar.getUsername()+",");
			fileWriter.print(testCar.getVehicleVIN()+",");
			fileWriter.print(testCar.getVehicleYear()+",");
			fileWriter.print(testCar.getVehicleMake()+",");
			fileWriter.print(testCar.getVehicleModel()+",");
			fileWriter.print(testCar.getVehicleColor()+",");
			fileWriter.print(testCar.getVehicleAvailable()+",");
			fileWriter.print(testCar.getVehicleDamageNotes()+",");
			fileWriter.print(time+",");
			fileWriter.flush();
			fileWriter.close(); // flush and close writer
			System.out.println("Car information stored"); // print into console when info was saved into file

		} catch (IOException k) {
			k.printStackTrace();
		}
		System.out.println("Car was CheckedIn");
		}
		}
}			

	public static void main(String[] args) {
		//vehicleCheckIN viewer = new SystemJobs().new vehicleCheckIN();
	}
}
