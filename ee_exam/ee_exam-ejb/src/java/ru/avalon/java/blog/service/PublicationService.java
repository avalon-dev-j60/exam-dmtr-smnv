package ru.avalon.java.blog.service;

import java.util.*;
import javax.ejb.*;
import javax.persistence.*;
import ru.avalon.java.blog.entities.*;

@Stateless
public class PublicationService {

    @PersistenceContext(unitName = "Blog-PU")
    EntityManager em;

    public void create(Publication publication) {
        
        em.persist(publication);
    }

    public void update(Publication publication) {
        
        em.merge(publication);
    }

    public void delete(Publication publication) {
        
        em.remove(publication);
    }

    public Publication find(long id) {
        
        try {
            return em.createNamedQuery("find-publication-by-id", Publication.class)
                     .setParameter("id", id)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Publication> list() {
        
        try {
            return em.createNamedQuery("list-publications", Publication.class)
                     .getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }
}
