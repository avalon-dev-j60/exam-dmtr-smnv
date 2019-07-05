package ru.avalon.java.blog.entities;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@NamedQueries({@NamedQuery(name = "list-publications",
                           query = "SELECT p FROM Publication AS p"),
               @NamedQuery(name = "find-publications-by-user",
                           query = "SELECT p FROM Publication AS p WHERE p.author = :user")})
@Entity
public class Publication implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User author;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    protected Publication() {
    }

    public Publication(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
        created = new Date();
    }
}
