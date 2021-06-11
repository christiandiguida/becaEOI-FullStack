package com.chris;

import com.chris.utilidades.JsonUtilsSimple;

public class AppJson {
    public static final String rutaCompleta = "EclipseWorkSpace/xmljson/src/main/java/com/chris/ficheros/ejemplo.json";

    public static void main(String[] args) {
        JsonUtilsSimple.readJson(rutaCompleta);
    }

}
