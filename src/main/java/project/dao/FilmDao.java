package project.dao;

import java.util.List;

import project.model.Film;

public interface FilmDao {
    List<Film> getAll();

    void add(Film film);

    Film getById(int id);
}
