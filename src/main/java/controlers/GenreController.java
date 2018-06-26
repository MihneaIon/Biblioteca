package com.siemens.Library.library.controler;

import com.siemens.Library.library.Genre;
import com.siemens.Library.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {

    @Autowired
    GenreRepository myGenreRepository;

//    @RequestMapping(value = "/genre",method = RequestMethod.POST)
//    public Genre addBook(@RequestParam(value = "name",defaultValue = "Darama")String name)
//    {
//        Genre myGenre=new Genre();
//        myGenreRepository.save(myGenre);
//        return  myGenre;
//    }

    @RequestMapping(value = "/genre",method = RequestMethod.POST)
    public void addGen(@RequestBody Genre myGenre)
    {
        myGenreRepository.save(myGenre);
    }

    @RequestMapping(value = "/genre",method = RequestMethod.GET)
    public List<Genre> getGenre()
    {
        return (List<Genre>) myGenreRepository.findAll();
    }

    @RequestMapping(value = "/genre",method = RequestMethod.PUT)
    public Genre updateAuthor(@PathVariable(value = "genre_id")Long genreId,
                                 @RequestBody Genre myGenre)
    {
        try{

            Genre auxGenre=myGenreRepository.findById(genreId).get();
            auxGenre.setName(myGenre.getName());
            Genre updateGenre=myGenreRepository.save(auxGenre);
            return updateGenre;

        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/genre/{genre_id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteGenre(@PathVariable(value = "genre_id")Long genreId)
    {
        Genre myGenre=myGenreRepository.findById(genreId).get();
        myGenreRepository.delete(myGenre);
        return  ResponseEntity.ok().build();
    }


}
