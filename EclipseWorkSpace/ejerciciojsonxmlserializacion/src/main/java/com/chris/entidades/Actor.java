package com.chris.entidades;

import java.util.Arrays;
import java.util.List;

public class Actor {
    private String name;
    private transient List<Film> filmsArray;
    private String[] films;

    public Actor() {
    }

    public Actor(String name, List<Film> filmsArray, String[] films) {
        this.name = name;
        this.filmsArray = filmsArray;
        this.films = films;
    }

    @Override
    public String toString() {
        return "Actor [filmsArray=" + filmsArray + ", name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Film> getFilmsArray() {
        return filmsArray;
    }

    public void setFilmsArray(List<Film> filmsArray) {
        this.filmsArray = filmsArray;
    }

    public String[] getFilms() {
        return films;
    }

    public void setFilms(String[] films) {
        this.films = films;
    }

}
