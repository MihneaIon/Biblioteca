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
    public void addBook(@RequestParam(value = "name", defaultValue = "Alice in tara minunilor")String name)
    {
        Book myBook=new Book(name);
        myBoookRepositiory.save(myBook);

    }
}
