package serviceimp;

import db.MyHibernateSessionFactory;
import entity.Books;
import entity.Orders;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.BooksDao;
import service.OrdersDao;

import java.util.List;

/**
 * Created by tyr on 2017/5/28.
 */
public class OrdersDaoImpl implements OrdersDao {


    @Override
    public List<Orders> quertAllOrders() {
        Transaction tx = null;
        List<Orders> list = null;
        String hql = "";
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "from Orders";
            Query query = session.createQuery(hql);
            list = query.list();
            tx.commit();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            tx.commit();
            return list;
        }finally {
            if (tx!=null){
                tx = null;
            }
        }
    }

    @Override
    public Orders queryOrderByOid(String oid) {
        Transaction tx = null;
        Orders s = null;
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            s = (Orders) session.get(Orders.class,oid);
            tx.commit();
            return  s;
        }catch (Exception e){
            e.printStackTrace();
            tx.commit();
            return s;
        }finally {
            if (tx!=null){
                tx = null;
            }
        }
    }

    @Override
    public boolean addOrders(Orders o) {
        o.setOid(getNewBid());
        Transaction tx = null;
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            if (tx!=null){
                tx = null;
            }
        }
    }

    @Override
    public boolean updateOrders(Orders o) {
        return false;
    }

    @Override
    public boolean deleteOrders(String oid) {
        Transaction tx = null;
        String hql = "";

        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Orders b = (Orders) session.get(Orders.class,oid);
            session.delete(b);
            tx.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tx.commit();
            return false;
        }finally {
            if (tx!=null){
                tx = null;
            }
        }
    }

    public String getNewBid(){
        Transaction tx = null;
        String hql = "";
        String bid = null;
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "select max(oid) from Orders";
            Query query = session.createQuery(hql);
            bid = (String)query.uniqueResult();
            if(bid==null||"".equals(bid)){
                bid = "O0000001";
            }else {
                String temp = bid.substring(1);
                int i = Integer.parseInt(temp);
                i++;
                temp = String.valueOf(i);
                int len = temp.length();
                for (int j=0;j<7-len;j++){
                    temp="0"+temp;
                }
                bid="o"+temp;
            }
            tx.commit();
            return bid;
        }catch (Exception e){
            e.printStackTrace();
            tx.commit();
            return null;
        }finally {
            if (tx!=null){
                tx = null;
            }
        }

    }

}
