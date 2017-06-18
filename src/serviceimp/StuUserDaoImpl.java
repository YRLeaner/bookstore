package serviceimp;

import db.MyHibernateSessionFactory;
import entity.Students;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.StuUserDao;

import java.util.List;

/**
 * Created by tyr on 2017/5/30.
 */
public class StuUserDaoImpl implements StuUserDao {

    @Override
    public boolean usersLogin(Students s) {
        Transaction tx = null;
        String hql="";
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "from Students where sid = ? and password = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0,s.getSid());
            query.setParameter(1,s.getPassword());
            System.out.print(s.getSid()+s.getPassword());
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
