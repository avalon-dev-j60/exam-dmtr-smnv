package ru.avalon.java.blog.service;

import java.util.*;
import javax.ejb.*;
import javax.persistence.*;

import ru.avalon.java.blog.entities.*;

@Stateless
public class PublicationService {
    
    @PersistenceContext(unitName = "Blog-PU")
    EntityManager emPublication;

    public void create(Publication publication) {
        emPublication.persist(publication);
        emPublication.flush();
    }

    public List<Publication> listPublications() {
        try {
            return emPublication.createNamedQuery("list-publications", Publication.class)
                                .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
