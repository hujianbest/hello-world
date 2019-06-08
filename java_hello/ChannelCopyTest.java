import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopyTest{
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        File f = new File("E:\\Ѹ������\\��ܾ��ع�.Marvels.Agents.of.S.H.I.E.L.D.S05E04.��Ӣ��Ļ.HDTVrip.720P-����Ӱ��.mp4");
        try(FileChannel iChannel = new FileInputStream(f).getChannel();
        FileChannel outChannel = new FileOutputStream("E:\\Ѹ������\\java-channel-copy.mp4").getChannel()){
            MappedByteBuffer buffer = iChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            outChannel.write(buffer);
            long endTime = System.currentTimeMillis();
            long spentTime=(endTime-startTime)/1000;
            System.out.println("�������,��ʱ��"+spentTime+"s");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}