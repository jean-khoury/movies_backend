package com.project.cedrus.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="movies")
@Getter
@Setter
@NoArgsConstructor

public class Movie implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private java.util.UUID id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="genre", nullable=false)
    private String genre;

    @Column(name="description")
    private String description;

    @Column(name="rating")
    private Double rating;

    public Movie(java.util.UUID id , String name , String genre , String description, Double rating){
        this.id=id;
        this.name=name;
        this.genre=genre;
        this.description=description;
        this.rating=rating;
    }
}