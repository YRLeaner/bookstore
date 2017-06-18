package action;

import entity.Recomended;
import service.RecmendedDao;
import serviceimp.RecomendeDaoImpl;

import java.util.List;

/**
 * Created by tyr on 2017/6/4.
 */
public class RecomendedAction extends SuperAction {
    private static final long serialVersionUID = 1L;

    public String query(){
        RecmendedDao sdao = new RecomendeDaoImpl();
        List<Recomended> list = sdao.quertAllRecomended();

        if (list!=null&&list.size()>0){
            session.setAttribute("recomended_list",list);
        }
        return "query_success";
    }

    public String delete(){
        RecmendedDao sdao = new RecomendeDaoImpl();
        String bid = request.getParameter("rid");
        sdao.deleteRecomended(bid);
        return "delete_success";
    }


    public String add() throws Exception{
        String bid = this.request.getParameter("sid");

        Recomended b = new Recomended();
        b.setSid(bid);

        RecmendedDao bdao = new RecomendeDaoImpl();
        bdao.addRecomended(b);
        return "add_success";
    }

    public String modify(){
        String bid = request.getParameter("sid");
        RecmendedDao sdao = new RecomendeDaoImpl();
        Recomended s = sdao.queryRecomendedByRid(bid);
        session.setAttribute("modify_recomended",s);
        return "modify_success";
    }

    public String save()throws Exception{
        Recomended s = new Recomended();
        s.setSid(request.getParameter("sid"));

        RecmendedDao sdao = new RecomendeDaoImpl();
        sdao.updateRecomended(s);
        return "save_success";
    }
}
