import java.io.BufferedReader; 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;


public class CCServer {

	static ServerSocket serverSocket;
	static Socket ServerSocket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;
	
	public static void main(String[] args) throws IOException {
		
		
		ServerSocket ss = new ServerSocket (4999);
		
		Socket socket = ss.accept();
		
		System.out.println("Client connected");
		InputStreamReader inreader = new InputStreamReader(socket.getInputStream());
		BufferedReader br = new BufferedReader(inreader);
		
		String tempStr = br.readLine();
		
		PrintWriter ccwriter = new PrintWriter(socket.getOutputStream());
		
		if (tempStr != null){
				int  result = JOptionPane.showConfirmDialog(new HomePage().new CloudControllerHome().getCcHome(),"Accept new request?", "Incoming request",JOptionPane.YES_NO_OPTION);
				if (result == 0) {
					tempStr = "yes";
					ccwriter.println(tempStr);
				}
				else if (result == 1){
					tempStr = "no";
					ccwriter.println(tempStr);
				}
		}
		else {
			System.out.println("Server malfunction");
		}
		System.out.println("Client: "+tempStr);
		
		
		
		
		ccwriter.flush();
	}
	
}
