package com.graphQL.graphqlPractice.model;

import javax.persistence.*;

@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String authorName;
    private int age;

    @OneToOne
    private Book bookId;

    public Author(){}

    public Author(String authorName,int age,Book bookId){
        this.authorName=authorName;
        this.age=age;
        this.bookId=bookId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", age=" + age +
                ", bookId=" + bookId +
                '}';
    }
}
