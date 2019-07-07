package ru.avalon.java.blog.service;

import javax.ejb.*;
import javax.persistence.*;
import ru.avalon.java.blog.entities.*;

@Stateless
public class UserService {

    @PersistenceContext(unitName = "Blog-PU")
    EntityManager em;

    public void create(User user) {
        
        em.persist(user);
        em.flush();
    }

    public User findByEmail(String email) {
        
        try {
            return em
                    .createNamedQuery("find-user-by-email", User.class)
                    .setParameter("email", email)
                    .getSingleResult(); // .getResultList — для вывода всех пользователей или всех статей
        } catch (NoResultException e) {
            return null;
        }
    }
}
