package com.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.Book;
import com.training.repo.BookRepo;

@Service
public class BookService implements BookServiceI {

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBooks() {
		
		return bookRepo.findAll();
	}

	@Override
	public Book getBook(Long isbn) {
		
		Optional<Book> bookOp = bookRepo.findById(isbn);
		Book bookFound=null;
		if(bookOp.isPresent()) {
			bookFound=bookOp.get();
		
			return bookFound;}
		
		return null;
	}

	@Override
	public Book deleteBook(Long isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book updateBookStock(Long isbn, Long newStock) {
		// TODO Auto-generated method stub
		return null;
	}

}
