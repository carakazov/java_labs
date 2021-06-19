package project.service.impl;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import project.dao.FilmDao;
import project.model.Cinema;
import project.model.Film;
import project.service.FilmService;

@Data
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmDao filmDao;

    @Override
    public void addTicketToFilm(int filmId) {
        Film film = filmDao.getById(filmId);
        film.setNumberOfTickets(film.getNumberOfTickets() + 1);
        filmDao.add(film);
    }

    @Override
    @Transactional
    public List<Film> getFilmsOfCinemas(Cinema cinema) {
        return null;
    }
}
