package ru.avalon.java.blog.services;

import javax.ejb.*;

import ru.avalon.java.blog.entities.*;
import ru.avalon.java.blog.service.*;

public class ArticleService {
    
    @EJB
    PublicationService publicationService;
    
    public void create(String title, String content, User author) {
        Publication publication = new Publication(title, content, author);
        publicationService.create(publication);
    }
}
