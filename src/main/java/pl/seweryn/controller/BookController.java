package pl.seweryn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.seweryn.model.Book;
import pl.seweryn.service.BookService;

@Controller
@EnableAutoConfiguration
@RequestMapping(value="/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/createBook", method=RequestMethod.GET)
	public String createBook2() {
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		String message = "Book created.";
		return "index";
	}
	
	@RequestMapping(value="/createBook", method=RequestMethod.POST)
	public ModelAndView createBook(@ModelAttribute Book book) {
		
		ModelAndView modelAndView = new ModelAndView("index");
		
        bookService.createBook(book);
		
		String message = "Book created.";
		return modelAndView.addObject("message", message);
	}
	

}
