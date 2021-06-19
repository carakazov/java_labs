package project.service.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import project.dao.CinemaDao;
import project.dao.FilmDao;
import project.dao.TicketDao;
import project.dao.UserDao;
import project.model.Cinema;
import project.model.Film;
import project.model.Ticket;
import project.model.User;
import project.service.FilmService;
import project.service.TicketService;

@Data
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final FilmService filmService;
    private final FilmDao filmDao;
    private final CinemaDao cinemaDao;
    private final UserDao userDao;
    private final TicketDao ticketDao;

    @Override
    @Transactional
    public void addTicket(String userLogin, int filmId, int cinemaId) {
        User owner = userDao.findByLogin(userLogin);
        Film film = filmDao.getById(filmId);
        Cinema cinema = cinemaDao.getById(cinemaId);
        Ticket ticket = new Ticket()
            .setCinema(cinema)
            .setFilm(film)
            .setOwner(owner);
        filmService.addTicketToFilm(filmId);
        ticketDao.add(ticket);
    }
}
