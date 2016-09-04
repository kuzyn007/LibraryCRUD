package pl.seweryn.model;

import java.io.Serializable;

import javax.persistence.*;
 
@Entity
@Table(name="Book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
     
    @Id
    @GeneratedValue
    private Long id;
    private String isbn;
    private String title;
    private String author;
      
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
 
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
