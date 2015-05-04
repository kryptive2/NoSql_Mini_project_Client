import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Mpho Makalancheche
 *Class to handle the http connection from the Api
 *
 */
public class httpClient {

	/**
	 * @param text: the text to send to the server
	 * @param serverName: server name to connect to
	 * @param port: port from the server
	 * @return the message from the server
	 */
	public String Run(String text, String serverName, int port) {
		try {
			System.out.println("Connecting to " + serverName + " on port "
					+ port);

			@SuppressWarnings("resource")
			Socket client = new Socket(serverName, port);
			System.out.println("Just connected to "
					+ client.getRemoteSocketAddress());
			
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			out.write((text.getBytes()));
			out.flush();
			
			InputStream inFromServer = client.getInputStream();
			
			//DataInputStream in = new DataInputStream(inFromServer);
			BufferedReader in = new BufferedReader(new InputStreamReader(inFromServer));

			return in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
