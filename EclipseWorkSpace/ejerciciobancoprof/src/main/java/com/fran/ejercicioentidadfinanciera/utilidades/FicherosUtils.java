package com.fran.ejercicioentidadfinanciera.utilidades;

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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FicherosUtils {

	/**
	 * Crea un fichero en caso de no existir. Si existe solamente informa de su
	 * existencia pero no lo reemplaza. Si no existe la carpeta que contiene el
	 * fichero también la crea.
	 * 
	 * @param directorio    Directorio donde queremos crear el fichero
	 * @param nombreFichero Nombre del fichero con la extensión incluida
	 * @throws IOException
	 * @author Fran
	 */
	public static void crearFichero(String directorio, String nombreFichero) throws IOException {
		File ruta = new File(directorio);
		File f = new File(ruta, nombreFichero);
		if (!f.exists()) { // El fichero no existe
			if (!ruta.exists()) { // La carpeta no existe
				if (ruta.mkdir()) { // La carpeta la he podido crear
					System.out.println(f.createNewFile() ? "Fichero " + f.getName() + " creado"
							: "No se ha podido crear el fichero " + f.getName());
				} else { // La carpeta no se ha podido crear
					System.out.println("No he podido crear la carpeta " + ruta.getName());
				}
			} else { // La carpeta si existe
				if (f.createNewFile()) { // El fichero se ha creado
					System.out.println("Fichero " + f.getName() + " creado");
				} else {
					System.out.println("No se ha podido crear el fichero " + f.getName());
				}
			}
		} else { // El fichero existe
			System.out.println("Fichero " + f.getName() + " ya existe");
			System.out.println("Tamaño " + f.length() + " bytes");
		}
	}

	/**
	 * Crea un fichero en caso de no existir. Si existe solamente informa de su
	 * existencia pero no lo reemplaza. Si no existe la carpeta que contiene el
	 * fichero también la crea.
	 * 
	 * @param rutaCompleta Será la ruta completa incluido el nombre del fichero con
	 *                     su extensión (ex. "c:/ficheros/prueba.txt")
	 * @throws IOException
	 * @author Fran
	 */
	public static void crearFichero(String rutaCompleta) throws IOException {
		File fichero = new File(rutaCompleta);
		crearFichero(fichero.getParent(), fichero.getName());
	}

	public static void eliminarFichero(String directorio, String nombreFichero) {
		File ruta = new File(directorio);
		File f = new File(ruta, nombreFichero);
		if (f.exists()) { // borramos el fichero
			if (f.isFile()) { // Nos aseguramos que solo borra ficheros y no carpetas
				if (f.delete()) { // Ha borrado el fichero
					System.out.println("Fichero eliminado");
				} else {
					System.out.println("No he podido eliminar el fichero " + f.getName());
				}
			} else {
				System.out.println("El nombre " + f.getName() + " no es un fichero simple");
			}
		} else { // El fichero no existe, no borramos nada
			System.out.println("El fichero " + f.getName() + " no existe.");
		}
	}

	public static void eliminarFichero(String rutaCompleta) {
		File fichero = new File(rutaCompleta);
		eliminarFichero(fichero.getParent(), fichero.getName());
	}

	public static void renombrarFichero(String directorio, String nombreFichero, String nuevoNombre) {
		File ruta = new File(directorio);
		File f = new File(ruta, nombreFichero);
		if(f.exists()) {
			if (f.isFile()) {
				if (f.renameTo(new File(ruta, nuevoNombre))) {
					System.out.println("Se ha cambiado el nombre correctamente");
				} else {
					System.out.println("No he podido cambiar el nombre");
				} 
			}else {
				System.out.println("El nombre " + f.getName() + " no es un fichero simple");
			}
		} else {
			System.out.println("El fichero " + f.getName() + " no existe");
		}
	}
	
	public static void leerDirectorio(String directorio) {
		File ruta = new File(directorio);
		if(ruta.exists()) {
			String[] lista = ruta.list();
			//  ahora recorreré el array
			for (int i = 0; i < lista.length; i++) {
				System.out.println(lista[i]);
			}
			
		} else {
			System.out.println("El directorio " + directorio + " no existe");
		}
	}
	
	public static List<String> obtenerDatosDirectorio(String directorio) {
		File ruta = new File(directorio);
		if(ruta.exists()) {
			return Arrays.asList(ruta.list());			
		} else {
			return null;
		}
	}

	public static void leerFicheroBufferedReader5(String directorio, String nombreFichero) {
		FileReader fr = null;
		try {
			fr = new FileReader(directorio + "/" + nombreFichero);
			BufferedReader entrada = new BufferedReader(fr);
			String linea = entrada.readLine();
			while(linea!=null) {
				System.out.println(linea);
				linea = entrada.readLine();
			}			
		} catch (FileNotFoundException e) {
			// No encuentra el fichero
			//e.printStackTrace();
			System.out.println("No se ha encontrado el fichero");
		} catch (IOException e) {
			// No puede leer el contenido del fichero
			e.printStackTrace();
		} finally {
			try {
				if (fr!=null) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	public static void leerFichero8(String directorio, String nombreFichero) {
		/*List<String> lineas = Files.readAllLines(Paths.get(directorio + "/" + nombreFichero), Charset.defaultCharset());
		lineas.forEach(linea->System.out.println(linea));*/
		try {
			Files.readAllLines(Paths.get(directorio + "/" + nombreFichero), Charset.defaultCharset()).forEach(linea->System.out.println(linea));
		} catch (IOException e) {
			System.out.println("Error al leer el fichero");
		}
	}
	
	public static List<String> devolverLineasFichero8(String directorio, String nombreFichero) throws IOException{
		return devolverLineasFichero8(directorio + "/" + nombreFichero);
	}
	
	public static List<String> devolverLineasFichero8(String rutaCompleta) throws IOException{
		return Files.readAllLines(Paths.get(rutaCompleta), Charset.defaultCharset());
	}
	
	public static List<String> devolverLineasMultiplesFicheros8(String directorio,List<String> nombresArchivo){
		List<String> resultado = new ArrayList<String>();
		for(String archivo : nombresArchivo) {
			try {
				resultado.addAll(devolverLineasFichero8(directorio,archivo));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Esto hace lo mismo con programación funcional
		/*nombresArchivo.forEach(e->{
			try {
				resultado.addAll(devolverLineasFichero8(directorio,e));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});*/
		return resultado;
	}
	
	/**
	 * A partir de los ficheros de un directorio devuelve las lineas que 
	 * incluyen la cadena buscada
	 * @param directorio Donde se encuentran los ficheros a buscar
	 * @param nombresArchivo Lista con los nombres de los ficheros
	 * @param cadenaBuscada Cadena a buscar en los ficheros
	 * @return Lista con todas las líneas en los ficheros que incluyen esa cadena
	 */
	public static List<String> buscarLineasMultiplesFicheros8(String directorio,List<String> nombresArchivo, String cadenaBuscada){
		return devolverLineasMultiplesFicheros8(directorio,nombresArchivo).stream()
			.filter(l->l.contains(cadenaBuscada))
			.collect(Collectors.toList());
	}
	
	public static List<String> buscarEnFichero8(String directorio, String nombreFichero, String cadenaBusqueda) throws IOException{
		return devolverLineasFichero8(directorio + "/" + nombreFichero).stream()
				.filter(l->l.contains(cadenaBusqueda))
				.collect(Collectors.toList());
	}
	
	public static void crearFichero8(String rutaCompleta) throws IOException {
		Files.createFile(Paths.get(rutaCompleta));
	}
	
	public static void agregarLineaFichero8(String rutaCompleta, String nuevaLinea) throws IOException {
		List<String> lineas = devolverLineasFichero8(rutaCompleta);
		lineas.add(nuevaLinea);
		Files.write(Paths.get(rutaCompleta), lineas);
	}
	
	public static void limpiarFichero8(String rutaCompleta) throws IOException {
		Files.write(Paths.get(rutaCompleta), new ArrayList<String>());
	}
	
	public static void escribirFichero8(String rutaCompleta,List<String> lineas) throws IOException {
		Files.write(Paths.get(rutaCompleta), lineas);
	}
	
	public static void escribirFichero8(String rutaCompleta,String ... lineas) throws IOException {
		List<String> lineasParametros = new ArrayList<String>();
		for(String linea : lineas) {
			lineasParametros.add(linea);
		}
		escribirFichero8(rutaCompleta,lineasParametros);
	}
	
	public static void escribirLineaFichero8(String rutaCompleta,String linea) throws IOException {
		Files.writeString(Paths.get(rutaCompleta), linea);
	}
	
	/**
	 * Añade la linea en el fichero al final sin hacer un salto de linea
	 * @param rutaCompleta Directorio más fichero en el disco duro
	 * @param linea	La linea que queremos añadir
	 * @throws IOException
	 */
	public static void concatenarLineaFichero8(String rutaCompleta, String linea) throws IOException {
		Files.writeString(Paths.get(rutaCompleta), linea, StandardOpenOption.APPEND);
	}
	
	public static void copiarFichero8(String rutaInicio, String rutaFin) throws IOException {
		escribirFichero8(rutaFin,devolverLineasFichero8(rutaInicio));		
	}
	
}
