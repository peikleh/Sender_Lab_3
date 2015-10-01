import java.io.*; 
import java.net.*;
import java.util.Scanner; 
/*This class sends one packet and then listens for an ack respose. If a response is gathered the class will print ACK + message
*/
public class Sender {
	int winSize;
	int maxSeq;
	int[] window;
	
	
	public Sender(int window, int seq, int[] Window){
		
	}
	
	public void receive() throws IOException{
		DatagramSocket receiverSocket = new DatagramSocket(9879);				//create listener socket
		byte[] rcvData = new byte[1024];										//create byte array to put messag in
		
		while (true) {
			DatagramPacket rcvPkt = new DatagramPacket(rcvData, rcvData.length);//create a packet for recieving message
			receiverSocket.receive(rcvPkt);										//stalls here until a packet is received, sets packet to rcvpacket
			String message = new String(rcvPkt.getData());						//set String message to the rcvPkt converted to a string
			InetAddress IPAddress = rcvPkt.getAddress();						//Get reciever IP(Not used)
			int port = rcvPkt.getPort();										//get reciever port(Not Used)
			System.out.println("Ack ="+message);								//print out ack command that was recieved
		}
	}
	public void send() throws IOException{
		
		DatagramSocket senderSocket = new DatagramSocket(9877);								//create socket for sending
		InetAddress IPAddress = InetAddress.getByName("localhost");							//get local ip address
		byte[] sendData = new byte[1024];													//allocate message space
		String message = new String("Success!");											//create string message
		sendData = message.getBytes();														//convert string message into byte array
		DatagramPacket sendPkt = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);//create sender socket with port 9876
		senderSocket.send(sendPkt);                                  						//send packet
	
		receive();																			//start linstening for acks
		
	}

	public static void main(String[] args) throws IOException {
		
		/*Scanner reader = new Scanner(System.in);
		System.out.println("Enter the window's size on the sender:");
		int tWin = reader.nextInt();
		System.out.println("Enter the maximum sequence number on the sender:");
		int tSeq = reader.nextInt();
		System.out.println("Select the packet(s) that will be dropped:");
		System.out.println(tWin);
		System.out.println(tSeq);
		*/
		int[] test = {1, 2, 3};
		
		Sender sender = new Sender(1, 2, test);// create new Sender(Inputs unimportant right now)
		sender.send();							//calls send to make and send packet
		
		

	}

}
