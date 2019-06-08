package commom;  
  
import java.io.File;    
import java.io.FileNotFoundException;    
import java.io.FileOutputStream;    
import java.io.IOException;    
import java.io.OutputStream;    
import java.net.SocketException;    

import org.apache.commons.net.ftp.*; 

public class FTPUtil{
    public static FTPClient getFTPClient(String ftpHost, String ftpUserName,  
            String ftpPassword, int ftpPort) {  
        FTPClient ftpClient = new FTPClient();  
        try {  
            ftpClient = new FTPClient();  
            ftpClient.connect(ftpHost, ftpPort);// 连接FTP服务器  
            ftpClient.login(ftpUserName, ftpPassword);// 登陆FTP服务器  
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {  
                System.out.println("未连接到FTP，用户名或密码错误。"); 
                ftpClient.disconnect();  
            } else {  
                System.out.println("FTP连接成功。");  
            }  
        } catch (SocketException e) {  
            e.printStackTrace();  
            System.out.println("FTP的IP地址可能错误，请正确配置。");  
        } catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("FTP的端口错误,请正确配置。");  
        }  
        return ftpClient;  
    }

    public static void downloadFtpFile(String ftpHost, String ftpUserName,  
        String ftpPassword, int ftpPort, String ftpPath, String localPath,  
        String fileName) {  
  
        FTPClient ftpClient = null;  
  
        try {  
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);  
            ftpClient.setControlEncoding("UTF-8"); // 中文支持  
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);  
            ftpClient.enterLocalPassiveMode();  
            ftpClient.changeWorkingDirectory(ftpPath);  
  
            File localFile = new File(localPath + File.separatorChar + fileName);  
            OutputStream os = new FileOutputStream(localFile);  
            ftpClient.retrieveFile(fileName, os);  
            os.close();  
            ftpClient.logout();  
  
        } catch (FileNotFoundException e) {  
            System.err.println("没有找到" + ftpPath + "文件");  
            e.printStackTrace();  
        } catch (SocketException e) {  
            System.err.println("连接FTP失败.");  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
            System.err.println("文件读取错误。");  
            e.printStackTrace();  
        }  
  
    }  

    public static void main(String[] args) {
        String ftpHost = "dygodj8.com";  
        String ftpUserName = "d";  
        String ftpPassword = "d";  
        int ftpPort = 12311;  
        String ftpPath = "/[电影天堂www.dy2018.com]机器之血HD高清国语中英双字.mp4";  
        String localPath = ".";  
        String fileName = "机器之血HD高清国语中英双字.mp4";  
        FTPUtil.downloadFtpFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, localPath, fileName);  
    }
}

