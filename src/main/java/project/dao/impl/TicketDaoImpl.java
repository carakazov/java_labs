package project.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import project.dao.TicketDao;
import project.model.Ticket;
import project.model.User;

@Data
@RequiredArgsConstructor
public class TicketDaoImpl implements TicketDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Ticket ticket) {
        entityManager.merge(ticket);
    }

    @Override
    public List<Ticket> getAllOfUser(User user) {
        return entityManager.createQuery("SELECT ticket FROM tickets ticket WHERE ticket.owner =: user")
            .setParameter("user", user)
            .getResultList();
    }
}
