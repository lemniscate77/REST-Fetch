package jm.SpringBootCrudApp.dao;


import jm.SpringBootCrudApp.model.User;
import java.util.List;


public interface UserDAO {
    List<User> allUsers();
    void add(User user);
    void delete(Integer id);
    void edit(User user);
    User getById(Integer id);
    User getByName (String name);
    User getUserByName(String name);
}