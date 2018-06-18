package com.siemens.Library.library;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;

    @ManyToMany(mappedBy = "genres",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Book> books=new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Genre(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Genre()
    {

    }
}
