package project.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.dao.UserDao;
import project.model.User;

@Data
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    private final PasswordEncoder encoder;

    @Override
    public User add(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return entityManager.merge(user);
    }

    @Override
    public User findByLogin(String login) {
        return (User) entityManager.createQuery("SELECT user FROM users user WHERE user.login =:login")
            .setParameter("login", login)
            .getSingleResult();
    }
}
