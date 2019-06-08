import java.awt.*;
import javax.swing.*;


public class ImageTest{
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new ImageFrame();
            frame.setTitle("ImageTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ImageFrame extends JFrame{
    public ImageFrame(){
        add(new ImageComponent());
        pack();
    }
}

class ImageComponent extends JComponent{
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 900;

    private Image image;
    public ImageComponent(){
        image = new ImageIcon("img_7.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g){
        if(image==null)  return;
        int imageWidth = image.getWidth(this)/5;
        int imageHeight = image.getHeight(this)/5;

        g.drawImage(image, 0, 0, imageWidth, imageHeight,null,null);
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}