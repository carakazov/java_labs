package project.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import project.dao.RoleDao;
import project.model.Role;

@Data
@RequiredArgsConstructor
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getByTitle(String title) {
        return (Role) entityManager.createQuery("SELECT role FROM roles role WHERE role.title = :title")
            .setParameter("title", title)
            .getSingleResult();
    }
}
