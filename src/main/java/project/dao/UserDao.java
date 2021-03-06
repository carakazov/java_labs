package project.dao;

import java.util.List;

import project.model.User;


public interface UserDao {
    User add(User user);

    User findByLogin(String login);

    List<User> getAll();

    void delete(String login);
}
