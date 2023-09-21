package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    public Post() {

    }
    public Post( String title, String description) {
        this.title = title;
        this.description = description;
    }


    public Post(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
