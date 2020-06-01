import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MySQL {
    public static void main(String[]args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序
            //Class.forName("org.gjt.mm.mysql.Driver");
            System.out.println("Success loading Mysql Driver!");
        }
        catch (Exception e) {
            System.out.print("Error loading Mysql Driver!");
            e.printStackTrace();
        }
        try {
            Connection connect = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ygh","root","root");
            //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

            System.out.println("Success connect Mysql server!");
            Statement stmt = (Statement) connect.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from student" );
            //user 为你表的名称
            while (rs.next()) {
                System.out.println(rs.getString("student"));
            }
        }
        catch (Exception e) {
            System.out.print("get data error!");
            e.printStackTrace();
        }
    }
}