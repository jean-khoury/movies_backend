package com.project.cedrus.repositories;

import com.project.cedrus.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie,java.util.UUID> {
}