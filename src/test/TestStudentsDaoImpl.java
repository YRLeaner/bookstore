package test;

import entity.Students;
import org.junit.Test;
import service.StudentsDao;
import serviceimp.StudentsDaoImpl;

import java.util.Date;
import java.util.List;

/**
 * Created by tyr on 2017/5/27.
 */
public class TestStudentsDaoImpl {
    @Test
    public void testQueryAllStudents(){
        StudentsDao studentsDao = new StudentsDaoImpl();
        List<Students> list = studentsDao.quertAllStudents();
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    @Test
    public void testAddStudents(){
        Students s = new Students();
        s.setSname("张三");
        s.setGender("男");
        s.setBirthday(new Date());
        s.setAddress("湖北");
        StudentsDao sdao  = new StudentsDaoImpl();
        sdao.addStudents(s);
    }
}
