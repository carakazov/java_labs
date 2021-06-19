package project.controller;

import java.security.Principal;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import project.dao.CinemaDao;
import project.service.FilmService;
import project.service.TicketService;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;
    private final CinemaDao cinemaDao;
    private final FilmService filmService;

    private int cinemaId;

    @GetMapping("/cinemas")
    public ModelAndView cinemas() {
        return new ModelAndView("cinemaList").addObject("list", cinemaDao.getAll());
    }

    @GetMapping("/cinemas/{id}")
    public ModelAndView films(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("filmList");
        modelAndView.addObject("list", cinemaDao.getById(id).getFilms());
        cinemaId = id;
        return modelAndView;
    }

    @GetMapping("/cinemas/ticket/add/{filmId}")
    public ModelAndView ticker(@PathVariable(name = "filmId") int filmId, Principal principal) {
        ticketService.addTicket(principal.getName(), filmId, cinemaId);
        return new ModelAndView("redirect:/index");
    }
}
