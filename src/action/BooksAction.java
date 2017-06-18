package action;

import entity.Books;
import service.BooksDao;
import service.StudentsDao;
import serviceimp.BooksDaoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by tyr on 2017/5/28.
 */
public class BooksAction extends SuperAction{

    private static final long serialVersionUID = 1L;

    public String query(){
        BooksDao sdao = new BooksDaoImpl();
        List<Books> list = sdao.quertAllBooks();

        if (list!=null&&list.size()>0){
            session.setAttribute("books_list",list);
        }
        return "query_success";
    }

    public String delete(){
        BooksDao sdao = new BooksDaoImpl();
        String bid = request.getParameter("bid");
        sdao.deleteBooks(bid);
        return "delete_success";
    }


    public String add() throws Exception{
        String bname = this.request.getParameter("bname");
        String price = this.request.getParameter("price");
        //String birthday = this.request.getParameter("birthday");
        String address = this.request.getParameter("address");
        Books b = new Books();
        b.setBname(bname);
        b.setPrice(price);
        b.setAddress(address);
       /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(birthday);*/
        b.setBirthday(new Date());
        BooksDao bdao = new BooksDaoImpl();
        bdao.addBooks(b);
        return "add_success";
    }

    public String modify(){
        String bid = request.getParameter("bid");
        BooksDao sdao = new BooksDaoImpl();
        Books s = sdao.queryBooksByBid(bid);
        session.setAttribute("modify_books",s);
        return "modify_success";
    }

    public String save()throws Exception{
        Books s = new Books();
        s.setBid(request.getParameter("bid"));
        s.setBname(request.getParameter("bname"));
        s.setPrice(request.getParameter("price"));
        s.setAddress(request.getParameter("address"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(request.getParameter("birthday"));
        s.setBirthday(date);
        BooksDao sdao = new BooksDaoImpl();
        sdao.updateBooks(s);
        return "save_success";
    }
}
