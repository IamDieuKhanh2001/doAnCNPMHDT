package com.example.demospringsecurity.Book;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Books {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )

    private Long Book_ID;
    private String Title;
    private int Pages;
    private LocalDate Publication_Date;
    private String Description;
    private int Price;
    private int Discount;
    private int Language_ID;
    private int Category_ID;
    private int Publisher_ID;
    private int Author_ID;
    private String Img;

    public Books() {
    }

    public Books(String title, int pages, LocalDate publication_Date, String description, int price, int discount, int language_ID, int category_ID, int publisher_ID, int author_ID, String img) {
        Title = title;
        Pages = pages;
        Publication_Date = publication_Date;
        Description = description;
        Price = price;
        Discount = discount;
        Language_ID = language_ID;
        Category_ID = category_ID;
        Publisher_ID = publisher_ID;
        Author_ID = author_ID;
        Img = img;
    }

    public int getPublisher_ID() {
        return Publisher_ID;
    }

    public void setPublisher_ID(int publisher_ID) {
        Publisher_ID = publisher_ID;
    }

    public int getAuthor_ID() {
        return Author_ID;
    }

    public void setAuthor_ID(int author_ID) {
        Author_ID = author_ID;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public Long getBook_ID() {
        return Book_ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getPages() {
        return Pages;
    }

    public void setPages(int pages) {
        Pages = pages;
    }

    public LocalDate getPublication_Date() {
        return Publication_Date;
    }

    public void setPublication_Date(LocalDate publication_Date) {
        Publication_Date = publication_Date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int discount) {
        Discount = discount;
    }

    public int getLanguage_ID() {
        return Language_ID;
    }

    public void setLanguage_ID(int language_ID) {
        Language_ID = language_ID;
    }

    public int getCategory_ID() {
        return Category_ID;
    }

    public void setCategory_ID(int category_ID) {
        Category_ID = category_ID;
    }
}
