package com.course.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.course.bookstore.domain.Book;
import com.course.bookstore.domain.BookRepository;
import com.course.bookstore.domain.CategoryRepository;


@Controller
public class BookControllers {

	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@RequestMapping(value="/")
	public String home(){
		
		return "index";
	}
	@RequestMapping(value="/index")
	public String index(){
		
		return "index";
	}
	
	// Show all books
    @RequestMapping(value="/booklist")
    public String bookList(Model model) {	
        model.addAttribute("books", brepository.findAll());
        return "booklist";
    }
    
    // Add new book
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
    	return "addbook";
    }     
    
    // Save new book
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        brepository.save(book);
        return "redirect:booklist";
    }    

    // Delete book
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	brepository.delete(bookId);
        return "redirect:../booklist";
    }     
}
