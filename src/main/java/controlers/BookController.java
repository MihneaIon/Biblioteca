package com.siemens.Library.library.controler;

import com.siemens.Library.library.Book;
import com.siemens.Library.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class BookController {
    @Autowired
    BookRepository myBoookRepositiory;

//    @RequestMapping(value = "/book", method = RequestMethod.POST)
//    public void addBook(@RequestParam(value = "name", defaultValue = "Alice in tara minunilor")String name)
//    {
//        Book myBook=new Book(name);
//        myBoookRepositiory.save(myBook);
//
//    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book) {

        myBoookRepositiory.save(book);

    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return (List<Book>) myBoookRepositiory.findAll();
    }

    @RequestMapping(value = "/book/{book_id}",method = RequestMethod.PUT)
    public Book updateBook(@PathVariable(value = "book_id")Long bookId,
                           @RequestBody Book myBook )
    {
        try {
            Book auxBook = myBoookRepositiory.findById(bookId).get();
            System.out.println(bookId);
            auxBook.setName(myBook.getName());

            Book updateBook = myBoookRepositiory.save(auxBook);
            return updateBook;
        }catch (Exception e)
        {
            System.out.println("Invalid Id");
            return null;
        }

    }

    @DeleteMapping("/book/{book_id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "book_id")
                                        Long bookId)
    {
        Book myBook= myBoookRepositiory.findById(bookId).get();
        myBoookRepositiory.delete(myBook);
        return  ResponseEntity.ok().build();
    }
}
