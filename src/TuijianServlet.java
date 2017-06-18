import entity.Books;
import entity.Recomended;
import service.BooksDao;
import service.RecmendedDao;
import serviceimp.BooksDaoImpl;
import serviceimp.RecomendeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyr on 2017/5/29.
 */
public class TuijianServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecmendedDao bdao = new RecomendeDaoImpl();
        BooksDao bdao1 = new BooksDaoImpl();
        List<Books> bookses  = new ArrayList<>();
        List<Recomended> recomendeds = bdao.quertAllRecomended();
        for(Recomended r:recomendeds){
            Books b  = bdao1.queryBooksByBid(r.getSid());
            bookses.add(b);
        }
        req.setAttribute("list",bookses);
        System.out.print("doget");
        req.getRequestDispatcher("login.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
