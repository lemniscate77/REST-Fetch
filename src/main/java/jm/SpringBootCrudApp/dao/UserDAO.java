package jm.SpringBootCrudApp.dao;


import jm.SpringBootCrudApp.model.Role;
import jm.SpringBootCrudApp.model.User;
import java.util.List;
import java.util.Set;


public interface UserDAO {
    List<User> allUsers();
    List<Role> allRoles();
    Set<Role> getRoles(String[] ids);
    void add(User user);
    void delete(Integer id);
    void edit(User user);
    public void insert(User user);
    User getById(Integer id);
    User getByName (String name);
    User getUserByName(String name);
}