package jm.SpringBootCrudApp.service;


import jm.SpringBootCrudApp.model.Role;
import jm.SpringBootCrudApp.model.User;
import org.springframework.data.relational.core.sql.In;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public interface UserService extends UserDetailsService {

    public List<User> getAllUsers();

    public List<Role> getAllRoles();

    public Set<Role> getRoles(String[] ids);

    public void insert(User user);


    public void update(User user);

    public User getUser(Integer id);

    public void deleteUser(Integer id);

    public List<List<String>> getUserRoles(List<Role> allRoles, User user);

}




