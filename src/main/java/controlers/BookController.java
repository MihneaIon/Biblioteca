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
}
