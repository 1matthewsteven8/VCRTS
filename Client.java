import java.awt.Color; 
import java.awt.Font;
import java.awt.Window;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

import java.sql.Connection;
import java.sql.Timestamp;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends User {
	
	private String userN;
	private String password;
	
	public Client(String firstName, String lastName, String phoneNumber, String email, String userName, String password)
	{  
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
		this.userN = userName; 
		this.password = password;
	}
	
	public String getUsername()
	{
		return userN;
	}

	public void setUsername(String username)
	{
		this.userN = username;
	}

	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String toString()
	{
		String output = "\n First Name: " + this.getFirstName()+ "\n Last Name: " + this.getLastName()
		+ "\n Phone Number: " + this.getPhoneNumber() + "\n Email: " + this.getEmail() + "\n Username: "
		+ this.getUsername() + "\n Password: " + password ;
		return output;
	}
	
	File clientFile = new File("SavedInfo/ClientInfo.txt");
	
	private JFrame frame;
	private JPanel clientpanel;
	private JLabel instructions,fName, lName, pNum, email, userName, passWord;
	private JTextField fNField, lNField,pNumField, emailField, userNameField, passwordField;
	private JButton addUserButton, backButton;

	public Client()
	{
		//Frame features
		frame = new JFrame();
		clientpanel = new JPanel();
		frame.setSize(620, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("Client Registration");
		clientpanel.setBackground(new Color(176,116,214));
		instructions = new JLabel("<html>Welcome to Client Registration.</html>", SwingConstants.CENTER);
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
		frame.add(clientpanel);
		clientpanel.setLayout(null);
		instructions.setBounds(10, 10, 620, 35);
		clientpanel.add(instructions);
		
		fName.setBounds(190, 50, 100, 25);
		fNField.setBounds(300, 50, 155, 25);
		clientpanel.add(fName);
		clientpanel.add(fNField);
		
		lName.setBounds(190, 90, 100, 25);
		lNField.setBounds(300, 90, 155, 25);
		clientpanel.add(lName);
		clientpanel.add(lNField);
		
		pNum.setBounds(190, 130, 100, 25);
		pNumField.setBounds(300, 130, 155, 25);
		clientpanel.add(pNum);
		clientpanel.add(pNumField);
		
		email.setBounds(190, 170, 100, 25);
		emailField.setBounds(300, 170, 155, 25);
		clientpanel.add(email);
		clientpanel.add(emailField);
		
		userName.setBounds(190, 210, 100, 25);
		userNameField.setBounds(300, 210, 155, 25);
		clientpanel.add(userName);
		clientpanel.add(userNameField);
		
		passWord.setBounds(190, 250, 100, 25);
		passwordField.setBounds(300, 250, 155, 25);
		clientpanel.add(passWord);
		clientpanel.add(passwordField);
		
		//Add User Button
		addUserButton= new JButton("Add User");
	    clientpanel.add(addUserButton);
	    ActionListener listener = new AddUserListener();
	    addUserButton.addActionListener(listener);
	    addUserButton.setBounds(190, 320, 100, 25);
	      
	    //Back Button
		backButton = new JButton("Back");
		clientpanel.add(backButton);
		ActionListener listener1 = new BackListener();
		backButton.addActionListener(listener1);
		backButton.setBounds(355, 320, 100, 25);
		
		frame.setVisible(true);
		}
	   
	//implement results
	public class AddUserListener implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			List<Client> clientList = FileReader.Client("SavedInfo/ClientInfo.txt");
			for(Client client: clientList)
			{
				if(client.getUsername().equals(userNameField.getText()))
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
			
			Client testClient = new Client (fN,lN,phoneN,email,username,password);
			//SQLDataConnection.insertClientSQL(testClient);
				 
			//-------------------------------------------------------------------------------------------------------
			// This portion of the code creates and implements a file printer that stores client information in a file	
			clientFile.getParentFile().mkdirs(); //use getParentFile().mkdirs() to have location where file is stored created
			// automatically if it does not exist
			
			// catch exception when printing into file
			try
			{
				PrintWriter fileWriter = new PrintWriter(new FileWriter (clientFile, true)); //create writer
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
				System.out.println("Client information saved"); // print into console when info was saved into file
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
			JOptionPane.showMessageDialog(clientpanel, "The information you entered has been successfully stored.");
		
			
			
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

	public static int startClientServer() throws IOException
	{
		ServerSocket serverSocket;
		Socket socket;
		DataInputStream inputStream;
		DataOutputStream outputStream;
		int i = 0;
			
		socket = new Socket ("localhost",4999);
		
			PrintWriter clientwriter = new PrintWriter(socket.getOutputStream());
			
			clientwriter.println("job");
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
			return i;
	}
	public static void main(String[] args)
	{
		Client viewer = new Client();
	}
	
}
