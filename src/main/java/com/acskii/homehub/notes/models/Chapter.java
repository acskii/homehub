package com.acskii.homehub.notes.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;

@Entity
@Table( name = "chapter" )
@EntityListeners(AuditingEntityListener.class)
public class Chapter {
    /* Columns */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "name" )
    private String name;

    @CreatedDate
    @Column( name = "created_at", nullable = false )
    private Instant createdAt;

    @LastModifiedDate
    @Column( name = "updated_at", nullable = false )
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn( name = "book_id" )
    private Book book;

    @OneToMany( mappedBy = "chapter" )
    @JsonManagedReference
    private List<Page> pages;

    /* Constructors */
    public Chapter() {}

    public Chapter(Book book) {
        this.book = book;
    }

    public Chapter(Book book, String name) {
        this.book = book;
        this.name = name;
    }

    /* Getters & Setters */
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public List<Page> getPages() { return pages; }
    public void setPages(List<Page> pages) { this.pages = pages; }
}