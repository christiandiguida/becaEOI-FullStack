package com.chris;

import com.chris.utilidades.GsonUtils;

public class AppGson {
    private static final String url = "https://swapi.dev/api/people/";

    public static void main(String[] args) {
        GsonUtils.gsonCreation(url);
    }
}
