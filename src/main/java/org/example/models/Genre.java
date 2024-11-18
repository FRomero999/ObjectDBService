package org.example.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Genre {
    @Id
    @GeneratedValue
    private Long id;
    private String genre;

    @ManyToMany
    private List<Movie> movies;
}
