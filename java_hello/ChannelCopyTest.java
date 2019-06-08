import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopyTest{
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        File f = new File("E:\\迅雷下载\\神盾局特工.Marvels.Agents.of.S.H.I.E.L.D.S05E04.中英字幕.HDTVrip.720P-人人影视.mp4");
        try(FileChannel iChannel = new FileInputStream(f).getChannel();
        FileChannel outChannel = new FileOutputStream("E:\\迅雷下载\\java-channel-copy.mp4").getChannel()){
            MappedByteBuffer buffer = iChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            outChannel.write(buffer);
            long endTime = System.currentTimeMillis();
            long spentTime=(endTime-startTime)/1000;
            System.out.println("复制完成,耗时："+spentTime+"s");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}