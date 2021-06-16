package com.chris;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.chris.entidades.Actor;
import com.chris.entidades.Film;
import com.chris.utilidades.JsonUtilsSimple;
import com.google.gson.Gson;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static int codigoPrimerActor = 0;
    public static int codigoSegundoActor = 0;
    public static final String urlPeople = "https://swapi.dev/api/people/";
    public static final String urlFilms = "https://swapi.dev/api/films/";
    public static Actor actorOne = new Actor();
    public static Actor actorTwo = new Actor();

    public static void main(String[] args) {
        menu();
        createActorOne(codigoPrimerActor);
        createActorTwo(codigoSegundoActor);
        checkCommonFilms();
    }

    public static void checkCommonFilms() {
        List<String> titlesActorOne = new ArrayList<String>();
        List<String> titlesActorTwo = new ArrayList<String>();
        actorOne.getFilmsArray().stream().map(f -> f.getTitle()).forEach(t -> {
            titlesActorOne.add(t);
        });
        actorTwo.getFilmsArray().stream().map(f -> f.getTitle()).forEach(t -> {
            titlesActorTwo.add(t);
        });
        titlesActorOne.retainAll(titlesActorTwo);
        titlesActorOne.forEach(t -> System.out.println(t));
    }

    public static void menu() {
        System.out.println("1. -Peliculas Comunes");
        System.out.println("0. -Salir");
        System.out.println("Option: ");
        System.out.println("Introduzca el codigo del primer actor:");
        codigoPrimerActor = sc.nextInt();
        System.out.println("Introduzca el codigo del segundo actor:");
        codigoSegundoActor = sc.nextInt();
    }

    public static List<Film> setFilmsActor() {
        List<String> urls = new ArrayList<String>(Arrays.asList(actorOne.getFilms()));
        List<Film> films = new ArrayList<Film>();
        urls.forEach(u -> {
            u = u.replaceFirst("http", "https");
            Gson gson = new Gson();
            Film film = gson.fromJson(JsonUtilsSimple.readUrl(u + "?format=json"), Film.class);
            films.add(film);
        });
        return films;
    }

    public static void createActorOne(int id) {
        Gson gson = new Gson();
        String json = JsonUtilsSimple.readUrl(urlPeople + id + "/?format=json");
        if (json != null) {
            actorOne = gson.fromJson(json, Actor.class);
            actorOne.setFilmsArray(setFilmsActor());
        }
    }

    public static void createActorTwo(int id) {
        Gson gson = new Gson();
        String json = JsonUtilsSimple.readUrl(urlPeople + id + "/?format=json");
        if (json != null) {
            actorTwo = gson.fromJson(json, Actor.class);
            actorTwo.setFilmsArray(setFilmsActor());
        }
    }

}
