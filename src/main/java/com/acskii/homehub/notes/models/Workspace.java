package com.acskii.homehub.notes.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.EntityListeners;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;

@Entity
@Table( name = "workspace" )
@EntityListeners(AuditingEntityListener.class)
public class Workspace {
    /* Columns */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "name", nullable = false, unique = true )
    private String name;

    @CreatedDate
    @Column( name = "created_at", nullable = false )
    private Instant createdAt;

    @OneToMany( mappedBy = "workspace" )
    @JsonManagedReference
    private List<Book> books;

    /* Constructors */
    public Workspace() {}

    public Workspace(String name) {
        this.name = name;
    }

    /* Getters & Setters */
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}