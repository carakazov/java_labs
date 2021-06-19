package project.service.impl;

import java.util.List;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDao;
import project.model.User;
import project.service.UserService;

@Data
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public void delete(String login) {
        userDao.delete(login);
    }

    @Override
    public User getByLogin(String login) {
        return userDao.findByLogin(login);
    }
}
