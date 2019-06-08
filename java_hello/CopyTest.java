import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String oldfilepath = "E:\\迅雷下载\\神盾局特工.Marvels.Agents.of.S.H.I.E.L.D.S05E04.中英字幕.HDTVrip.720P-人人影视.mp4";
        String newfilepath = "E:\\迅雷下载\\java-copy.mp4";
        try (FileInputStream oldfis = new FileInputStream(oldfilepath);
            FileOutputStream newfos = new FileOutputStream(newfilepath)) {
            int len = oldfis.available();
            long sum = 0;
            byte[] bbuf = new byte[1024];
            int hasRead = 0;
            while ((hasRead = oldfis.read(bbuf)) != -1) {
                sum+=hasRead;
                newfos.write(bbuf, 0, hasRead);
                System.out.println("已完成"+sum*1.0/len*100+" %");
            }
            long endTime = System.currentTimeMillis();
            long spentTime=(endTime-startTime)/1000;
            System.out.println("复制完成,耗时："+spentTime+"s");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}