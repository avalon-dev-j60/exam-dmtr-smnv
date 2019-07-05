package ru.avalon.java.blog.service;

import javax.ejb.*;
import javax.persistence.*;

import ru.avalon.java.blog.entities.*;

@Stateless
public class UserService {

    @PersistenceContext(unitName = "Blog-PU")
    EntityManager emUser;

    public void create(User user) {
        emUser.persist(user);
        emUser.flush();
    }

    public User findByEmail(String email) {
        try {
            return emUser.createNamedQuery("find-user-by-email", User.class)
                     .setParameter("email", email)
                     .getSingleResult(); // .getResultList — для вывода всех пользователей или всех статей
        } catch (NoResultException e) {
            return null;
        }
    }
}
