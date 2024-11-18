package org.example.models;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private Integer year;

    @ManyToMany
    private List<Genre> genres;

    private String director;


}
