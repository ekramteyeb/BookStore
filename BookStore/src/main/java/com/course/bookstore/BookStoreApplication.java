package com.course.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.course.bookstore.domain.Book;
import com.course.bookstore.domain.BookRepository;
import com.course.bookstore.domain.Category;
import com.course.bookstore.domain.CategoryRepository;




@SpringBootApplication
public class BookStoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
		
	@Bean
	public CommandLineRunner bookstore(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			
			crepository.save(new Category("Novel"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Horor"));
			crepository.save(new Category("Scientific"));
			
			brepository.save(new Book("Yechamut Sheka", "Hayleyesus", "1989", "123211",56, crepository.findByName("Novel").get(0)));
			brepository.save(new Book("Yeburka zemeta", "Gebre", "2012", "EC89",78, crepository.findByName("Horor").get(0)));
			brepository.save(new Book("Audacity of Barak", "B.H Obama", "2008", "EC8dd9",150, crepository.findByName("Fiction").get(0)));

			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
}
}