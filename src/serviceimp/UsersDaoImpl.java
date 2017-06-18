package serviceimp;

import db.MyHibernateSessionFactory;
import entity.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.UserDao;

import java.util.List;

/**
 * Created by tyr on 2017/5/27.
 */
public class UsersDaoImpl implements UserDao {
    @Override
    public boolean usersLogin(Users u) {
        Transaction tx = null;
        String hql="";
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "from Users where username = ? and password = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0,u.getUsername());
            query.setParameter(1,u.getPassword());
            List list = query.list();
            tx.commit();
            if (list.size()>0){
                return true;
            }else {
                return false;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            if (tx!=null){
                //tx.commit();
                tx = null;
            }
        }
    }
}
