package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Cserver extends Thread {
	int y = 0;
	ServerSocket sS = null; // �ʱⰪ object=null, int=0, String=""

	Cserver(int x) throws Exception { // ������ : ���� �ʱ�ȭ, Ŭ���� = �Ӽ�(��)+�޼ҵ�(�ൿ)
		sS = new ServerSocket(x);
		sS.setSoTimeout(10000);
	}

	public void run() {
		while (true) {

			try {
				Socket socket = sS.accept();
				DataInputStream dipS = new DataInputStream(socket.getInputStream());
				System.out.println(dipS.read());
				DataOutputStream dopS = new DataOutputStream(socket.getOutputStream());
				dopS.writeUTF("Amazing");
				socket.close();
			} catch (SocketTimeoutException e) {
				System.out.println("Grace");
				break;
			} catch (IOException e){
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Cserver cs = new Cserver(2300);
		cs.start();
		

	}

}
