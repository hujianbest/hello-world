import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnMySql {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        try(
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hujian_bbs?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "1234");
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery("select *"+" from admin"))
        {
        	while(rs.next()){
        		System.out.println(rs.getString(1)+"\t"
        				+rs.getString(2)+"\t"
        				+rs.getString(3));
        	}
        }
    }
    
}