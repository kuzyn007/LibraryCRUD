package pl.seweryn.dao;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Component;
import javax.persistence.PersistenceContext;

import pl.seweryn.model.Book;

@Component
public class BookDaoImpl implements BookDao {
 
	@PersistenceContext
	private EntityManager entityManager;
 
    @Override
    public void createBook(Book book) {
    	entityManager.persist(book);
    }
 
    @Override
    public Book readBook(Long id) {
    	return entityManager.find(Book.class, id);       
    }
    
    @Override
    public void updateBook(Book book) {
    	entityManager.merge(book);
    }
 
    @Override
    public void deleteBook(Long bookId) {
        Book objToRemove = entityManager.find(Book.class, bookId);
        entityManager.remove(objToRemove);
        System.out.println(objToRemove.getId()); //console information
    }
}
