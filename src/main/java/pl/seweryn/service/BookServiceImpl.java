package pl.seweryn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.seweryn.dao.BookDao;
import pl.seweryn.model.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

    @Override
    public Iterable<Book> listAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookDao.findOne(id);
    }

    @Override
    public Book saveBook(Book Book) {
        return bookDao.save(Book);
    }

    @Override
    public void deleteBook(Long id) {
        bookDao.delete(id);
    }
}