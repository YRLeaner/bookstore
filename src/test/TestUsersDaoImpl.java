package test;

import entity.Users;
import org.junit.Assert;
import org.junit.Test;
import service.UserDao;
import serviceimp.UsersDaoImpl;

/**
 * Created by tyr on 2017/5/27.
 */
public class TestUsersDaoImpl {
    @Test
    public void testUsersLogin(){
        Users users = new Users(1,"zhangsan","123456");
        UserDao udao = new UsersDaoImpl();
        Assert.assertEquals(true,udao.usersLogin(users));
    }
}
