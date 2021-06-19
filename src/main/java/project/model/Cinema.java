package project.model;

import java.util.Set;
import javax.persistence.*;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity(name = "cinemas")
@Data
@Accessors(chain = true)
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_cinema",
               joinColumns = @JoinColumn(name = "cinema_id"),
               inverseJoinColumns = @JoinColumn(name = "film_id"))
    private Set<Film> films;
}
