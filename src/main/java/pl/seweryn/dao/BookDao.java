package pl.seweryn.dao;
 
import pl.seweryn.model.Book;
 
public interface BookDao {
    public void createBook(Book book);
    public Book readBook(Long id);
    public void updateBook(Book book);
    public void deleteBook(Long bookId);
}