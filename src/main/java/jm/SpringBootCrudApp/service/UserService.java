package jm.SpringBootCrudApp.service;


import jm.SpringBootCrudApp.model.Role;
import jm.SpringBootCrudApp.model.User;
import org.springframework.data.relational.core.sql.In;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;


public interface UserService extends UserDetailsService {
    List<User> allUsers();
    List<Role> allRoles();
    Set<Role> getRoles(String[] ids);
    void add(User user);
    void delete(Integer id);
    void edit(User user);
    public void insert(User user);
    User getById(Integer id);
    User getUserByName(String name);
    public User getUser(Integer id);
    public List<List<String>> getUserRoles(List<Role> allRoles, User user);
}


