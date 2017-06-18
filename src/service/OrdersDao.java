package service;

import entity.Books;
import entity.Orders;

import java.util.List;

/**
 * Created by tyr on 2017/5/28.
 */
public interface OrdersDao {
    public List<Orders> quertAllOrders();
    public Orders queryOrderByOid(String oid);
    public boolean addOrders(Orders o);
    public boolean updateOrders(Orders o);
    public boolean deleteOrders(String oid);
}
