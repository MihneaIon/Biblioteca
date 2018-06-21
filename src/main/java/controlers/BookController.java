package com.siemens.Library.library.controler;

import com.siemens.Library.library.Book;
import com.siemens.Library.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;

@RestController

public class BookController
{
    @Autowired
    BookRepository myBoookRepositiory;

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book)
    {

        myBoookRepositiory.save(book);

    }
    
    //    @RequestMapping(value = "/book{book_id}",method = RequestMethod.PUT)
//    public Book updateBook(@PathVariable(value = "book_id")Long bookId,
//                           @Valid @RequestBody Book myBook)
//    {
//        Book auxBook=(Book)myBoookRepositiory.findById(bookId);
//    }
//
//    @DeleteMapping("/book/{book_id}")
//    public ResponseEntity<?> deleteBook(@PathVariable(value = "id")
//                                        Long bookId)
//    {
//        Book myBook= myBoookRepositiory.findById(bookId);
//    }
}
