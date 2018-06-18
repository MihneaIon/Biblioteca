package com.siemens.Library.library;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authores")
public class Authores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;
    String nationality;

    @ManyToMany(mappedBy = "authors",cascade = CascadeType.ALL)
    private List<Book> books=new ArrayList<>();



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Authores()
    {

    }

    public Authores( String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public Authores(String name, String nationality, List<Book> books) {
        this.name = name;
        this.nationality = nationality;
        this.books = books;
    }

    @Override
    public String toString() {
        return "name: "+name+" nationality: "+ nationality;
    }
}
