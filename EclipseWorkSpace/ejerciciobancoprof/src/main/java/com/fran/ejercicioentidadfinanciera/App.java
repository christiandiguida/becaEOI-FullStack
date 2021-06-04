package com.fran.ejercicioentidadfinanciera;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.fran.ejercicioentidadfinanciera.multilenguaje.Multilenguaje;
import com.fran.ejercicioentidadfinanciera.utilidades.FechasUtils;
import com.fran.ejercicioentidadfinanciera.utilidades.FicherosUtils;
import com.fran.ejercicioentidadfinanciera.utilidades.MenuUtils;
import com.fran.ejercicioentidadfinanciera.utilidades.StringUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	public static Scanner sc = new Scanner(System.in);
	public static String dni;
	public static final String DIRECTORIO = "c:/ficheros/datosbancos";
	public static Multilenguaje ml;
	public static final String SEPARADOR = ";";
	public static final int PARTE_NOMBRE = 1;
	public static final int PARTE_FECHA = 2;
	public static final int PARTE_PAIS = 3;
	public static final int PARTE_SALDO = 4;
	
	public static void obtenerDni() {
		System.out.println("Introduce el dni/cif:");
		dni = sc.nextLine();
	}
	
	public static void inicializarIdioma(String idioma) {
		ml = new Multilenguaje(idioma);
	}
	
	public static void mensajeBienvenida(String linea) {
		System.out.println(ml.hello + " " + StringUtils.obtenerParte(linea, SEPARADOR, PARTE_NOMBRE));
	}
	
	public static void imprimirFecha(String idioma) {
		System.out.println(FechasUtils.obtenerFechaFormatoLargoPais(idioma));
	}
	
	public static String devolverFechaNacimientoCorrecta(List<String> lineas) {
		Set<String> fechas = new HashSet<String>();
		lineas.forEach(l->fechas.add(StringUtils.obtenerParte(l,SEPARADOR,PARTE_FECHA)));
		List<String> listafechas = new ArrayList<String>(fechas); // Creo lista a partir del set porque el set no puedo acceder a una posición concreta
		if(listafechas.size()==1) {
			return listafechas.get(0);
		} else {
			System.out.println(ml.correct_opcion);
			MenuUtils.imprimirMenu(listafechas);
			int opcion = Integer.parseInt(sc.nextLine());			
			return listafechas.get(opcion-1);
		}
	}
	
    public static void main( String[] args )
    {
        obtenerDni();
        List<String> archivosDirectorio = FicherosUtils.obtenerDatosDirectorio(DIRECTORIO);
        List<String> todasLineas = FicherosUtils.buscarLineasMultiplesFicheros8(DIRECTORIO, archivosDirectorio,dni);
        if (todasLineas.size()>0) {
			inicializarIdioma(StringUtils.obtenerParte(todasLineas.get(0), SEPARADOR, PARTE_PAIS));
			mensajeBienvenida(todasLineas.get(0));
			imprimirFecha(StringUtils.obtenerParte(todasLineas.get(0), SEPARADOR, PARTE_PAIS));
			//todasLineas.forEach(l->System.out.println(l));
			String fechaBuena = devolverFechaNacimientoCorrecta(todasLineas);
			int edad = FechasUtils.devolverEdad(fechaBuena);
			double saldo = StringUtils.sumarValorPosicion(todasLineas, SEPARADOR, PARTE_SALDO);
			System.out.println(saldo);

        } else {
			System.out.println("No existe ese Dni en nuestro sistema");
		}
        
    }
}
