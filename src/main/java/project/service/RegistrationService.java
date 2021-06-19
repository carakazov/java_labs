package project.service;

import project.model.User;

public interface RegistrationService {
    User registration(User user);

    User registrationAdmin(User user);
}
