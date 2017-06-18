package service;

import entity.Students;
import java.util.List;

/**
 * Created by tyr on 2017/5/27.
 */
//学生业务逻辑
public interface StudentsDao {

    public List<Students> quertAllStudents();
    public Students queryStudentsBySid(String sid);
    public boolean addStudents(Students s);
    public boolean updateStudents(Students s);
    public boolean deleteStudents(String sid);
}
