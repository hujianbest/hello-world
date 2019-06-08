import java.net.InetAddress;

public class InetAddressTest{
    public static void main(String[] args) throws Exception {
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        System.out.println("baidu是否可达："+ ip.isReachable(2000));
        System.out.println(ip.getHostAddress());
        InetAddress local = InetAddress.getByAddress(new byte[] {(byte)10,(byte)139,(byte)23,(byte)194});
        System.out.println("本机是否可达："+ local.isReachable(5000));
        System.out.println(local.getCanonicalHostName());
    }
}