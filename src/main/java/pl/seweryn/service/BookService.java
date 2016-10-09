package pl.seweryn.service;

import pl.seweryn.model.Book;

public interface BookService {
    Iterable<Book> listAllBooks();

    Book getBookById(Long id);

    Book saveBook(Book book);

    void deleteBook(Long id);
}