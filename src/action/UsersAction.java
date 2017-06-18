package action;

import com.opensymphony.xwork2.ModelDriven;
import entity.Users;
import org.apache.struts2.interceptor.validation.SkipValidation;
import service.UserDao;
import serviceimp.UsersDaoImpl;

/**
 * Created by tyr on 2017/5/27.
 */
public class UsersAction extends SuperAction implements ModelDriven<Users>{

    private static final long serialVersionUID = 1L;
    private Users user = new Users();


    public String login(){
        UserDao udao = new UsersDaoImpl();
        if (udao.usersLogin(user)){
            //session中保存用户名
            session.setAttribute("loginUserName",user.getUsername());
            return "login_success";
        }else {
            return "login_failure";
        }
    }

    @SkipValidation
    public String logout(){
        if (session.getAttribute("loginUserName")!=null){
            session.removeAttribute("loginUserName");
        }
        return "logout_success";
    }

    @Override
    public void validate() {
        if ("".equals(user.getUsername().trim())){
            this.addFieldError("usernameError","用户名不能为空");
        }
        if (user.getPassword().length()<6){
            this.addFieldError("passwordError","密码长度不小于6位");
        }
    }


    @Override
    public Users getModel() {
        return this.user;
    }
}
