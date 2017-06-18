package service;

import entity.Books;
import entity.Recomended;

import java.util.List;

/**
 * Created by tyr on 2017/5/28.
 */
public interface RecmendedDao {
    public List<Recomended> quertAllRecomended();
    public Recomended queryRecomendedByRid(String rid);
    public boolean addRecomended(Recomended r);
    public boolean updateRecomended(Recomended r);
    public boolean deleteRecomended(String rid);
}
