package action;

import entity.Books;
import entity.Orders;
import service.BooksDao;
import service.OrdersDao;
import serviceimp.BooksDaoImpl;
import serviceimp.OrdersDaoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by tyr on 2017/5/28.
 */
public class OrdersAction extends SuperAction{

    private static final long serialVersionUID = 1L;

    public String query(){
        OrdersDao sdao = new OrdersDaoImpl();
        List<Orders> list = sdao.quertAllOrders();

        if (list!=null&&list.size()>0){
            session.setAttribute("orders_list",list);
        }
        return "query_success";
    }

    public String delete(){
        OrdersDao sdao = new OrdersDaoImpl();
        String bid = request.getParameter("oid");
        sdao.deleteOrders(bid);
        return "delete_success";
    }


    public String add() throws Exception{
        String sid = this.request.getParameter("sid");
        String bid = this.request.getParameter("bid");

        Orders b = new Orders();
        b.setSid(sid);
        b.setBid(bid);

        OrdersDao bdao = new OrdersDaoImpl();
        bdao.addOrders(b);
        return "add_success";
    }

  
}
