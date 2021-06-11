package com.chris;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    public static final String DIRECTORIO = "EclipseWorkSpace/ejercicioclases/src/main/java/com/chris/ficheros/";
    public static final String FICHERO_SANTANDER = "santander.txt";
    public static final String FICHERO_SABADELL = "sabadell.txt";
    public static final String FICHERO_CAIXA = "caixa.txt";
    public static List<CuentaSantander> cuentasSantander = new ArrayList<CuentaSantander>();
    public static List<CuentaSabadell> cuentasSabadell = new ArrayList<>();
    public static List<CuentaCaixa> cuentasCaixa = new ArrayList<>();
    public static List<Cuenta> cuentas = new ArrayList<>();
    public static List<Cuenta> cuentasUnicas = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static Map<String, Clientes> clientes = new HashMap<String, Clientes>();

    public static String crearRutaCompleta(String fichero) {
        return DIRECTORIO + fichero;
    }

    public static List<String> leerLineas(String rutaCompleta) {
        try {
            return Files.readAllLines(Paths.get(rutaCompleta), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void crearCuentasBancos() {
        List<String> lineasSantander = leerLineas(crearRutaCompleta(FICHERO_SANTANDER));
        List<String> lineasSabadell = leerLineas(crearRutaCompleta(FICHERO_SABADELL));
        List<String> lineasCaixa = leerLineas(crearRutaCompleta(FICHERO_CAIXA));
        lineasSantander.forEach(l -> {
            cuentasSantander.add(new CuentaSantander(l, true));
        });
        lineasSabadell.forEach(l -> {
            cuentasSabadell.add(new CuentaSabadell(l, NivelCatalan.MEDIO));
        });
        lineasCaixa.forEach(l -> {
            cuentasCaixa.add(new CuentaCaixa(l, NivelCatalan.MEDIO));
        });

    }

    // public static void obtnerCuentasUnicas() {
    // cuentas.forEach(c -> {

    // });
    // Map<String, DoubleSummaryStatistics> cuentasMap = cuentas.stream()
    // .collect(Collectors.groupingBy((Cuenta::getDni),
    // Collectors.summarizingDouble(Cuenta::getSaldo)));

    // }

    public static void unirListas() {
        cuentas.addAll(cuentasSantander);
        cuentas.addAll(cuentasSabadell);
        cuentas.addAll(cuentasCaixa);
        // Cuenta.imprimirListaHijos(cuentas);
    }

    public static <T> int numeroAleatorio(List<T> lista) {
        return (int) Math.floor(Math.random() * lista.size());
    }

    public static <T> void eliminarCuentaAleatoriamente(List<T> lista) {
        lista.remove(numeroAleatorio(lista));

    }

    public static void buscarElementoBorrado() {
        if (!cuentas.containsAll(cuentasSantander)) {
            cuentasSantander.forEach(c -> {
                if (!cuentas.contains(c)) {
                    System.out.println("La Cuenta borrada es " + c);
                }
            });
        }
        if (!cuentas.containsAll(cuentasSabadell)) {
            cuentasSabadell.forEach(c -> {
                if (!cuentas.contains(c)) {
                    System.out.println("La Cuenta borrada es " + c);
                }
            });
        }
        if (!cuentas.containsAll(cuentasCaixa)) {
            cuentasCaixa.forEach(c -> {
                if (!cuentas.contains(c)) {
                    System.out.println("La Cuenta borrada es " + c);
                }
            });
        }
    }

    public static void metodoBancoSantander() {
        System.out.println(cuentasSantander.stream().mapToDouble(c -> c.getSaldo()).sum());
        System.out.println(CuentaSantander.getNumeroCuentasSantander());
        System.out.println(cuentasSantander.stream().mapToDouble(c -> c.getSaldo()).max());

    }

    // public static void main(String[] args) {
    // System.out.println("Esta son nuestras cuentas");
    // crearCuentasBancos();
    // unirListas();
    // eliminarCuentaAleatoriamente(cuentas);
    // buscarElementoBorrado();

    // metodoBancoSantander();

    // }

    public static void imprimirMenu() {
        System.out.println("Bienvenido al Banco. Escoje una opcion: ");
        System.out.println("1 - Obtener Saldo Cliente: ");
        System.out.println("2 - Obtener Lista Morosos y no Morosos : ");
        System.out.println("3 - Obtener Cliente Preferido: ");
        System.out.println("4 - Obtener Clientes por Nombre: ");
        System.out.println("5 - Obtener Clientes Concretos: ");
    }

    public static double obtenerSaldoCliente(String dni) {
        return cuentas.stream().filter(e -> e.getDni().equals(dni)).mapToDouble(Cuenta::getSaldo).sum();
    }

    public static void crearClientes() {
        cuentas.forEach(c -> {
            if (!clientes.containsKey(c.getDni())) {
                clientes.put(c.getDni(), new Clientes(c.getDni(), c.getNombre(), c.getSaldo()));
            } else {
                clientes.put(c.getDni(), new Clientes(c.getDni(), c.getNombre(),
                        clientes.get(c.getDni()).getSaldoTotal() + c.getSaldo()));
            }
        });
    }

    public static void opcion1() {
        System.out.println("Insertar el DNI del cliente: ");
        String dni = sc.next();
        Map<String, Double> result = cuentas.stream().filter(c -> c.getDni().equals(dni))
                .collect(Collectors.groupingBy(Cuenta::getNombre, Collectors.summingDouble(Cuenta::getSaldo)));
        result.forEach((k, v) -> System.out.println("La suma total de las cuentas de " + k + " es " + v));
    }

    public static void opcion2() {

        cuentas.stream().collect(Collectors.groupingBy(Cuenta::getNombre, Collectors.summingDouble(Cuenta::getSaldo)))
                .forEach((k, v) -> System.out
                        .println((v < 0) ? "Clientes Moroso: " + k + " " + v : "Clientes No Moroso: " + k + " " + v));
        // System.out.println("Clientes No Morosos: ");
        // cuentas.stream().filter(c -> c.getSaldo() > 0)
        // .collect(Collectors.groupingBy(Cuenta::getNombre,
        // Collectors.summingDouble(Cuenta::getSaldo)))
        // .forEach((k, v) -> System.out.println(k + " " + v));
    }

    public static void opcion3() {
        System.out
                .println(cuentas.stream().max(Comparator.comparing(c -> obtenerSaldoCliente(c.getDni()))).orElse(null));
        // .values()
        // .stream().max(Comparator.naturalOrder()).get());

    }

    public static void opcion4() {
        System.out.println("Insertar un nombre: ");
        String nombre = sc.next();
        // cuentas.stream().filter(c->c.getNombre().toLowerCase())
    }

    public static void main(String[] args) {
        crearCuentasBancos();
        unirListas();
        crearClientes();
        clientes.forEach((k, v) -> System.out.println(k + " " + v));
        imprimirMenu();
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                opcion1();
                break;
            case 2:
                opcion2();
                break;
            case 3:
                opcion3();
                break;
            case 4:
                opcion4();
                break;
            case 5:

                break;

            default:
                break;
        }

    }
}
