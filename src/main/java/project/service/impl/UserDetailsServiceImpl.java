package project.service.impl;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDao;
import project.model.User;

@Data
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDao userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByLogin(s);
        Set<GrantedAuthority> ga = new HashSet<>();
        user.getRoles().forEach(item -> ga.add(new SimpleGrantedAuthority(item.getTitle())));
        return new org.springframework.security.core.userdetails.User(
            user.getLogin(),
            user.getPassword(),
            ga
        );
    }
}
