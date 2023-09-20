package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "long UNSIGNED")
    private long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Post() {

    }
    public Post( String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
