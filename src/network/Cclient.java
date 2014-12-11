package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("200.1.4.224",2500);
			DataOutputStream dopS = new DataOutputStream(socket.getOutputStream());
			dopS.writeUTF("");
			DataInputStream dipS = new DataInputStream(socket.getInputStream());
			System.out.println(dipS.readUTF());
			socket.close();
		} catch (UnknownHostException e) {
		} catch (IOException e) {	
		}	

	}

}
