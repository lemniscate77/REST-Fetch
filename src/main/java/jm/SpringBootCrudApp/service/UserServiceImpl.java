package jm.SpringBootCrudApp.service;

import jm.SpringBootCrudApp.dao.UserDAO;
import jm.SpringBootCrudApp.model.Role;
import jm.SpringBootCrudApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDao;

    @Autowired
    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    public List<Role> allRoles() {
        return userDao.allRoles();
    }

    @Override
    public Set<Role> getRoles(String[] ids) {
        return userDao.getRoles(ids);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getById(id);
    }

    public User getByName(String name) {
        return userDao.getByName(name);
    }

    public List<List<String>> getUserRoles(List<Role> allRoles, User user) {
        List<List<String>> newMap1 = new ArrayList<>();

        allRoles.forEach(role -> {
            List<String> newMap = new ArrayList<>();

            newMap.add(String.valueOf(role.getId()));
            newMap.add(role.getRole());
            newMap.add(user.isRoleInUser(role) ? "true" : "false");
            newMap1.add(newMap);
        });

        return newMap1;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByName(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new org.springframework.security.core.userdetails.User
                (user.getUsername(),
                        user.getPassword(),
                        grantedAuthorities);
    }
}
