package com.chris.utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.chris.entidades.Tarea;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtilsSimple {

    public static void readJson(String rutaCompleta) {
        try {
            Object obj = new JSONParser().parse(new FileReader(new File(rutaCompleta)));
            JSONObject json = (JSONObject) obj;
            // String nombre = (String) json.get("nombre");
            // System.out.println(nombre);
            // String apellido = (String) json.get("apellido");
            // System.out.println(apellido);
            // Map<?, ?> domicilio = (Map<?, ?>) json.get("domicilio");
            // domicilio.entrySet().iterator();

            // Como tratar los arrays

            JSONArray jArray = (JSONArray) json.get("numerosTelefonos");
            jArray.forEach(c -> System.out.println(c));
            // Iterator numeros = jArray.iterator();
            // numeros.forEachRemaining(e -> {
            // Iterator<Map.Entry> campos = ((Map) e).entrySet().iterator();
            // campos.forEachRemaining(campo -> System.out.println(campo.getKey() + ": " +
            // campo.getValue()));
            // });
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    public static void readJsonURL(String url) {
        try {
            String cadena = readUrl(url);
            JSONArray jArray = (JSONArray) new JSONParser().parse(cadena);
            // while (jArray.iterator().hasNext()) {
            JSONObject obj = (JSONObject) jArray.iterator().next();
            System.out.println((String) obj.get("id"));

            Tarea tarea = new Tarea();

            // }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clase Profe Fran
     * 
     * @param web
     * @return
     */
    public static String readUrl(String web) {
        try {
            URL url = new URL(web);
            URLConnection uc = url.openConnection();
            uc.setRequestProperty("User-Agent", "PostmanRuntime/7.20.1");
            uc.connect();
            String lines = new BufferedReader(new InputStreamReader(uc.getInputStream(), StandardCharsets.UTF_8))
                    .lines().collect(Collectors.joining());
            return lines;
        } catch (Exception e) {
            System.out.println("No se ha podido la leer la URL: " + web);
        }
        return null;
    }

    /**
     * Clase Profe Fran
     * 
     * @param web
     * @param token
     * @return
     */
    public static String readUrl(String web, String token) {
        try {
            URL url = new URL(web);
            URLConnection uc = url.openConnection();
            uc.setRequestProperty("User-Agent", "PostmanRuntime/7.20.1");
            uc.setRequestProperty("X-Auth-Token", token);
            uc.connect();
            String lines = new BufferedReader(new InputStreamReader(uc.getInputStream(), StandardCharsets.UTF_8))
                    .lines().collect(Collectors.joining());
            return lines;
        } catch (Exception e) {
            System.out.println("No se ha podido la leer la URL: " + web);
        }
        return null;
    }
}
