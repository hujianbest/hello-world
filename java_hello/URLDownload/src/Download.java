public class Download {
    public static void main(String[] args) throws Exception {
        final DownUtil downUtil = new DownUtil("http://www.cs.toronto.edu/~hinton/absps/NatureDeepReview.pdf",
                "Deep learning.pdf", 4);
        downUtil.download();
        new Thread(() -> {
            while (downUtil.getDownloadRate() < 1) {
                System.out.println("已完成：" + (int)(downUtil.getDownloadRate()*100)+" %");
                try {
                    Thread.sleep(200);
                } catch (Exception ex) {}
            }
            System.out.println("下载已完成，文件存放在："+System.getProperty("user.dir")+"\\Deep learning.pdf");
        }).start();
    }
}