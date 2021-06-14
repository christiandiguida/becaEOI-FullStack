package com.chris.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.chris.entidades.People;
import com.google.gson.Gson;

public class GsonUtils {

    public static void gsonCreation(String url) {
        Gson gson = new Gson();
        People person = gson.fromJson(JsonUtilsSimple.readUrl(url), People.class);
        person.getFilms().forEach(c -> System.out.println(c));
    }

    public static <T> T gsonCreation(String url, Class<T> clase) {
        String json = JsonUtilsSimple.readUrl(url);
        Gson gson = new Gson();
        T resultado = gson.fromJson(json, clase);
        return resultado;
    }

    // public static <T> List<T> devolverListaGenericaGson(String url, Class<T>
    // clase) {
    // List<T> resultados = new ArrayList<T>();
    // String cadena = JsonUtilsSimple.readUrl(url);
    // Gson gson = new Gson();
    // T resultado = gson.fromJson(cadena, clase);
    // return null;
    // }

}
