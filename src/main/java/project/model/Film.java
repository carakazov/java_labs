package project.model;

import javax.persistence.*;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity(name = "films")
@Data
@Accessors(chain = true)
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(name = "number_of_tickets")
    private int numberOfTickets;
}
