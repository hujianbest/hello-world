import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileInputTest {
    public static void main(String[] args) throws IOException {
        FileInputTest fit = new FileInputTest();
        System.out.println("=================\"FileTest.java\"=================");
        fit.inputstreamtest("FileTest.java");
        System.out.println("=================\"FileInputTest.java\"=================");
        fit.readertest("FileInputTest.java");
        fit.copytest("FileInputTest.java", "FileInputTest-copy.java");
    }

    public void inputstreamtest(String filepath) {
        try (FileInputStream fis = new FileInputStream(filepath)) {
            byte[] bbuf = new byte[8];
            int hasRead = 0;
            while ((hasRead = fis.read(bbuf)) != -1) {
                System.out.print(new String(bbuf, 0, hasRead));
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readertest(String filepath) {
        try (FileReader fr = new FileReader(filepath)) {
            char[] cbuf = new char[8];
            int hasRead = 0;
            while ((hasRead = fr.read(cbuf)) != -1) {
                System.out.print(new String(cbuf, 0, hasRead));
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copytest(String oldfilepath, String newfilepath) {
        try (FileInputStream oldfis = new FileInputStream(oldfilepath);FileOutputStream newfos = new FileOutputStream(newfilepath)) {
            byte[] bbuf = new byte[8];
            int hasRead = 0;
            while ((hasRead = oldfis.read(bbuf)) != -1) {
                newfos.write(bbuf, 0, hasRead);
            }
            System.out.println("¸´ÖÆÍê³É");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}