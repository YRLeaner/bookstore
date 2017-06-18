package action;

import entity.Students;
import service.StudentsDao;
import serviceimp.StudentsDaoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by tyr on 2017/5/27.
 */
public class StudentsAction extends SuperAction {

    private static final long serialVersionUID = 1L;

    public String query(){
        StudentsDao sdao = new StudentsDaoImpl();
        List<Students> list = sdao.quertAllStudents();

        if (list!=null&&list.size()>0){
            session.setAttribute("students_list",list);
        }
        return "query_success";
    }

    public String delete(){
        StudentsDao sdao = new StudentsDaoImpl();
        String sid = request.getParameter("sid");
        sdao.deleteStudents(sid);
        return "delete_success";
    }

    public String add() throws Exception{
        String sname = this.request.getParameter("sname");
        String gender = this.request.getParameter("gender");
        //String birthday = this.request.getParameter("birthday");
        String address = this.request.getParameter("address");
        String password = this.request.getParameter("password");
        Students s = new Students();
        s.setSname(sname);
        s.setGender(gender);
        s.setAddress(address);
       /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(birthday);*/
        s.setBirthday(new Date());
        StudentsDao sdao = new StudentsDaoImpl();
        sdao.addStudents(s);
        return "add_success";
    }

    public String modify(){
        String sid = request.getParameter("sid");
        StudentsDao sdao = new StudentsDaoImpl();
        Students s = sdao.queryStudentsBySid(sid);
        session.setAttribute("modify_students",s);
        return "modify_success";
    }

    public String save()throws Exception{
        Students s = new Students();
        s.setSid(request.getParameter("sid"));
        s.setSname(request.getParameter("sname"));
        s.setGender(request.getParameter("gender"));
        s.setAddress(request.getParameter("address"));
        s.setPassword(request.getParameter("password"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(request.getParameter("birthday"));
        s.setBirthday(date);
        StudentsDao sdao = new StudentsDaoImpl();
        sdao.updateStudents(s);
        return "save_success";
    }



}
