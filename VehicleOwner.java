import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.sql.Timestamp;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class VehicleOwner extends User {
	
	private String username; 
	private String password, time;

	// private ArrayList<User> ownerInfo; <------ finish working on this later (potentially move to System class)
	
	/* public static int generateOwnerID() // This method generates a random ID that hasn't been used yet.
	{
		int generatedID = (int) (1000 + (Math.random() * 8999));
		
		try
		{
			File file = new File("SavedInfo/OwnerInfo.txt");
			file.getParentFile().mkdirs();
			Scanner scnr = new Scanner(file);
			System.out.println(generatedID);
			
			while (scnr.hasNext())
			{
				String currentLine = scnr.nextLine();
				
				if ((currentLine.length() > 8) && (currentLine.substring(0, 8).equals("OwnerID:")))
				{
					int usedID = Integer.parseInt(currentLine.substring(9, currentLine.length()));
					if (generatedID == usedID)
					{
						System.out.println("Match found!");
						generateOwnerID();
					}
				}
			}
			
			System.out.println("No match found!");
			scnr.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File cannot be found.");
		}
		
		return generatedID;
	} */
	
	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getTime()
	{
		return time;
	}

	public void setTime(String time)
	{
		this.time = time;
	}

	public VehicleOwner()
	{
		
	}
	
	public VehicleOwner(String firstName, String lastName, String phoneNumber, String email, String userN, String password)
	{
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
		this.username = userN;
		this.password = password;
	}
	
	public String toString()
	{
		String output = "\n First Name: " + this.getFirstName()+ "\n Last Name: " + this.getLastName()
		+ "\n Phone Number: " + this.getPhoneNumber() + "\n Email: " + this.getEmail() + "\n Username: "
		+ this.getUsername() + "\n Password: " + password ;
		return output;
	}
	
	public class vehicleOwnerPanel
	{
		File vehicleOwnerFile = new File("SavedInfo/VehicleOwnerInfo.txt");
		private JFrame frame;
		private JPanel ownerpanel;
		private JLabel instructions,fName, lName, pNum, email, userName, passWord;
		private JTextField fNField, lNField,pNumField, emailField, userNameField, passwordField;
		private JButton addUserButton, backButton;
		
		public vehicleOwnerPanel()
		{
			//Frame features
			frame = new JFrame();
			ownerpanel = new JPanel();
			frame.setSize(620, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setTitle("Vehicle Owner Registration");
			ownerpanel.setBackground(new Color(217, 204, 227));
			instructions = new JLabel("<html>Welcome to Vehicle Owner Registration.</html>", SwingConstants.CENTER);
			Font font = new Font("Times New Roman", Font.BOLD, 16);
			instructions.setFont(font);
			
			//Create labels and text fields
			fName = new JLabel("First Name:");
			fNField = new JTextField(15);
			fName.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lName = new JLabel("Last Name:");
			lNField = new JTextField(15);
			lName.setFont(new Font("Times New Roman", Font.BOLD, 14));
			pNum = new JLabel("Phone Number:");
			pNumField = new JTextField(15);
			pNum.setFont(new Font("Times New Roman", Font.BOLD, 14));
			email = new JLabel("Email:");
			emailField = new JTextField(15);
			email.setFont(new Font("Times New Roman", Font.BOLD, 14));
			userName = new JLabel("Username:"); 
			userNameField = new JTextField(15);
			userName.setFont(new Font("Times New Roman", Font.BOLD, 14));
			passWord = new JLabel("Password:"); 
			passwordField = new JTextField(15);
			passWord.setFont(new Font("Times New Roman", Font.BOLD, 14));
			addUserButton = new JButton("Submit");
			backButton = new JButton("Back");
			
			//Setting bounds to labels on panels
			frame.add(ownerpanel);
			ownerpanel.setLayout(null);
			instructions.setBounds(10, 10, 620, 35);
			ownerpanel.add(instructions);
			
			fName.setBounds(190, 50, 100, 25);
			fNField.setBounds(300, 50, 155, 25);
			ownerpanel.add(fName);
			ownerpanel.add(fNField);
			
			lName.setBounds(190, 90, 100, 25);
			lNField.setBounds(300, 90, 155, 25);
			ownerpanel.add(lName);
			ownerpanel.add(lNField);
			
			pNum.setBounds(190, 130, 100, 25);
			pNumField.setBounds(300, 130, 155, 25);
			ownerpanel.add(pNum);
			ownerpanel.add(pNumField);
			
			email.setBounds(190, 170, 100, 25);
			emailField.setBounds(300, 170, 155, 25);
			ownerpanel.add(email);
			ownerpanel.add(emailField);
			
			userName.setBounds(190, 210, 100, 25);
			userNameField.setBounds(300, 210, 155, 25);
			ownerpanel.add(userName);
			ownerpanel.add(userNameField);
			
			passWord.setBounds(190, 250, 100, 25);
			passwordField.setBounds(300, 250, 155, 25);
			ownerpanel.add(passWord);
			ownerpanel.add(passwordField);
			
			//Add User Button
			addUserButton= new JButton("Add User");
		    ownerpanel.add(addUserButton);
		    ActionListener listener = new AddUserListener();
		    addUserButton.addActionListener(listener);
		    addUserButton.setBounds(190, 320, 100, 25);
		      
		    //Back Button
			backButton = new JButton("Back");
			ownerpanel.add(backButton);
			ActionListener listener1 = new BackListener();
			backButton.addActionListener(listener1);
			backButton.setBounds(350, 320, 100, 25);
			
			frame.setVisible(true);
			// new VOServer(); <------------ Not sure what this does, but it was giving me an error so I commented it out.
		}
		
		//implement results
		public class AddUserListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				String fN = fNField.getText();
				String lN = lNField.getText();
				String phoneN = pNumField.getText();
				String email = emailField.getText();
				String username = userNameField.getText();
				String password = passwordField.getText();
				Timestamp time = new Timestamp(System.currentTimeMillis());
				
				
				ArrayList<VehicleOwner> ownerList = FileReader.VehicleOwner("SavedInfo/VehicleOwnerInfo.txt");
				for (VehicleOwner owner: ownerList)
				{
					if (owner.getUsername().equals(userNameField.getText()))
					{
						System.out.println("Username already in use!");
						return;
					}
				}
				VehicleOwner owner = new VehicleOwner(fN, lN, phoneN, email, username, password);
				//SQLDataConnection.insertVehicleOwnerSQL(owner);
				
				// -------------------------------------------------------------------------------------------------------
				// This portion of the code creates and implements a file printer that stores client information in a file	
				vehicleOwnerFile.getParentFile().mkdirs(); // use getParentFile().mkdirs() to have location where file is stored
				// created automatically if it does not exist
				
				//catch exception when printing into file
				try
				{ 
					PrintWriter fileWriter = new PrintWriter(new FileWriter (vehicleOwnerFile, true)); // create writer
					fileWriter.println();
					fileWriter.print(fN + ","); 
					fileWriter.print(lN+ ","); // get information inputed into program and print into file
					fileWriter.print(phoneN+ ",");
					fileWriter.print(email+ ",");
					fileWriter.print(username+ ",");
					fileWriter.print(password+ ",");
					fileWriter.print(time+ ",");
					fileWriter.flush();
					fileWriter.close(); // flush and close writer
					System.out.println("Vehicle Owner information saved"); // print into console when info was saved into file
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
				fNField.setText("");
				lNField.setText("");
				pNumField.setText("");
				emailField.setText("");
				userNameField.setText("");
				passwordField.setText("");
				
				JOptionPane.showMessageDialog(ownerpanel, "The information you entered has been successfully stored.");
			}
		}
		
		public class BackListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				JComponent comp = (JComponent) event.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				new WelcomePage();
			}
		}
		
		
	}
	
	public static int rejectedFrame()
	{
		JFrame frame = new JFrame();
		frame.setSize(1, 1);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		JOptionPane.showMessageDialog(frame, "Your request was rejected.");
		frame.dispose();
		int x = 0;
		return x;
	}
	
	public static int acceptFrame()
	{
		JFrame frame = new JFrame();
		frame.setSize(1, 1);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		JOptionPane.showMessageDialog(frame, "Your request was accepted.");
		frame.dispose();
		int x = 1;
		return x;
	}
	
	
	public static int startVOServer() throws IOException
	{
		ServerSocket serverSocket;
		Socket socket;
		DataInputStream inputStream;
		DataOutputStream outputStream;
		int i = 0;
		
		socket = new Socket ("localhost",4999);
		
			PrintWriter clientwriter = new PrintWriter(socket.getOutputStream());
			
			clientwriter.println("Car");
			clientwriter.flush();
			
			InputStreamReader inreader = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(inreader);
			
			String tempStr = br.readLine();
			
			if (tempStr.equals("yes")) {
				i = acceptFrame();
				return i;
				
			}
			else if (tempStr.equals("no")) {
				i = rejectedFrame();
				return i;
			}
			else {
				System.out.print("String is not recognized");
			}
			return i;
	}
	
	public static void main(String[] args)
	{
		VehicleOwner viewer = new VehicleOwner();
	}
	
}
