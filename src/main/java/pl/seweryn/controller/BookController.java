package pl.seweryn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.seweryn.model.Book;
import pl.seweryn.service.BookService;

@Controller
@EnableAutoConfiguration

public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//Empty object - trick to re-use the view code for both the Create and Update form
	//Providing a empty Product object, we reduce the likelihood of null pointer errors when rendering the view.
	@RequestMapping(value="/book/new", method=RequestMethod.GET) 
	public String newBook(Model model) {
		model.addAttribute("book", new Book());
		return "bookform";
	}
	
	//Create
	@RequestMapping(value = "book", method = RequestMethod.POST)
    public String createBook(Book book) {
		bookService.createBook(book);
        return "redirect:/book/" + book.getId();
    }
	
	//Read
	@RequestMapping("/book/{id}")
    public String showBook(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.readBook(id));
        return "bookshow";
    }
	
	//Update
	@RequestMapping("book/edit/{id}")
	public String editBook(@PathVariable Long id, Model model){
	    model.addAttribute("book", bookService.readBook(id));
	    return "bookform";
	}
	
	//Delete
	@RequestMapping("product/delete/{id}")
	public String delete(@PathVariable Long id){
	    bookService.deleteBook(id);
	    return "redirect:/books";
	}
	
	//List All
    /*@RequestMapping(value = "/books", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("books", bookService.);
        return "products";
    }*/
}
