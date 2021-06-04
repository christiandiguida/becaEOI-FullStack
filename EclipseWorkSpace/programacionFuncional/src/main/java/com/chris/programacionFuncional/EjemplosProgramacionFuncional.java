package com.chris.programacionFuncional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EjemplosProgramacionFuncional {

	static List<Usuario> usuarios = new ArrayList<Usuario>();

	public static void setUp() {
		Usuario u1 = new Usuario(0, "Christian", 900);
		usuarios.add(u1);
		usuarios.add(new Usuario(1, "Usuario1", 500));
		usuarios.add(new Usuario(1, "Usuario1", 500));
		usuarios.add(new Usuario(2, "Usuario2", 700));
		usuarios.add(new Usuario(3, "Usuario3", 2500));
		usuarios.add(new Usuario(4, "Usuario4", 2500));
		usuarios.add(new Usuario(5, "Usuario5", 2500));
		usuarios.add(new Usuario(6, "Usuario6", 2500));
		usuarios.add(new Usuario(7, "Usuario7", 2500));
	}

	public static void setDown() {
		usuarios.clear();
	}

	public static void eForEach() {
		setUp();
		usuarios.forEach(usuario -> System.out.println(usuario));
		setDown();
	}

	public static void eFilter() {
		setUp();
		// Mostrar por pantalla los elementos filtrados
		usuarios.stream().filter(usuario -> usuario.getSueldo() > 1000).forEach(usuario -> System.out.println(usuario));
		// crear una sub lista con los elementos filtrados
		List<Usuario> usuariosFiltrados = usuarios.stream().filter(usuario -> usuario.getSueldo() > 1000)
				.collect(Collectors.toList());
		usuariosFiltrados.forEach(usuario -> {
			usuario.setNombre(usuario.getNombre().toUpperCase());
			System.out.println(usuario);
		});
		System.out.println(usuariosFiltrados.size());
		setDown();
	}

	public static void eMap() {
		setUp();
		// Map me permite de quedarme con uno de los campos de la clase
		List<String> nombres = usuarios.stream().map((usuario) -> usuario.getNombre()).collect(Collectors.toList());
		nombres.forEach(usuario -> System.out.println(usuario));
		setDown();
	}

	public static void eFind() {
		setUp();
		Usuario usuarioEncontrado = usuarios.stream().filter(u -> u.getNombre().equalsIgnoreCase("Usuario1"))
				.findFirst().orElse(new Usuario(1, "Nuevo Usuario", 2000));
		System.out.println(usuarioEncontrado);
		setDown();
	}

	public static void eFlatMap() {
		List<String> alumnosDam = new ArrayList<String>(Arrays.asList("Usuario1", "Usuario2"));
		List<String> alumnosDaw = new ArrayList<String>(Arrays.asList("Usuario1", "Usuario2"));
		List<List<String>> alumnos = new ArrayList<List<String>>(Arrays.asList(alumnosDam, alumnosDaw));

		System.out.println(alumnos);
		List<String> todosAlumnos = alumnos.stream().flatMap(a -> a.stream()).sorted().collect(Collectors.toList());
		todosAlumnos.forEach(a -> System.out.println(a));
	}

	public static void ePeek() {
		// Peek : es equivalente al for-each pero sin ser final
		setUp();
		List<Usuario> usuario2 = usuarios.stream().filter(u -> u.getNombre().equalsIgnoreCase("Usuario1"))
				.peek(u -> u.setSueldo(u.getSueldo() + 1000)).collect(Collectors.toList());
		usuario2.forEach(u -> System.out.println(u));
		setDown();
	}

	public static void eCount() {
		setUp();
		long numeroElementos = usuarios.stream().filter(u -> u.getNombre().equalsIgnoreCase("Usuario1")).count();
		System.out.println(numeroElementos);
		setDown();
	}

	public static void eSkipLimit() {
		// Skip salta el numero de elementos que digamos
		// Limit limita el numero de resultados
		setUp();
		usuarios.stream().skip(3).limit(3).forEach(u -> System.out.println(u));
		setDown();
	}

	public static void eMaxMin() {
		setUp();
		Optional<Usuario> userMin = usuarios.stream().min(Comparator.comparing(Usuario::getId));
		System.out.println(userMin.isEmpty() ? "No hay usuario" : userMin.get());
		Usuario userMax = usuarios.stream().max(Comparator.comparing(Usuario::getId))
				.orElse(new Usuario(10, "nuevo usuario", 4000));
		System.out.println(userMax);
		// usuarios.forEach(u -> System.out.println(u));
		setDown();
	}

	public static void eDistinct() {
		setUp();
		List<String> nombreDistintos = usuarios.stream().map(u -> u.getNombre()).distinct()
				.collect(Collectors.toList());
		nombreDistintos.forEach(u -> System.out.println(u));
		setDown();
	}

	public static void eMatch() {
		setUp();
		boolean isUserRich = usuarios.stream().anyMatch(u -> u.getSueldo() > 20000);
		boolean areUsersRich = usuarios.stream().allMatch(u -> u.getSueldo() > 20000);
		boolean areUsersPoor = usuarios.stream().noneMatch(u -> u.getSueldo() > 20000);
		System.out.println(isUserRich);
		System.out.println(areUsersRich);
		System.out.println(areUsersPoor);
		if (usuarios.stream().anyMatch(u -> u.getSueldo() < 0)) {
			usuarios.stream().filter(u -> u.getSueldo() < 0).forEach(u -> System.out.println(u));
		} else {
			System.out.println("No hay usuarios que ganan menos de 0 euros");
		}
		setDown();
	}

	public static void eSumAverage() {
		setUp();
		double sumaSueldos = usuarios.stream().mapToDouble(Usuario::getSueldo).sum();
		double mediaSueldos = usuarios.stream().mapToDouble(Usuario::getSueldo).average().orElse(-1);
		System.out.println(sumaSueldos);
		System.out.println(mediaSueldos);

		IntStream.rangeClosed(1, 10).forEach(u -> System.out.println(u));

		setDown();
	}

	public static void eReduce() {
		setUp();
		double sumaSueldos = usuarios.stream().mapToDouble(u -> u.getSueldo()).reduce(0, Double::sum);
		System.out.println(sumaSueldos);
		setDown();
	}

	public static void eJoining() {
		setUp();
		String nombres = usuarios.stream().map(Usuario::getNombre).collect(Collectors.joining(","));
		System.out.println(nombres);
		setDown();
	}

	public static void eSet() {
		setUp();
		Set<String> nombresDistintos = usuarios.stream().map(Usuario::getNombre).collect(Collectors.toSet());
		nombresDistintos.forEach(n -> System.out.println(n));
		setDown();
	}

	public static void eSummarizingDouble() {
		setUp();
		DoubleSummaryStatistics estadisticas = usuarios.stream()
				.collect(Collectors.summarizingDouble(Usuario::getSueldo));
		System.out.println(estadisticas);
		setDown();
	}

	public static void ePartitioningBy() {
		setUp();
		Map<Boolean, List<Usuario>> sueldosGrandes = usuarios.stream()
				.collect(Collectors.partitioningBy(u -> u.getSueldo() > 1500));
		System.out.println("Ganan Mucho");
		sueldosGrandes.get(true).forEach(u -> System.out.println(u));
		System.out.println("Ganan Poco");
		sueldosGrandes.get(false).forEach(u -> System.out.println(u));
		setDown();
	}

	public static void eGroupingBy() {
		setUp();
		Map<Character, List<Usuario>> listaLetras = usuarios.stream()
				.collect(Collectors.groupingBy(u -> u.getNombre().charAt(0)));
		// listaLetras.get("U").forEach(u -> System.out.println(u));

		setDown();
	}

}
