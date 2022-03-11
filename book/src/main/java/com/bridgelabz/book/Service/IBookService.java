package com.bridgelabz.book.Service;



import java.util.List;

import com.bridgelabz.book.dto.BookDTO;
import com.bridgelabz.book.dto.QuantityDTO;
import com.bridgelabz.book.model.Book;

public interface IBookService {
	
    Book insertBook(BookDTO dto);
    
    List<Book> getAllBooks();
    
    Book getbookByID(Integer BookId);
    
    List<Book> retrieveBooks();
    
    Book updateById(Integer BookId, BookDTO dto);
    
    Book deleteById(Integer BookId);
    
	Book getbookByBookName(String bookName);
	
	List<Book> sortBooksAsc();
	
	List<Book> sortBooksDesc();
	
	Book updateQuantity(QuantityDTO dto);
	
	Book getbookByIdAPI(Integer bookId);
	
}
