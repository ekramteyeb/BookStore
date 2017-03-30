package com.course.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.bookstore.domain.Book;
import com.course.bookstore.domain.BookRepository;
import com.course.bookstore.domain.CategoryRepository;



@RestController
public class BookRestController {

	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// Show all books as JSON Format
   @RequestMapping(value="/books", method = RequestMethod.GET)
   public @ResponseBody List<Book> bookListRest(){
	   
	   return (List<Book>) brepository.findAll();
   }
   
   //Restfull service to get a book by Id
   
   @RequestMapping(value="/books/{id}", method= RequestMethod.GET)
	public @ResponseBody Book findBookRest(@PathVariable("id")Long bookId){
	   return  brepository.findOne(bookId);
   }
   
    
    
}
