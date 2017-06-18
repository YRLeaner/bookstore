package serviceimp;

import db.MyHibernateSessionFactory;
import entity.Books;
import entity.Recomended;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.RecmendedDao;

import java.util.List;

/**
 * Created by tyr on 2017/6/4.
 */
public class RecomendeDaoImpl implements RecmendedDao {

    @Override
    public List<Recomended> quertAllRecomended() {
        Transaction tx = null;
        List<Recomended> list = null;
        String hql = "";
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "from Recomended";
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
    public Recomended queryRecomendedByRid(String rid) {
        Transaction tx = null;
        Recomended s = null;
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            s = (Recomended)session.get(Recomended.class,rid);
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
    public boolean addRecomended(Recomended r) {
        r.setRid(getNewBid());
        Transaction tx = null;
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.save(r);
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
    public boolean updateRecomended(Recomended r) {
        Transaction tx = null;

        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.update(r);
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

    @Override
    public boolean deleteRecomended(String rid) {
        Transaction tx = null;
        String hql = "";

        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Recomended b = (Recomended) session.get(Recomended.class,rid);
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
            hql = "select max(rid) from Recomended";
            Query query = session.createQuery(hql);
            bid = (String)query.uniqueResult();
            if(bid==null||"".equals(bid)){
                bid = "R0000001";
            }else {
                String temp = bid.substring(1);
                int i = Integer.parseInt(temp);
                i++;
                temp = String.valueOf(i);
                int len = temp.length();
                for (int j=0;j<7-len;j++){
                    temp="0"+temp;
                }
                bid="r"+temp;
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
