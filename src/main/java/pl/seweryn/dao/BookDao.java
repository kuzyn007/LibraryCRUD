package pl.seweryn.dao;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import pl.seweryn.model.Book;

@Component
public interface BookDao extends CrudRepository<Book, Long>{
}