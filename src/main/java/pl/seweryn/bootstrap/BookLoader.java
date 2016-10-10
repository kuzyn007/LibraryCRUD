package pl.seweryn.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import pl.seweryn.dao.BookDao;
import pl.seweryn.model.Book;

@Component
public class BookLoader implements ApplicationListener<ContextRefreshedEvent> {

    private BookDao bookDao;

    private Logger log = Logger.getLogger(BookLoader.class);

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Book first = new Book();
        first.setIsbn("23953923");
        first.setTitle("\"Kamienie na szaniec\"");
        first.setAuthor("Aleksander Kamiński");
        bookDao.save(first);

        log.info("Saved first book - id: " + first.getId());

        Book second = new Book();
        second.setIsbn("56953927");
        second.setTitle("\"W pustyni i w puszczy\"");
        second.setAuthor("Henryk Sienkiewicz");
        bookDao.save(second);

        log.info("Saved second book - id:" + second.getId());
        
        Book third = new Book();
        third.setIsbn("66954921");
        third.setTitle("\"Potop\"");
        third.setAuthor("Henryk Sienkiewicz");
        bookDao.save(third);
        
        log.info("Saved third book - id:" + third.getId());
        
        Book fourth = new Book();
        fourth.setIsbn("77954921");
        fourth.setTitle("\"Spring w akcji\"");
        fourth.setAuthor("Craig Walls");
        bookDao.save(fourth);
        
        log.info("Saved fourth book - id:" + fourth.getId());
        
        Book fifth = new Book();
        fifth.setIsbn("93254123");
        fifth.setTitle("\"Java. Podstawy. Wydanie IX\"");
        fifth.setAuthor("Cay S. Horstmann, Gary Cornell");
        bookDao.save(fifth);
        
        log.info("Saved fifth book - id:" + fifth.getId());
    }
}
