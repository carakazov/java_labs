package project.service;

import java.util.List;

import project.model.User;

public interface UserService {
    List<User> getAll();

    void delete(String login);

    User getByLogin(String login);
}
