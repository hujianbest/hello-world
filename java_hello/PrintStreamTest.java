import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest{
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("text.txt");
        PrintStream ps = new PrintStream(fos)){
            ps.println("ÆÕÍ¨×Ö·û´®");
            ps.println(new PrintStream(fos));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}