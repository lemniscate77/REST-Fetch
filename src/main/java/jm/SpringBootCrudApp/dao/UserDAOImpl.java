package jm.SpringBootCrudApp.dao;


import jm.SpringBootCrudApp.model.Role;
import jm.SpringBootCrudApp.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// убрал коммент
@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> allUsers() {
        List<User> allUsers = em.createQuery("from User ", User.class)
                .getResultList();
        return allUsers;
    }

    @Override
    public void add(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1,"ROLE_USER"));
        user.setRoles(roles);
        em.persist(user);
    }

    @Override
    public void delete(Integer id) {
        User user = em.find(User.class,id);
        em.remove(user);
    }

    @Override
    public void edit(User user) {
        em.merge(user);
    }

    @Override
    public User getById(Integer id) {
        return em.find(User.class,id);
    }

    public User getByName(String name) {
        return em.find(User.class, name);
    }

    @Override
    public User getUserByName(String name) {
        return em.createQuery("SELECT u FROM User u WHERE u.firstName = :userName", User.class)
                .setParameter("userName", name)
                .setMaxResults(1)
                .getSingleResult();
    }

}
