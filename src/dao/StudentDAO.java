package dao;

import java.util.List;

import bean.Student;

public interface StudentDAO {
    public void insert(Student s);
    public void update(Student s);
    public void delete(String iD);
    public Student findByID(long iD);
    public List<Student> findAll();
}
