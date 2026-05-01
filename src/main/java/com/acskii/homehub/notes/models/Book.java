package com.acskii.homehub.notes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;

@Entity
@Table( name = "book" )
@EntityListeners(AuditingEntityListener.class)
public class Book {
    /* Columns */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "name", nullable = false, unique = true )
    private String name;

    @CreatedDate
    @Column( name = "created_at", nullable = false )
    private Instant createdAt;

    @LastModifiedDate
    @Column( name = "updated_at", nullable = false )
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn( name = "workspace_id" )
    @JsonBackReference
    private Workspace workspace;

    @OneToMany( mappedBy = "book" )
    private List<Chapter> chapters;

    /* Constructors */
    public Book() {}

    public Book(String name) {
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
    public Workspace getWorkspace() { return workspace; }
    public void setWorkspace(Workspace workspace) { this.workspace = workspace; }
    public List<Chapter> getChapters() { return chapters; }
    public void setChapters(List<Chapter> chapters) { this.chapters = chapters; }
}