package project.dao;

import project.model.Role;

public interface RoleDao {
    Role getByTitle(String title);
}
