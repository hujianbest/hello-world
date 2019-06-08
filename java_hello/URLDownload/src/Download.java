public class Download {
    public static void main(String[] args) throws Exception {
        final DownUtil downUtil = new DownUtil("http://www.cs.toronto.edu/~hinton/absps/NatureDeepReview.pdf",
                "Deep learning.pdf", 4);
        downUtil.download();
        new Thread(() -> {
            while (downUtil.getDownloadRate() < 1) {
                System.out.println("����ɣ�" + (int)(downUtil.getDownloadRate()*100)+" %");
                try {
                    Thread.sleep(200);
                } catch (Exception ex) {}
            }
            System.out.println("��������ɣ��ļ�����ڣ�"+System.getProperty("user.dir")+"\\Deep learning.pdf");
        }).start();
    }
}