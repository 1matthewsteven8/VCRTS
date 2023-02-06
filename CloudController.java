import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import javax.swing.*;

public class CloudController {
	
	// initialized variables
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String userName; 
	private String password;
	
	// getters and setters
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public CloudController(String fN, String lN, String phoneN, String email, String username, String password)
	{
		this.firstName = fN;
		this.lastName = lN;
		this.phoneNumber = phoneN;
		this.email = email;
		this.userName = username;
		this.password = password;
	}
	
	public CloudController()
	{
		new CCViewer();
	}

	@Override
	public String toString()
	{
		String output = "\n First Name: " + firstName + "\n Last Name: " + lastName + "\n Phone Number: " + phoneNumber + "\n Email: " + email + "\n Username: " + userName + "\n Password: " + password ;
		return output;
	}
	
	public class CCViewer
	{
		File adminFile = new File("SavedInfo/CloudControllerInfo.txt");
		private JFrame frame;
		private JPanel CCpanel;
		private JLabel instructions,fName, lName, pNum, email, username, password;
		private JTextField fNField, lNField,pNumField, emailField, userNameField, passwordField;
		private JButton addUserButton, backButton;
		
		public CCViewer()
		{
			// Frame features
			frame = new JFrame();
			CCpanel = new JPanel();
			frame.setSize(620, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setTitle("Cloud Controller Registration");
			CCpanel.setBackground(new Color(179,143,207));
			instructions = new JLabel("<html>Welcome to Cloud Controller Registration.</html>", SwingConstants.CENTER);
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
			username = new JLabel("Username:"); 
			userNameField = new JTextField(15);
			username.setFont(new Font("Times New Roman", Font.BOLD, 14));
			password = new JLabel("Password:"); 
			passwordField = new JTextField(15);
			password.setFont(new Font("Times New Roman", Font.BOLD, 14));
			addUserButton = new JButton("Submit");
			backButton = new JButton("Back");
		
			//Setting bounds to labels on panels
			frame.add(CCpanel);
			CCpanel.setLayout(null);
			instructions.setBounds(10, 10, 620, 35);
			CCpanel.add(instructions);
			
			fName.setBounds(190, 50, 100, 25);
			fNField.setBounds(300, 50, 155, 25);
			CCpanel.add(fName);
			CCpanel.add(fNField);
			
			lName.setBounds(190, 90, 100, 25);
			lNField.setBounds(300, 90, 155, 25);
			CCpanel.add(lName);
			CCpanel.add(lNField);
			
			pNum.setBounds(190, 130, 100, 25);
			pNumField.setBounds(300, 130, 155, 25);
			CCpanel.add(pNum);
			CCpanel.add(pNumField);
			
			email.setBounds(190, 170, 100, 25);
			emailField.setBounds(300, 170, 155, 25);
			CCpanel.add(email);
			CCpanel.add(emailField);
			
			username.setBounds(190, 210, 100, 25);
			userNameField.setBounds(300, 210, 155, 25);
			CCpanel.add(username);
			CCpanel.add(userNameField);
			
			password.setBounds(190, 250, 100, 25);
			passwordField.setBounds(300, 250, 155, 25);
			CCpanel.add(password);
			CCpanel.add(passwordField);
			
			//Add User Button
			addUserButton= new JButton("Add User");
		    CCpanel.add(addUserButton);
		    ActionListener listener = new AddUserListener();
		    addUserButton.addActionListener(listener);
		    addUserButton.setBounds(190, 320, 100, 25);
		      
		    //Back Button
			backButton = new JButton("Back");
			CCpanel.add(backButton);
			ActionListener listener1 = new BackListener();
			backButton.addActionListener(listener1);
			backButton.setBounds(355, 320, 100, 25);
			
			frame.setVisible(true);
			}
		
		// implement results
		public class AddUserListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				List<CloudController> adminList = FileReader.CloudController("SavedInfo/CloudControllerInfo.txt");
				for (CloudController controller: adminList) {
					if (controller.getUserName().equals(userNameField.getText()))
					{
						System.out.println("Username already in use!");
						return;
					}
				}
				
				String fN = fNField.getText();
				String lN = lNField.getText();
				String phoneN = pNumField.getText();
				String email = emailField.getText();
				String username = userNameField.getText();
				String password = passwordField.getText();
				Timestamp time = new Timestamp(System.currentTimeMillis());
				
				CloudController user = new CloudController(fN, lN, phoneN, email, username, password);
				//SQLDataConnection.insertCloudControllerSQL(user);
				
				//-------------------------------------------------------------------------------------------------------
				// This portion of the code creates and implements a file printer that stores client information in a file	
				adminFile.getParentFile().mkdirs(); // use getParentFile().mkdirs() to have location where file is stored created
				// automatically if it does not exist
				
				// catch exception when printing into file
				try
				{
					PrintWriter fileWriter = new PrintWriter(new FileWriter (adminFile, true)); //create writer
					fileWriter.println();
					fileWriter.print(fN + ","); 
					fileWriter.print(lN+ ","); // get information inputed into program and print into file
					fileWriter.print(phoneN+ ",");
					fileWriter.print(email+ ",");
					fileWriter.print(username+ ",");
					fileWriter.print(password+ ",");
					fileWriter.print(time+ ",");
					fileWriter.flush();
					fileWriter.close(); //flush and close writer
					System.out.println("Cloud Controller information saved"); // print into console when info was saved into file
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
				JOptionPane.showMessageDialog(CCpanel, "The information you entered has been successfully stored.");
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
	
	public static void main(String[] args)
	{
			new CloudController();
	}
}
