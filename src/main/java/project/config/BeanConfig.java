package project.config;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import project.controller.AdministratorController;
import project.controller.RegistrationController;
import project.controller.TicketController;
import project.dao.*;
import project.dao.impl.*;
import project.service.FilmService;
import project.service.RegistrationService;
import project.service.TicketService;
import project.service.UserService;
import project.service.impl.*;

@Configuration
@ComponentScan("project")
@EnableWebMvc
@EnableTransactionManagement
public class BeanConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory());
        transactionManager.setDataSource(dataSource());
        transactionManager.setJpaDialect(new HibernateJpaDialect());
        return transactionManager;
    }

    @Bean
    public DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser("postgres");
        dataSource.setPassword("yfgjktjy1813");
        dataSource.setDatabaseName("first_lab");
        return dataSource;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("labs");
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl(passwordEncoder);
    }

    @Bean
    public RoleDao roleDao() {
        return new RoleDaoImpl();
    }

    @Bean
    public RegistrationService registrationService() {
        return new RegistrationServiceImpl(
            userDao(),
            roleDao()
        );
    }

    @Bean
    public RegistrationController registrationController() {
        return new RegistrationController(
            registrationService(),
            userDao(),
            ticketDao()
        );
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(
            userDao()
        );
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(
            userDao()
        );
    }

    @Bean
    public AdministratorController administratorController() {
        return new AdministratorController()
            .setUserService(userService());
    }

    @Bean
    public FilmDao filmDao() {
        return new FilmDaoImpl();
    }

    @Bean
    public CinemaDao cinemaDao() {
        return new CinemaDaoImpl();
    }

    @Bean
    public TicketDao ticketDao() {
        return new TicketDaoImpl();
    }

    @Bean
    public FilmService filmService() {
        return new FilmServiceImpl(
            filmDao()
        );
    }

    @Bean
    public TicketService ticketService() {
        return new TicketServiceImpl(
            filmService(),
            filmDao(),
            cinemaDao(),
            userDao(),
            ticketDao()
        );
    }

    @Bean
    public TicketController ticketController() {
        return new TicketController(
            ticketService(),
            cinemaDao(),
            filmService()
        );
    }
}
