import java.io.*; 
import java.net.*;
import java.util.Scanner; 

public class Sender {
	int winSize;
	int maxSeq;
	int[] window;
	
	
	public Sender(int window, int seq, int[] Window){
		
	}
	
	public void receive() throws IOException{
		System.out.println("Whatss");
		DatagramSocket receiverSocket = new DatagramSocket(9879);
		byte[] rcvData = new byte[1024];
		
		while (true) {
			DatagramPacket rcvPkt = new DatagramPacket(rcvData, rcvData.length);
			receiverSocket.receive(rcvPkt);
			String message = new String(rcvPkt.getData());
			InetAddress IPAddress = rcvPkt.getAddress();
			int port = rcvPkt.getPort();
			System.out.println("Ack ="+message);
			
		    
		}
	}
	public void send() throws IOException{
		
		DatagramSocket senderSocket = new DatagramSocket(9877);//create socket for sending
		InetAddress IPAddress = InetAddress.getByName("localhost");//get local ip address
		byte[] sendData = new byte[1024];//allocate message space
		String message = new String("Success!");
		sendData = message.getBytes();
		DatagramPacket sendPkt = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
		senderSocket.send(sendPkt);
		senderSocket.send(sendPkt);
		senderSocket.send(sendPkt);
		senderSocket.send(sendPkt);
		senderSocket.send(sendPkt);
		senderSocket.send(sendPkt);
		senderSocket.send(sendPkt);
		senderSocket.send(sendPkt);
		senderSocket.send(sendPkt);
		receive();
		
	}

	public static void main(String[] args) throws IOException {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the window's size on the sender:");
		int tWin = reader.nextInt();
		System.out.println("Enter the maximum sequence number on the sender:");
		int tSeq = reader.nextInt();
		System.out.println("Select the packet(s) that will be dropped:");
		System.out.println(tWin);
		System.out.println(tSeq);
		int[] test = {1, 2, 3};
		Sender sender = new Sender(1, 2, test);
		sender.send();
		
		

	}

}
