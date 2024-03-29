import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main extends JPanel {

    private BufferedImage mImg;


    // mat to buffered image
    private BufferedImage mat2BI(Mat mat) {
        int dataSize = mat.cols() * mat.rows() * (int) mat.elemSize();
        byte[] data = new byte[dataSize];
        mat.get(0, 0, data);
        int type = mat.channels() == 1 ?
                BufferedImage.TYPE_BYTE_GRAY : BufferedImage.TYPE_3BYTE_BGR;

        if (type == BufferedImage.TYPE_3BYTE_BGR) {
            for (int i = 0; i < dataSize; i += 3) {
                byte blue = data[i + 0];
                data[i + 0] = data[i + 2];
                data[i + 2] = blue;
            }
        }
        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
        image.getRaster().setDataElements(0, 0, mat.cols(), mat.rows(), data);

        return image;
    }

    public void paintComponent(Graphics g) {
        if (mImg != null) {
            g.drawImage(mImg, 0, 0, mImg.getWidth(), mImg.getHeight(), this);
        }
    }

    public static void main(String[] args) {

        try {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        JFrame frame = new JFrame("Camera");
        VideoCapture capture = new VideoCapture(0);//参数为0时打开摄像头
//        capture.set(3, 1080);//宽度
//        capture.set(4, 960);//高度
//        capture.set(5, 30);//帧率 帧/秒

        try {
            Mat capImg = new Mat();//opencv 图像处理封装类
            int height = (int) capture.get(Videoio.CAP_PROP_FRAME_HEIGHT);
            int width = (int) capture.get(Videoio.CAP_PROP_FRAME_WIDTH);
            if (! capture.isOpened()) {
                throw new Exception("Camera not found!");
            }
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Main panel = new Main();

            frame.setContentPane(panel);
            frame.setVisible(true);
            frame.setSize(width + frame.getInsets().left + frame.getInsets().right,
                    height + frame.getInsets().top + frame.getInsets().bottom);
//            Mat grayImg = new Mat();
            while (frame.isShowing() ) {
                capture.read(capImg);//输出到mat
//                Imgproc.cvtColor(capImg, grayImg, Imgproc.COLOR_RGB2GRAY);//彩色空间转换，grayImg为目标mat
                //Imgcodecs.imwrite("G:/opencv/lw/neg/back"+n+".png", grayImg);
                panel.mImg = panel.mat2BI(detectFace(capImg));
                panel.repaint();
            }
        } catch (Exception e) {
            System.out.println("异常：" + e);
        } finally {
            capture.release();
            frame.dispose();
            System.out.println("--done--");
        }

    }

    /**
     * opencv实现人脸识别
     *
     * @param img
     */
    public static Mat detectFace(Mat img) throws Exception {

//        System.out.println("Running DetectFace ... ");
        // 从配置文件lbpcascade_frontalface.xml中创建一个人脸识别器，该文件位于opencv安装目录中
        CascadeClassifier faceDetector = new CascadeClassifier("D:\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");


        // 在图片中检测人脸
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(img, faceDetections);

        //System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

        Rect[] rects = faceDetections.toArray();
        if (rects != null && rects.length >= 1) {
            for (Rect rect : rects) {
                Imgproc.rectangle(img, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 2);
            }
        }
        return img;
    }

}