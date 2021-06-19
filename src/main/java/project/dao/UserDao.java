package project.dao;

import project.model.User;


public interface UserDao {
    User add(User user);

    User findByLogin(String login);
}
