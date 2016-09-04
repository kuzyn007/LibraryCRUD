package pl.seweryn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.seweryn.dao.BookDao;
import pl.seweryn.model.Book;

@Service
@Transactional
public class BookService {
	

    @Autowired
    private BookDao dao;
    
    public void createBook(Book book) {
    	dao.createBook(book);
    }
    public Book readBook(Long id) {
    	return dao.readBook(id);
    }
    public void updateBook(Book book) {
    	dao.updateBook(book);
    }
    public void deleteBook(Long bookId) {
    	dao.deleteBook(bookId);
    }

}
