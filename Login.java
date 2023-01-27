import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JPasswordField;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Login {

	final int FrameWidth = 620;
	final int FrameHeight = 400;

	// access modifier for variables/constructors
	private JLabel titleFrame, username, password, imageLabel, image1;
	private JPasswordField passwordField;
	private JButton signin, backButton;
	private JPanel panel;
	public static JTextField usernameField;

	// initialize JFrame

	JFrame frame = new JFrame();

	// set parameters of JFrame
	public Login() {
		frame.setSize(FrameWidth, FrameHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setTitle("Vehicular Cloud Real-Time System");

		image1 = new JLabel("");
		image1.setIcon(new ImageIcon("Images/cloudImage.png"));
		image1.setBounds(0, 0, 150, 150);
		imageLabel = new JLabel("VCRTS");
		imageLabel.setBounds(42, 105, 100, 100);
		imageLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		// welcome label parameters
		titleFrame = new JLabel("Sign In");
		titleFrame.setBounds(250, 50, 300, 50);
		titleFrame.setFont(new Font("Times New Roman", Font.BOLD, 35));

		// label option parameters
		username = new JLabel("Username:");
		username.setBounds(150, 130, 100, 30);
		username.setFont(new Font("Times New Roman", Font.BOLD, 16));
		usernameField = new JTextField(15);
		usernameField.setBounds(250, 130, 130, 30);

		// password
		password = new JLabel("Password:");
		password.setBounds(150, 170, 100, 30);
		password.setFont(new Font("Times New Roman", Font.BOLD, 16));
		passwordField = new JPasswordField(15);
		passwordField.setBounds(250, 170, 130, 30);

		// signin button
		signin = new JButton("Sign In"); // setting title & bounds of button
		signin.setBounds(260, 220, 100, 25);
		ActionListener listener = new signInListener();
		signin.addActionListener(listener);
		// signin.addActionListener(listener);

		createPanel();

		backButton = new JButton("Back");
		panel.add(backButton);
		ActionListener listener1 = new BackListener();
		backButton.addActionListener(listener1);
		backButton.setBounds(260, 250, 100, 25);

		frame.setVisible(true);
	}

	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(titleFrame);
		panel.add(username);
		panel.add(usernameField);
		panel.add(password);
		panel.add(passwordField);
		panel.add(signin);
		panel.add(image1);
		panel.add(imageLabel);
		panel.setBackground(new Color(173, 113, 164));
		frame.add(panel);
	}

	public class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JComponent comp = (JComponent) event.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			new WelcomePage();
		}
	}

	// implement results
	public class signInListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String userN = usernameField.getText();
			String password = passwordField.getText();

			if (WelcomePage.currentState.equals("controller")) {

				List<CloudController> adminList = FileReader.CloudController("SavedInfo/CloudControllerInfo.txt");
				for (CloudController controller : adminList) {
					if (controller.getUserName().equals(userN) && controller.getPassword().equals(password)) {
						JComponent comp = (JComponent) event.getSource();
						Window win = SwingUtilities.getWindowAncestor(comp);
						win.dispose();
						new HomePage().new CloudControllerHome();
					}
				}
			}

			if (WelcomePage.currentState.equals("owner")) {
				List<VehicleOwner> ownerList = FileReader.VehicleOwner("SavedInfo/VehicleOwnerInfo.txt");
				for (VehicleOwner owner : ownerList) {
					if (owner.getUsername().equals(userN) && owner.getPassword().equals(password)) {
						JComponent comp = (JComponent) event.getSource();
						Window win = SwingUtilities.getWindowAncestor(comp);
						win.dispose();
						new HomePage().new VehicleOwnerHome();
					}
				}
			}

			if (WelcomePage.currentState.equals("client")) {
				List<Client> clientList = FileReader.Client("SavedInfo/ClientInfo.txt");
				for (Client client : clientList) {
					if (client.getUsername().equals(userN) && client.getPassword().equals(password)) {
						JComponent comp = (JComponent) event.getSource();
						Window win = SwingUtilities.getWindowAncestor(comp);
						win.dispose();
						new HomePage().new ClientHome();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Login page = new Login();
	}
}
