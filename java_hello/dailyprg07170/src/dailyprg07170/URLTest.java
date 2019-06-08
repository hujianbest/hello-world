package dailyprg07170;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	public static void main(String[] args) 
	throws Exception{
		URL url = new URL("https://blog.csdn.net/whut2010hj");
		String source = url.getFile();
		System.out.println(source);
		InputStream inputStream = url.openStream();
		URLConnection urlConnection = url.openConnection();
		
	}

}
