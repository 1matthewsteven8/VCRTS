package serverTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;

	public static void main(String[] args) {
		String messageIn = "";
		String messageOut = "";
		Scanner keyInput;

		try {

			System.out.println("----------$$$ This is server side $$$--------");
			System.out.println("wating for client to connect...");
			// creating the server
			serverSocket = new ServerSocket(9806);

			// sever accepts connection request from client
			socket = serverSocket.accept();
			System.out.println("client is connected!");

			// server reads a message message from client
			inputStream = new DataInputStream(socket.getInputStream());

			// server sends a message to client
			outputStream = new DataOutputStream(socket.getOutputStream());

			// as long as message is not exit keep reading and sending message to client
			while (!messageIn.equals("exit")) {
				// extract the message from client
				messageIn = inputStream.readUTF();
				// server prints the message received from client to console

				System.out.println("Job received from client: " + "\"" + messageIn + "\"");
				// ********************************************************
				// server reads a message from keyboard
				System.out.println("Would you like to accept or reject this job? ");
				keyInput = new Scanner(System.in);
				messageOut = keyInput.nextLine();
				// server sends the message to client
				outputStream.writeUTF(messageOut);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
