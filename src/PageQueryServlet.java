import entity.Books;
import service.BooksDao;
import serviceimp.BooksDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

/**
 * Created by tyr on 2017/5/29.
 */
public class PageQueryServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BooksDao bdao = new BooksDaoImpl();
        List<Books> bookses = bdao.quertAllBooks();
        req.setAttribute("list",bookses);
        System.out.print("doget");
        req.getRequestDispatcher("books.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
