package httpClientandJsoup;
//�������ݿ�
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

	
	public Connection getConn() {  
        String driver = "com.mysql.jdbc.Driver";  
        String url = "jdbc:mysql://localhost:3306/how2java?characterEncoding=UTF-8";  
        String username = "root";  
        String password = "admin";  
        Connection conn = null;  

        try {  
            Class.forName(driver); // 
            conn = (Connection) DriverManager.getConnection(url, username, password);  

            System.out.println("���ݿ����ӳɹ�");

        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  

        return conn;  
	}
}
