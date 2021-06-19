package project.dao;

import java.util.List;

import project.model.Cinema;

public interface CinemaDao {
    List<Cinema> getAll();

    void add(Cinema cinema);

    Cinema getById(int id);
}
