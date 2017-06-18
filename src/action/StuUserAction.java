package action;

import com.opensymphony.xwork2.ModelDriven;
import entity.Students;
import service.StuUserDao;
import serviceimp.StuUserDaoImpl;

/**
 * Created by tyr on 2017/5/30.
 */
public class StuUserAction extends SuperAction implements ModelDriven<Students>{

    private static final long serialVersionUID = 1L;
    private Students user = new Students();


    public String login(){
        StuUserDao udao = new StuUserDaoImpl();


        if (udao.usersLogin(user)){
            //session中保存用户名
            System.out.print(user.getSid());
            session.setAttribute("loginsStuUserName",user.getSid());
            session.setAttribute("loginPassword",user.getPassword());
            return "login_success";
        }else {
            System.out.print("wrong");
            return "login_failure";
        }
    }

    @Override
    public Students getModel() {
        return this.user;
    }
}
