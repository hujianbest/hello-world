package dailyprg07170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	public static void main(String[] args) 
	throws IOException{
		Socket socket = new Socket("127.0.0.1",3000);
		BufferedReader bufferedReader = new BufferedReader(
			new InputStreamReader(socket.getInputStream())
		);
		String line = bufferedReader.readLine();
		System.out.println("服务器发送来消息："+line);
		bufferedReader.close();
		socket.close();
	}
}
