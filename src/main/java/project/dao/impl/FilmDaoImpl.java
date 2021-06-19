package project.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import project.dao.FilmDao;
import project.model.Film;

@Data
@RequiredArgsConstructor
public class FilmDaoImpl implements FilmDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Film> getAll() {
        return entityManager.createQuery("SELECT film FROM films film")
            .getResultList();
    }

    @Override
    public void add(Film film) {
        entityManager.merge(film);
    }

    @Override
    public Film getById(int id) {
        return (Film) entityManager.createQuery("SELECT film FROM films film WHERE film.id =: id")
            .setParameter("id", id)
            .getSingleResult();
    }

}
