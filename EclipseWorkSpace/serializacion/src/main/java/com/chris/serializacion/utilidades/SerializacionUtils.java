package com.chris.serializacion.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chris.Persona;

public class SerializacionUtils {

    public static void serializarObjecto(String rutaCompleta) {
        File fichero = new File(rutaCompleta);
        FileOutputStream ficheroSalida;
        try {
            ficheroSalida = new FileOutputStream(fichero);
            ObjectOutputStream ficheroObjectos = new ObjectOutputStream(ficheroSalida);
            Persona p = new Persona("Fran", "222", LocalDate.of(1976, 7, 27), 'H', "Mi Casa", 'S', 1000, 12345);
            ficheroObjectos.writeObject(p);
            ficheroObjectos.close();
            ficheroSalida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializarListaObjectos(String rutaCompleta, List<Persona> personas) {
        File fichero = new File(rutaCompleta);
        FileOutputStream ficheroSalida;
        try {
            ficheroSalida = new FileOutputStream(fichero);
            ObjectOutputStream ficheroObjectos = new ObjectOutputStream(ficheroSalida);
            ficheroObjectos.writeObject(personas);
            ficheroObjectos.close();
            ficheroSalida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void serializarListaObjectosGenericos(String rutaCompleta, List<T> objetos) {
        File fichero = new File(rutaCompleta);
        FileOutputStream ficheroSalida;
        try {
            ficheroSalida = new FileOutputStream(fichero);
            ObjectOutputStream ficheroObjectos = new ObjectOutputStream(ficheroSalida);
            ficheroObjectos.writeObject(objetos);
            ficheroObjectos.close();
            ficheroSalida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void desSerializarObjecto(String rutaCompleta) {
        File fichero = new File(rutaCompleta);
        FileInputStream ficheroEntrada;
        try {
            ficheroEntrada = new FileInputStream(fichero);
            ObjectInputStream ficheroObjectos = new ObjectInputStream(ficheroEntrada);
            Persona p = (Persona) ficheroObjectos.readObject();
            ficheroObjectos.close();
            ficheroEntrada.close();
            System.out.println(p);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Persona> desSerializarListaObjectos(String rutaCompleta) {
        ArrayList<Persona> resultado = new ArrayList<Persona>();
        File fichero = new File(rutaCompleta);
        FileInputStream ficheroEntrada;
        try {
            ficheroEntrada = new FileInputStream(fichero);
            ObjectInputStream ficheroObjectos = new ObjectInputStream(ficheroEntrada);
            resultado = (ArrayList<Persona>) ficheroObjectos.readObject();
            ficheroObjectos.close();
            ficheroEntrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static <T> ArrayList<T> desSerializarListaObjectosGenericos(String rutaCompleta) {
        ArrayList<T> resultado = new ArrayList<T>();
        File fichero = new File(rutaCompleta);
        FileInputStream ficheroEntrada;
        try {
            ficheroEntrada = new FileInputStream(fichero);
            ObjectInputStream ficheroObjectos = new ObjectInputStream(ficheroEntrada);
            resultado = (ArrayList<T>) ficheroObjectos.readObject();
            ficheroObjectos.close();
            ficheroEntrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
