package com.chris.entidades;

import java.util.Arrays;
import java.util.List;

public class Film {
    private String title;
    private transient List<Actor> actors;
    private String[] characters;

    public Film() {
    }

    public Film(String title, List<Actor> actors, String[] characters) {
        this.title = title;
        this.actors = actors;
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Film [actors=" + actors + ", title=" + title + "]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String[] getCharacters() {
        return characters;
    }

    public void setCharacters(String[] characters) {
        this.characters = characters;
    }

}
