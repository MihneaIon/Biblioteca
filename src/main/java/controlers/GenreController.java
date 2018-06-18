package com.siemens.Library.library.controler;

import com.siemens.Library.library.Genre;
import com.siemens.Library.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {

    @Autowired
    GenreRepository myGenreRepository;

    @RequestMapping(value = "/genres",method = RequestMethod.POST)
    public void addBook(@RequestParam(value = "name",defaultValue = "Darama")String name)
    {
        Genre myGenre=new Genre();
        myGenreREepository.save(myGenre);
    }


}
