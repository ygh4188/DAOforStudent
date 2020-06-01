import java.sql.ResultSet;

import org.junit.Test;
import java.util.Scanner;
import bean.Student;
import connection.DataBaseConnection;
import daoIMP.StudentDAOIMP;

public class TestStudentDAO {
	
	@Test
	public void Insert() {
		Student s = new Student();
		
		DataBaseConnection dbcon = new DataBaseConnection();
		dbcon.getConnection();
		
		StudentDAOIMP sdIMP = new StudentDAOIMP();
		s.setiD(1012);
		s.setName("123");
		sdIMP.insert(s);
		try{
			dbcon.close();
			System.out.println("操作成功！");
		}
		catch(Exception e) {
			System.out.println("数据库关闭失败！");
		}
		
	}
	/*
	@Test
	public void Delete() {
		
		DataBaseConnection dbcon = new DataBaseConnection();
		dbcon.getConnection();
		
		Student s = new Student();
		StudentDAOIMP sdIMP = new StudentDAOIMP();
		
		s.setiD(1011);
		
		sdIMP.delete(s);
		try{
			dbcon.close();	
		}
		catch(Exception e) {
			System.out.println("数据库关闭失败！");
		}
	}
	*/
	
	@Test
	public void Delete() {
		DataBaseConnection dbcon = new DataBaseConnection();
		dbcon.getConnection();
		
		StudentDAOIMP sdIMP = new StudentDAOIMP();
		System.out.println("输入iD号：");
		Scanner sc = new Scanner(System.in);
		String iD = sc.next();
		sdIMP.delete(iD);
		
		try{
			dbcon.close();
			System.out.println("操作成功！");
		}
		catch(Exception e) {
			System.out.println("数据库关闭失败！");
		}
	}
	@Test
	public void Update() {
		DataBaseConnection dbcon = new DataBaseConnection();
		dbcon.getConnection();
		
		Student s = new Student();
		
		StudentDAOIMP sdimp = new StudentDAOIMP();
		
		s.setiD(1010);
		s.setName("尹国辉");
		sdimp.update(s);
		
		try{
			dbcon.close();	
			System.out.println("操作成功！");
		}
		catch(Exception e) {
			System.out.println("数据库关闭失败！");
		}
	}
	
	@Test
	public void findAll() {
		DataBaseConnection dbcon = new DataBaseConnection();
		dbcon.getConnection();
			
		StudentDAOIMP sdimp = new StudentDAOIMP();
		sdimp.findAll();
		try{
			dbcon.close();	
			System.out.println("操作成功！");
		}
		catch(Exception e) {
			System.out.println("数据库关闭失败！");
		}
	}
	
	@Test
	public void findByID() {
		DataBaseConnection dbcon = new DataBaseConnection();
		dbcon.getConnection();
		
		StudentDAOIMP sdimp = new StudentDAOIMP();
		System.out.println("输入iD号：");
		Scanner sc = new Scanner(System.in);
		long iD = sc.nextLong();
		sdimp.findByID(iD);
		
		try{
			dbcon.close();
			System.out.println("操作成功！");
		}
		catch(Exception e) {
			System.out.println("数据库关闭失败！");
		}
	}
}
