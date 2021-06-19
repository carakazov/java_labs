package project.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import project.dao.CinemaDao;
import project.model.Cinema;

@Data
@RequiredArgsConstructor
public class CinemaDaoImpl implements CinemaDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cinema> getAll() {
        return entityManager.createQuery("SELECT cinema FROM cinemas cinema")
            .getResultList();
    }

    @Override
    public void add(Cinema cinema) {
        entityManager.merge(cinema);
    }

    @Override
    @Transactional
    public Cinema getById(int id) {
        return (Cinema) entityManager.createQuery("SELECT cinema FROM cinemas cinema WHERE cinema.id =: id")
            .setParameter("id", id)
            .getSingleResult();
    }
}

