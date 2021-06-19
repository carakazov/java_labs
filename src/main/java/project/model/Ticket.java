package project.model;

import javax.persistence.*;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity(name = "tickets")
@Data
@Accessors(chain = true)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
}
