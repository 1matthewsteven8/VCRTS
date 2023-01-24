import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage implements ActionListener {
	
	public static String currentState = "";
	
	// main method to run WelcomePage
	public static void main(String[] args)
	{
		// SystemFrame systemFrame = new SystemFrame();
		WelcomePage welcomePage = new WelcomePage();
	}

	// set bounds for GUI
	final int FrameWidth = 620;
	final int FrameHeight = 400;

	// access modifier for variables/constructors
	private JButton register, login;
	private JLabel labelOption, label1, labelHeader, image1, imageLabel;
	private JPanel panel;
	private JComboBox list;

	// initialize JFrame
	JFrame frame = new JFrame();

	// set parameters of JFrame
	public WelcomePage() {
		frame.setSize(FrameWidth, FrameHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setResizable(false);
		frame.setTitle("Vehicular Cloud Real-Time System");

		// welcome label parameters
		label1 = new JLabel("Welcome to the");
		label1.setBounds(145, 0, 375, 60);
		label1.setFont(new Font("Calibri", Font.ITALIC, 14));

		labelHeader = new JLabel("Vehicular Cloud Real-Time System!");
		labelHeader.setBounds(145, 27, 500, 60);
		labelHeader.setFont(new Font("Calibri", Font.BOLD, 25));

		// label option parameters
		labelOption = new JLabel("Choose an option below to continue:");
		labelOption.setBounds(190, 125, 500, 30);
		labelOption.setFont(new Font("Calibri", Font.PLAIN, 14));

		// image Logo
		image1 = new JLabel("");
		image1.setIcon(new ImageIcon("Images/cloudImage.png"));
		image1.setBounds(0, 0, 150, 150);
		imageLabel = new JLabel("VCRTS");
		imageLabel.setBounds(42, 105, 100, 100);
		imageLabel.setFont(new Font("Calibri", Font.BOLD, 20));

		RegisterButton();
		loginButton();
		createPanel();

		String[] options = { "Vehicle Owner", "Client", "Cloud Controller" };
		list = new JComboBox(options);
		list.setBounds(230, 160, 180, 40);
		panel.add(list);
		panel.add(register);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	// Create Register Button
	
	// register.setBounds(160, 190, 140, 25);
	
	public void RegisterButton()
	{
		register = new JButton("Register");// setting title & bounds of button
		register.setBounds(160, 240, 140, 25);
		register.addActionListener(this);
	}
	
	// Create Login Button
	public void loginButton()
	{
		login = new JButton("Login");
		login.setBounds(340, 240, 140, 25);
		ActionListener listener1 = new loginListener(); 
		login.addActionListener(listener1);
	}
	
	public class loginListener implements ActionListener {
		 public void actionPerformed(ActionEvent event)
		 {
			 if (list.getSelectedItem().equals("Vehicle Owner"))
			 {
				 currentState = "owner";
				 frame.dispose();
				 System.out.println("Vehicle Owner was selected");
			 }
			 else if (list.getSelectedItem().equals("Client"))
			 {
				 currentState = "client";
				 frame.dispose();
				 System.out.println("Client was selected");
			 }
			 else if (list.getSelectedItem().equals("Cloud Controller"))
			 {
				 currentState = "controller";
				 frame.dispose();
				 System.out.println("Cloud Controller was selected");
			 }
			 
			 new Login();
		 }
	}
	
	// panel that displays each attribute to GUI
	private void createPanel() {
		panel = new JPanel();
		panel.add(register);
		panel.add(login);
		panel.add(imageLabel);
		panel.setLayout(null);
		panel.add(labelHeader);
		panel.add(label1);
		panel.add(labelOption);
		panel.add(image1);
		panel.setBackground(new Color(0x7f91fb));
		frame.add(panel);
	}
 
	// linking the client & owner buttons to the welcomePage
	public void actionPerformed(ActionEvent e) {
		if (list.getSelectedItem().equals("Vehicle Owner"))
		{
			currentState = "owner";
			frame.dispose();
			new VehicleOwner().new vehicleOwnerPanel();
			System.out.println("Vehicle Owner was selected");
		}
		else if (list.getSelectedItem().equals("Client"))
		{
			currentState = "client";
			frame.dispose();
			new Client();
			System.out.println("Client was selected");
		}
		else if (list.getSelectedItem().equals("Cloud Controller"))
		{
			currentState = "controller";
			frame.dispose();
			new CloudController();
			System.out.println("Cloud Controller was selected");
		}
	} 
}
