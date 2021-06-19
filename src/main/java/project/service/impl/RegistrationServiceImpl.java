package project.service.impl;

import java.util.HashSet;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import project.dao.RoleDao;
import project.dao.UserDao;
import project.model.Role;
import project.model.User;
import project.service.RegistrationService;

@Data
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserDao userDao;
    private final RoleDao roleDao;

    @Override
    @Transactional
    public User registration(User user) {
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleDao.getByTitle("ROLE_USER"));
        user.setRoles(roles);
        return userDao.add(user);
    }

    @Override
    public User registrationAdmin(User user) {
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleDao.getByTitle("ROLE_ADMIN"));
        user.setRoles(roles);
        return userDao.add(user);
    }

}
