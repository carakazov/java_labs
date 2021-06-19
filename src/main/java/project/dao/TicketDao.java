package project.dao;

import java.util.List;

import project.model.Ticket;
import project.model.User;

public interface TicketDao {
    void add(Ticket ticket);

    List<Ticket> getAllOfUser(User user);
}
