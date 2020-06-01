package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	
    private final String DBDriver ="com.mysql.jdbc.Driver";
    private final String DBURL ="jdbc:mysql://localhost:3306/ygh?characterEncoding=utf8";
    private final String DBUSER ="root";
    private final String DBPASSWORD ="root";
    private Connection conn = null;
//构造器
    public DataBaseConnection(){
       try{
           Class.forName(DBDriver);
           conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
           System.out.println("Success loading Mysql Driver!");
           }
        catch(Exception e){
        	System.out.println("加载MYsql Driver 失败！");
       }
                                 
    }

//获得连接
	public Connection getConnection(){
		return this.conn; 
		}
	
//关闭连接
	public void close() throws SQLException{
	    this.conn.close(); 
	    }
}
