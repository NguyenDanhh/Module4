package com._book_loan_app.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    @Column(name = "name_book")
    private String nameBook;

    @Column(name = "count_book")
    private int count;

    @ManyToMany
    @JoinTable(name = "information",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "oder_id")
    )
    List<Oder> list;

    public Book() {
    }

    public Book(int id, String nameBook, int count) {
        this.id = id;
        this.nameBook = nameBook;
        this.count = count;
    }

    public List<Oder> getList() {
        return list;
    }

    public void setList(List<Oder> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
