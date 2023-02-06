import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.Timestamp;
import java.util.*;

public class Vehicle extends VehicleOwner {
	
	private String vehicleVIN;
	private String vehicleYear;
	private String vehicleMake;
	private String vehicleModel;
	private String vehicleColor;
	private String vehicleAvailable;
	private String vehicleDamageNotes;
	private VehicleOwner vehicleOwner;

	public Vehicle (String vehicleVIN, String vehicleYear, String vehicleMake, String vehicleModel, String vehicleColor, String available, String vehicleDamageNotes)
	{
		this.vehicleVIN = vehicleVIN;
		this.vehicleYear = vehicleYear;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		this.vehicleColor = vehicleColor;
		this.vehicleAvailable = available;
		this.vehicleDamageNotes = vehicleDamageNotes;
	}
	
	public Vehicle()
	{
		
	}
	
	public Vehicle (String userName, String vehicleVIN, String vehicleYear, String vehicleMake, String vehicleModel, String vehicleColor, String available, String vehicleDamageNotes)
	{
		this.setUsername(userName);  
		this.vehicleVIN = vehicleVIN;
		this.vehicleYear = vehicleYear;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		this.vehicleColor = vehicleColor;
		this.vehicleAvailable = available;
		this.vehicleDamageNotes = vehicleDamageNotes;
	}	
		
	public String getVehicleVIN()
	{
		return vehicleVIN;
	}

	public void setVehicleVIN(String vehicleVIN)
	{
		this.vehicleVIN = vehicleVIN;
	}

	public String getVehicleYear()
	{
		return vehicleYear;
	}

	public void setVehicleYear(String vehicleYear)
	{
		this.vehicleYear = vehicleYear;
	}

	public String getVehicleMake()
	{
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake)
	{
		this.vehicleMake = vehicleMake;
	}

	public String getVehicleModel()
	{
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel)
	{
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleColor()
	{
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor)
	{
		this.vehicleColor = vehicleColor;
	}

	public String getVehicleAvailable()
	{
		return vehicleAvailable;
	}

	public void setVehicleAvailable(String vehicleAvailable)
	{
		this.vehicleAvailable = vehicleAvailable;
	}

	public String getVehicleDamageNotes()
	{
		return vehicleDamageNotes;
	}

	public void setVehicleDamageNotes(String vehicleDamageNotes)
	{
		this.vehicleDamageNotes = vehicleDamageNotes;
	}

	public VehicleOwner getVehicleOwner()
	{
		return vehicleOwner;
	}

	public void setVehicleOwner(VehicleOwner vehicleOwner)
	{
		this.vehicleOwner = vehicleOwner;
	}

	public String toString()
	{
		String output = Login.usernameField.getText() + " " + this.vehicleVIN + " " + this.vehicleYear + " " + this.vehicleModel + " " + this.vehicleMake + 
				" " + this.vehicleDamageNotes + " " +this.vehicleColor + " " +this.vehicleAvailable;
		return output;

	}
	
	// --------------------------------------------------
	// This constructor creates the GUI that allows information about a specified
	// vehicle to be entered and stored.
	
	public class vehiclePanel {
		private JFrame frame;
		private JPanel mainpanel;
		private JLabel instructions, VIN, Year, Make, Model, Color, Availability, DamageNotes, savedMessage;
		private JTextField inVIN, inYear, inMake, inModel, inColor, inAvailability, inDamageNotes;
		private JButton saveButton, backButton;
		
		public vehiclePanel() {
			frame = new JFrame();
			mainpanel = new JPanel();
			instructions = new JLabel("<html>Welcome to the Vehicle Viewer. Please enter all of the following information about a vehicle and click the store button once completed.</html>");
			Font font = new Font("Times New Roman", Font.BOLD, 16);
			instructions.setFont(font);
			VIN = new JLabel("Vehicle VIN");
			inVIN = new JTextField(10);
			VIN.setFont(new Font("Times New Roman", Font.BOLD, 14));
			Year = new JLabel("Vehicle Year");
			inYear = new JTextField(10);
			Year.setFont(new Font("Times New Roman", Font.BOLD, 14));
			Make = new JLabel("Vehicle Make");
			inMake = new JTextField(10);
			Make.setFont(new Font("Times New Roman", Font.BOLD, 14));
			Model = new JLabel("Vehicle Model");
			inModel = new JTextField(10);
			Model.setFont(new Font("Times New Roman", Font.BOLD, 14));
			Color = new JLabel("Vehicle Color");
			inColor = new JTextField(10);
			Color.setFont(new Font("Times New Roman", Font.BOLD, 14));
			Availability = new JLabel("Availability");
			inAvailability = new JTextField(10);
			Availability.setFont(new Font("Times New Roman", Font.BOLD, 14));
			DamageNotes = new JLabel("Damage Notes");
			inDamageNotes = new JTextField(10);
			DamageNotes.setFont(new Font("Times New Roman", Font.BOLD, 14));
			saveButton = new JButton("Store");
			savedMessage = new JLabel("");
			backButton = new JButton("Home");
			
			frame.setSize(620, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setTitle("Vehicle Viewer");
	
			frame.add(mainpanel);
			mainpanel.setLayout(null);
			mainpanel.setBackground(new Color(225, 186, 255));
			instructions.setBounds(10, 10, 620, 35);
			mainpanel.add(instructions);
	
			VIN.setBounds(190, 50, 100, 25);
			inVIN.setBounds(300, 50, 155, 25);
			mainpanel.add(VIN);
			mainpanel.add(inVIN);
	
			Year.setBounds(190, 90, 100, 25);
			inYear.setBounds(300, 90, 155, 25);
			mainpanel.add(Year);
			mainpanel.add(inYear);
	
			Make.setBounds(190, 130, 100, 25);
			inMake.setBounds(300, 130, 155, 25);
			mainpanel.add(Make);
			mainpanel.add(inMake);
	
			Model.setBounds(190, 170, 100, 25);
			inModel.setBounds(300, 170, 155, 25);
			mainpanel.add(Model);
			mainpanel.add(inModel);
	
			Color.setBounds(190, 210, 100, 25);
			inColor.setBounds(300, 210, 155, 25);
			mainpanel.add(Color);
			mainpanel.add(inColor);
	
			Availability.setBounds(190, 250, 100, 25);
			inAvailability.setBounds(300, 250, 155, 25);
			mainpanel.add(Availability);
			mainpanel.add(inAvailability);
	
			DamageNotes.setBounds(190, 290, 100, 25);
			inDamageNotes.setBounds(300, 290, 155, 25);
			mainpanel.add(DamageNotes);
			mainpanel.add(inDamageNotes);
	
			saveButton.setBounds(190, 340, 100, 25);
			ActionListener listener = new saveListener();
			saveButton.addActionListener(listener);
			mainpanel.add(saveButton);
	
			backButton.setBounds(360, 340, 100, 25);
			ActionListener listener1 = new backListener();
			backButton.addActionListener(listener1);
			mainpanel.add(backButton);
	
			savedMessage.setBounds(450, 150, 150, 100);
			mainpanel.add(savedMessage);
	
			frame.setVisible(true);
		}

		// --------------------------------------------------
		// This method allows the "store" button to properly function and record the
		// entered information.
		public class saveListener implements ActionListener {
			int result = 0;
			public void actionPerformed(ActionEvent e)
			{
				try {
					result = VehicleOwner.startVOServer();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (result == 1) {
				String userName = Login.usernameField.getText();
				String newVIN = inVIN.getText();
				String newYear = inYear.getText();
				String newMake = inMake.getText();
				String newModel = inModel.getText();
				String newColor = inColor.getText();
				String newAvailability = inAvailability.getText();
				String newDamageNotes = inDamageNotes.getText();
				Timestamp time = new Timestamp(System.currentTimeMillis());
				
				Vehicle vehicle = new Vehicle(userName,newVIN,newYear, newMake, newModel, newColor, newAvailability, newDamageNotes);
				SQLDataConnection.insertVehicleSQL(vehicle);
				
				// --------------------------------------------------
				// Added a file printer that stores vehicle information
				File file = new File("SavedInfo/CarInfo.txt"); // create new file where info will be stored
				file.getParentFile().mkdirs(); // use getParentFile().mkdirs() to have location where file is stored created
				// automatically if it does not exist
				
				// catch exception when printing into file
				try
				{ 
					PrintWriter fileWriter = new PrintWriter(new FileWriter(file, true)); // create writer
					fileWriter.println();
					fileWriter.print(userName+ ",");
					fileWriter.print(newVIN + ","); // get information inputed into program and print into file
					fileWriter.print(newYear + ",");
					fileWriter.print(newMake + ",");
					fileWriter.print(newModel + ",");
					fileWriter.print(newColor + ",");
					fileWriter.print(newAvailability + ",");
					fileWriter.print(newDamageNotes + ",");
					fileWriter.print(time + ",");
					fileWriter.flush();
					fileWriter.close(); // flush and close writer
					System.out.println("Car information stored"); // print into console when info was saved into file
					
				}
				catch (IOException k)
				{
					k.printStackTrace();
				}
				 inVIN.setText(""); inYear.setText(""); inModel.setText(""); inColor.setText(""); inAvailability.setText(""); inDamageNotes.setText("");
				
				 savedMessage.setText("<html>The entered information has been successfully stored.</html>");
			}
				else if(result ==0) {
					 inVIN.setText(""); inYear.setText(""); inMake.setText(""); inModel.setText(""); inColor.setText(""); inAvailability.setText(""); inDamageNotes.setText("");
					 savedMessage.setText("<html>The entered information has been rejected for storage.</html>");
				}
			}
		}
		
		
		// --------------------------------------------------
		// This class and method are required to allow the "back" button to function
		// properly.
		public class backListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HomePage.VehicleOwnerHome home = new HomePage().new VehicleOwnerHome();
			}
		}
	}
	
	public static void main(String[] args)
	{
		vehiclePanel viewer = new Vehicle().new vehiclePanel();
	}
}
