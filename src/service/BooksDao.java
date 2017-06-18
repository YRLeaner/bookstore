package service;

import entity.Books;

import java.util.List;

/**
 * Created by tyr on 2017/5/28.
 */
public interface BooksDao {
    public List<Books> quertAllBooks();
    public Books queryBooksByBid(String bid);
    public boolean addBooks(Books b);
    public boolean updateBooks(Books b);
    public boolean deleteBooks(String bid);
}
