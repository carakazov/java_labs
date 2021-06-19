package project.service;

import java.util.List;

import project.model.Cinema;
import project.model.Film;

public interface FilmService {
    void addTicketToFilm(int filmId);

    List<Film> getFilmsOfCinemas(Cinema cinema);
}

