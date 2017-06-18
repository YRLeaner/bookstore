package serviceimp;

import db.MyHibernateSessionFactory;
import entity.Books;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.BooksDao;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by tyr on 2017/5/28.
 */
public class BooksDaoImpl implements BooksDao {

    @Override
    public List<Books> quertAllBooks() {
        Transaction tx = null;
        List<Books> list = null;
        String hql = "";
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "from Books";
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
    public Books queryBooksByBid(String bid) {
        Transaction tx = null;
        Books s = null;
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            s = (Books)session.get(Books.class,bid);
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
    public boolean addBooks(Books b) {
        b.setBid(getNewBid());
        Transaction tx = null;
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.save(b);
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
    public boolean updateBooks(Books b) {

        Transaction tx = null;

        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.update(b);
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
    public boolean deleteBooks(String bid) {
        Transaction tx = null;
        String hql = "";

        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Books b = (Books) session.get(Books.class,bid);
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

    //生成书籍书号
    public String getNewBid(){
        Transaction tx = null;
        String hql = "";
        String bid = null;
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "select max(id) from Books";
            Query query = session.createQuery(hql);
            bid = (String)query.uniqueResult();
            if(bid==null||"".equals(bid)){
                bid = "B0000001";
            }else {
                String temp = bid.substring(1);
                int i = Integer.parseInt(temp);
                i++;
                temp = String.valueOf(i);
                int len = temp.length();
                for (int j=0;j<7-len;j++){
                    temp="0"+temp;
                }
                bid="b"+temp;
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
