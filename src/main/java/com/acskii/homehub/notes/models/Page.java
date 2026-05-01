package com.acskii.homehub.notes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table( name = "page" )
@EntityListeners(AuditingEntityListener.class)
public class Page {
    /* Columns */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( name = "page_number", nullable = false )
    private Integer pageNumber;

    @Column( name = "content", nullable = false, columnDefinition = "jsonb" )
    private String content;  // Stores JSONB content as a String

    @CreatedDate
    @Column( name = "created_at", nullable = false )
    private Instant createdAt;

    @LastModifiedDate
    @Column( name = "updated_at", nullable = false )
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn( name = "chapter_id" )
    @JsonBackReference
    private Chapter chapter;

    /* Constructors */
    public Page() {}

    public Page(Integer pageNumber, String content, Chapter chapter) {
        this.pageNumber = pageNumber;
        this.content = content;
        this.chapter = chapter;
    }

    /* Getters & Setters */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getPageNumber() { return pageNumber; }
    public void setPageNumber(Integer pageNumber) { this.pageNumber = pageNumber; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
    public Chapter getChapter() { return chapter; }
    public void setChapter(Chapter chapter) { this.chapter = chapter; }
}