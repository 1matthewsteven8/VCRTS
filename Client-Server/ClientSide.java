package serverTest;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class ClientSide {
	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;

	public static void main(String[] args) {
		String messageIn = "";
		String messageOut = "";
		Scanner keyInput;

		try {
			System.out.println(" ------ ** This is Client Side ** ------");
			System.out.println("client started!");
			// connect the client socket to server
			Socket socket = new Socket("localhost", 9806);

			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());

			System.out.println("Press any key to initate job request ");

			keyInput = new Scanner(System.in);
			messageOut = keyInput.nextLine();
			outputStream.writeUTF(messageOut);

			while (!messageIn.equals("exit")) {
				messageIn = inputStream.readUTF();

				System.out.println("Message received from server: " + "\"" + messageIn + "\"");

				System.out.println("Press any key to initiate job request ");
				keyInput = new Scanner(System.in);
				messageOut = keyInput.nextLine();
				outputStream.writeUTF(messageOut);

				if (messageIn.equals("reject")) {
					System.out.println("Sorry this job has been rejected");
				} else if (messageIn.equals("accept")) {
					System.out.println("Congrats the Vehicle Controller has accepted this job");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
