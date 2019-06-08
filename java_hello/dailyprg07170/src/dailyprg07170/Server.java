package dailyprg07170;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) 
        throws IOException{
        ServerSocket serverSocket = new ServerSocket(3000);
        while(true){
            Socket socket = serverSocket.accept();
            PrintStream  printStream = new PrintStream(socket.getOutputStream());
            printStream.println("你已连接上服务器");
            printStream.close();
            socket.close();
        }
    }
}


// import java.net.InetAddress;

// public class Test {
//     public static void main(String[] args) 
//         throws Exception{
//         InetAddress ip = InetAddress.getByName("www.hujianbest.cn");
//         System.out.println(ip.getHostAddress());
//     }
// }