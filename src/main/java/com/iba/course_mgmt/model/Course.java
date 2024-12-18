package com.iba.course_mgmt.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Generates UUIDs
    private String id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(name = "created_at")
    private String createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = String.valueOf(Instant.now().getEpochSecond());
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
