package daoIMP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import bean.Student;
import connection.DataBaseConnection;

public class StudentDAOIMP {


	// 添加操作
    public void insert(Student s){
    String sql = "INSERT INTO student (id, name) values (?,?)";
    PreparedStatement pstmt = null;
    DataBaseConnection conn = null;
    //针对数据库的具体操作
    try{
        conn = new DataBaseConnection();
        
        pstmt = conn.getConnection().prepareStatement(sql);
        pstmt.setLong(1,s.getiD());
        //pstmt.setString(1,s.getID());
        pstmt.setString(2,s.getName());
  
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        }
     catch(Exception e){  }
      }

    public void update(Student s){
    String sql = "UPDATE student SET name =? Where id = ? ";
    PreparedStatement pstmt = null;
    DataBaseConnection conn = null;
    //针对数据库的具体操作
    try{
        conn = new DataBaseConnection();
        pstmt = conn.getConnection().prepareStatement(sql);
        pstmt.setString(1,s.getName());
        pstmt.setLong(2,s.getiD());
  
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        }
     catch(Exception e){ }
    

    }

//public void delete(String iD){}//作业1
/*    public void delete(Student s) {
	    String sql = "DELETE FROM licong.student WHERE iD = ?;";
	    PreparedStatement pstmt = null;
	    DataBaseConnection conn = null;
	    //针对数据库的具体操作
	    try{
	        conn = new DataBaseConnection();
	        pstmt = conn.getConnection().prepareStatement(sql);
	        
	        pstmt.setLong(1,s.getiD());
	        
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	        }
	     catch(Exception e){ 
	    	 
	     }	
    }
*/   
    public void delete(String iD) {
	    String sql = "DELETE FROM shiyan.student WHERE iD = ?;";
	    PreparedStatement pstmt = null;
	    DataBaseConnection conn = null;
	    //针对数据库的具体操作
	    try{
	        conn = new DataBaseConnection();
	        pstmt = conn.getConnection().prepareStatement(sql);      
	        pstmt.setString(1, iD);
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	        }
	     catch(Exception e){ 
	    	 
	     }	
    }
//public List findAll(){}//作业2
    public List<Student> findAll() {
	    String sql = "SELECT * FROM shiyan.student;";
	    
	    List<Student> list = new ArrayList<Student>();
	    
	    PreparedStatement pstmt = null;
	    DataBaseConnection conn = null;
	    ResultSet rs = null;
	    Student st = null;
	    //针对数据库的具体操作
	    try{
	        conn = new DataBaseConnection();
	        pstmt = conn.getConnection().prepareStatement(sql);  
	        rs = pstmt.executeQuery();	        
	        while(rs.next())
	        {
	        	st = new Student();
	        	st.setiD(rs.getLong(1));
	        	st.setName(rs.getString(2));
//	        	System.out.println(st.getiD()+" "+st.getName());
	        	list.add(st);
	        }
	        ListIterator<Student> iter = list.listIterator();
	        while(iter.hasNext())
	        {
	        	System.out.println(iter.next());
	        }
	        rs.close();
	        pstmt.close();
	        conn.close();
	        }
	     catch(Exception e){  
	     }
		return list;
    }


	public Student findByID(long iD){ 
		Student student = null;
		String sql = "SELECT id, name FROM student Where id = ? ";
		PreparedStatement pstmt = null;
		DataBaseConnection conn = null;
		//针对数据库的具体操作
	    try{
	        conn = new DataBaseConnection();
	        pstmt = conn.getConnection().prepareStatement(sql);
	        pstmt.setLong(1, iD);
	        ResultSet rs = pstmt.executeQuery();
	  
	        if(rs.next()){
				student = new Student();
				student.setiD(rs.getLong(1));
				student.setName(rs.getString(2));
			}
	        System.out.println(student.getName());
			rs.close();
			pstmt.close();
			conn.close();
	        }
	     catch(Exception e){ }
	
	     return student;
	}
}
