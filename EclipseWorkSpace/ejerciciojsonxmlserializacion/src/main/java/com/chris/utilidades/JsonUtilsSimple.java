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

public class JsonUtilsSimple {

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
