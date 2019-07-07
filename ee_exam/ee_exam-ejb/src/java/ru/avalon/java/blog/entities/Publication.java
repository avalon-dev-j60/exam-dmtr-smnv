package ru.avalon.java.blog.entities;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@NamedQueries({@NamedQuery(name = "list-publications",
                           query = "SELECT p FROM Publication AS p"),
               @NamedQuery(name = "find-publication-by-id",
                           query = "SELECT item FROM Publication AS item WHERE item.id = :id"),
               @NamedQuery(name = "find-publications-by-user",
                           query = "SELECT p FROM Publication AS p WHERE p.author = :user")})
@Entity
public class Publication implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column (nullable = false)
    private String title;

    @Column (columnDefinition = "long varchar")
    private String content;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User author;

    @Temporal (TemporalType.TIMESTAMP)
    private Date created;

    protected Publication() {
    }

    public Publication(String title, String content, User author) {
        
        this.title = title;
        this.content = content;
        this.author = author;
        created = new Date();
    }

    public void setTitle(String title) {
        
        this.title = title;
    }

    public void setContent(String content) {
        
        this.content = content;
    }

    public long getId() {
        
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        
        return content;
    }

    public User getAuthor() {
        
        return author;
    }

    public Date getCreated() {
        
        return created;
    }
}
