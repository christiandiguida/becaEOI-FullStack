package com.chris.ficheros.auxiliares;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.jna.platform.FileUtils;

public class Ficheros {

    /**
     * The method creates a file in the case that it does not already exists. If it
     * exists, the method informs about its existence. If the root folder doesn't
     * exists, the method will create it.
     * 
     * @param directorio
     * @param nombreFichero
     * @throws IOException
     * @author christiandiguida
     * 
     */
    public static void crearFichero(String directorio, String nombreFichero) throws IOException {
	File ruta = new File(directorio);
	File fichero = new File(ruta, nombreFichero);
	if (!fichero.exists()) {
	    if (!ruta.exists()) {
		if (ruta.mkdir()) {
		    System.out.println(fichero.createNewFile() ? "Fichero " + fichero.getName() + " creado."
			    : "No se ha podido crear el fichero " + fichero.getName());
		    // lo mismo que la linea 21-25
		} else {
		    System.out.println("No he podido crear la carpeta.");
		}
	    } else {
		if (fichero.createNewFile()) {
		    System.out.println("Fichero " + fichero.getName() + " creado.");
		} else {
		    System.out.println("No se ha podido crear el fichero " + fichero.getName());
		}
	    }
	} else {
	    System.out.println("Fichero " + fichero.getName() + " ya existe.");
	    System.out.println("Tamano: " + fichero.length() + " bytes");
	}
    }

    /**
     * The method creates a file in the case that it does not already exists. If it
     * exists, the method informs about its existence. If the root folder doesn't
     * exists, the method will create it.
     * 
     * @param rutaCompleta Absolute path (e.g. Users/user/Desktop/file.txt)
     * @throws IOException
     * @author christiandiguida
     *
     */

    public static void crearFichero(String rutaCompleta) throws IOException {
	File fichero = new File(rutaCompleta);
	crearFichero(fichero.getParent(), fichero.getName());

    }

    public static void eliminarFichero(String directorio, String nombreFichero) {
	File ruta = new File(directorio);
	File fichero = new File(ruta, nombreFichero);
	if (fichero.exists()) {
	    if (fichero.isFile()) {
		if (fichero.delete()) {
		    System.out.println("Fichero " + fichero.getName() + " eliminado.");
		} else {
		    System.out.println("No he podido borrar el fichero " + fichero.getName());
		}
	    } else {
		System.out.println(fichero.getName() + " no es un fichero y entonces no se borrar??.");
	    }

	} else {
	    System.out.println("Fichero " + fichero.getName() + " no existe.");
	}
    }

    public static void eliminarFichero(String rutaCompleta) {
	File fichero = new File(rutaCompleta);
	eliminarFichero(fichero.getParent(), fichero.getName());
    }

    public static void renombrarFichero(String directorio, String nombreFichero, String nuevoNombre) {
	File ruta = new File(directorio);
	File fichero = new File(ruta, nombreFichero);
	if (fichero.exists()) {
	    if (fichero.isFile()) {
		if (fichero.renameTo(new File(ruta, nuevoNombre))) {
		    System.out.println("Se ha cambiado el nombre correctamente.");
		} else {
		    System.out.println("No he podido cambiar el nombre.");
		}
	    } else {
		System.out.println(fichero.getName() + " no es un fichero y no se renombrar??.");
	    }
	} else {
	    System.out.println("El fichero " + fichero.getName() + " no existe.");
	}
    }

    public static void renombrarFichero(String rutaCompleta, String nuevoNombre) {
	File fichero = new File(rutaCompleta);
	renombrarFichero(fichero.getParent(), fichero.getName(), nuevoNombre);
    }

    public static void moverPapelera(String directorio, String nombreFichero) {
	FileUtils fileUtils = FileUtils.getInstance();
	if (fileUtils.hasTrash()) {
	    try {
		fileUtils.moveToTrash(new File[] { new File(directorio + "/" + nombreFichero) });
		System.out.println("Fichero movido a la papelera");
	    } catch (IOException ioe) {
		System.out.println("El fichero no existe");
	    }
	} else {
	    System.out.println("Papelera no disponible");
	}

    }

    public static void leerDirectorio(String directorio) {
	File ruta = new File(directorio);
	if (ruta.exists()) {
	    String[] lista = ruta.list();
	    for (String file : lista) {
		System.out.println(file);
	    }
	} else {
	    System.out.println("El directorio " + directorio + " no existe.");
	}
    }

    public static String[] obtenerDatosDirectorio(String directorio) {
	File ruta = new File(directorio);
	if (ruta.exists()) {
	    return ruta.list();
	} else {
	    System.out.println("El directorio " + directorio + " no existe.");
	    return null;
	}
    }

    public static void leerFicheroBufferedReader5(String directorio, String nombreFichero) {
	FileReader fr = null;
	try {
	    fr = new FileReader(directorio + "/" + nombreFichero);
	    BufferedReader entrada = new BufferedReader(fr);
	    String linea = entrada.readLine();
	    while (linea != null) {
		System.out.println(linea);
		linea = entrada.readLine();
	    }
	} catch (FileNotFoundException e) {
	    // No encuentra el fichero
	    // e.printStackTrace();
	    System.out.println("No se ha encontrado el fichero");
	} catch (IOException e) {
	    // No puede leer el contenido del fichero
	    e.printStackTrace();
	} finally {
	    try {
		if (fr != null) {
		    fr.close();
		}
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	}

    }

    public static void leerFichero8(String directorio, String nombreFichero) {
	try {
	    Files.readAllLines(Paths.get(directorio + "/" + nombreFichero), Charset.defaultCharset())
		    .forEach((linea) -> {
			System.out.println(linea);
		    });
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static List<String> devolverLineasFicheros8(String directorio, String nombreFichero) throws IOException {
	return devolverLineasFicheros8((directorio + "/" + nombreFichero));
    };

    public static List<String> devolverLineasFicheros8(String rutaCompleta) throws IOException {
	return Files.readAllLines(Paths.get(rutaCompleta), Charset.defaultCharset());
    };

    public static List<String> buscarEnFichero(String directorio, String nombreFichero, String cadenaBusqueda)
	    throws IOException {
	return devolverLineasFicheros8(directorio + "/" + nombreFichero).stream()
		.filter(linea -> linea.contains(cadenaBusqueda)).collect(Collectors.toList());
    };

    public static void crearFichero8(String rutaCompleta) throws IOException {
	Files.createFile(Paths.get(rutaCompleta));
    }

    public static void agregarLineaFichero8(String rutaCompleta, String nuevaLinea) throws IOException {
	List<String> lineas = devolverLineasFicheros8(rutaCompleta);
	lineas.add(nuevaLinea);
	Files.write(Paths.get(rutaCompleta), lineas);
    }

    public static void limpiarFichero(String rutaCompleta) throws IOException {
	Files.write(Paths.get(rutaCompleta), new ArrayList<String>());
    }

    public static void escribirFichero(String rutaCompleta, List<String> lista) throws IOException {
	Files.write(Paths.get(rutaCompleta), lista);
    }

    public static void escribirFichero(String rutaCompleta, String... lista) throws IOException {
	List<String> list = new ArrayList<String>();
	for (String line : lista) {
	    list.add(line);
	}
	Files.write(Paths.get(rutaCompleta), list);
    }

    public static void concatenarLineaFichero(String rutaCompleta, String linea) throws IOException {
	Files.writeString(Paths.get(rutaCompleta), linea, StandardOpenOption.APPEND);
    }
}
