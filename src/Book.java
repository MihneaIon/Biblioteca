package com.siemens.Library.library;


import javax.persistence.*;
import java.util.ArrayList;
import  java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "genre_book", joinColumns = @JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres=new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="author_book",joinColumns = @JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Authores> authors=new ArrayList<>();

    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Authores> getAuthors() {
        return authors;
    }

    public Book(String name)
    {
        this.name=name;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setAuthors(List<Authores> authors) {
        this.authors = authors;
    }

    public Book() {

    }

    public Book(String name,List<Authores> autor, List<Genre> gen)
    {
        this.name=name;
        this.genres=genres;
        this.authors=autor;
    }
}
