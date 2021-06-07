package com.chris;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static final String directorioFicheros = "ejerciciobanco/ficheros";
    public static final String directorioProductos = "ejerciciobanco/productos";
    public static Map<String, Cliente> clientes = crearListaClientes();
    public static Cliente clienteLoggeado = new Cliente();
    public static List<ProductoFinanciero> productosFinancieros = crearProductos();

    public static void main(String[] args) throws IOException {
        crearListaClientes();
        System.out.println("Bienvenidos a la nuestra empresa.\nPorfavor, introduzca su DNI:");
        Scanner sc = new Scanner(System.in);
        String dniCliente = sc.next();
        clienteLoggeado = clientes.get(dniCliente);
        definirEdadClienteLoggeado();
        bienvenida();
        definirProductoCliente();
        imprimirProductoCliente();
        sc.close();
    }

    public static List<String> obtenerFicherosDirectorios(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        List<String> ficheros = new ArrayList<String>(Arrays.asList(directorio.list()));
        ficheros.remove(".DS_Store");
        return ficheros;
    }

    public static List<List<String>> obtenerDatosClientesBancas() throws IOException {
        List<List<String>> listaDatosClientesBancas = new ArrayList<List<String>>();
        List<String> ficheros = obtenerFicherosDirectorios(directorioFicheros);
        List<Path> directoriosFicheros = new ArrayList<Path>();
        ficheros.forEach(f -> {
            Path nuevoDirectorioBanca = Paths.get(directorioFicheros + "/" + f);
            directoriosFicheros.add(nuevoDirectorioBanca);
        });
        directoriosFicheros.forEach(d -> {
            try {
                List<String> listaDatosClientes = Files.readAllLines(d);
                listaDatosClientesBancas.add(listaDatosClientes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return listaDatosClientesBancas;
    }

    public static Map<String, Cliente> crearListaClientes() {
        Map<String, Cliente> clientes = new HashMap<String, Cliente>();
        List<List<String>> datosClientesBancas;
        try {
            datosClientesBancas = obtenerDatosClientesBancas();
            datosClientesBancas.forEach(datosBanca -> datosBanca.forEach(datoCliente -> {
                String[] datosClienteSeparados = datoCliente.split(";");
                LocalDate fechaNacimiento = LocalDate.parse(datosClienteSeparados[2],
                        DateTimeFormatter.ofPattern("d/M/yyyy"));
                Cliente cliente = new Cliente(datosClienteSeparados[0], datosClienteSeparados[1], fechaNacimiento,
                        datosClienteSeparados[3], Double.parseDouble(datosClienteSeparados[4]));
                if (clientes.containsKey(cliente.getDniCliente())) {
                    Cliente nuevoCliente = cliente;
                    nuevoCliente.setSaldo(clientes.get(cliente.getDniCliente()).getSaldo() + cliente.getSaldo());
                    clientes.put(cliente.getDniCliente(), nuevoCliente);
                } else {
                    clientes.put(cliente.getDniCliente(), cliente);
                }
            }));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public static void bienvenida() {
        if (clienteLoggeado.getCodigoPais().toLowerCase().equals("es")) {
            System.out.println("Bienvenido al banco Sre/a " + clienteLoggeado.getNombreCliente());
        } else {
            System.out.println("Welcome to the bank Mr/Ms " + clienteLoggeado.getNombreCliente());
        }
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss d/M/yyyy")));
    }

    public static List<Path> obtenerRutasProductosBanca() {
        File file = new File(directorioProductos);
        List<String> listaFicherosProductos = new ArrayList<String>(Arrays.asList(file.list()));
        List<Path> rutasFicherosProductos = new ArrayList<Path>();
        listaFicherosProductos.forEach(l -> {
            Path nuevaRuta = Paths.get(directorioProductos + "/" + l);
            rutasFicherosProductos.add(nuevaRuta);
        });
        return rutasFicherosProductos;
    }

    public static List<List<String>> obtenerDatosProductosBanca() {
        List<Path> rutasFicherosProductos = obtenerRutasProductosBanca();
        List<List<String>> listaProductosBancas = new ArrayList<List<String>>();
        rutasFicherosProductos.forEach(r -> {
            try {
                List<String> productosBanca = Files.readAllLines(r);
                listaProductosBancas.add(productosBanca);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return listaProductosBancas;
    }

    public static List<ProductoFinanciero> crearProductos() {
        List<List<String>> listaProductosBancas = obtenerDatosProductosBanca();
        List<ProductoFinanciero> productosFinancieros = new ArrayList<ProductoFinanciero>();
        listaProductosBancas.forEach(listaProductos -> listaProductos.forEach(lineaProducto -> {
            String[] datosProductoSeparados = lineaProducto.split(";");
            ProductoFinanciero nuevoProducto = new ProductoFinanciero(Integer.parseInt(datosProductoSeparados[0]),
                    Integer.parseInt(datosProductoSeparados[1]), Double.parseDouble(datosProductoSeparados[2]),
                    Double.parseDouble(datosProductoSeparados[3]), datosProductoSeparados[4]);
            productosFinancieros.add(nuevoProducto);
        }));
        return productosFinancieros;
    }

    public static void definirEdadClienteLoggeado() {
        clienteLoggeado.setEdad(Period.between(clienteLoggeado.getFechaNacimiento(), LocalDate.now()).getYears());
    }

    public static void definirProductoCliente() {
        List<ProductoFinanciero> productosClienteLoggeado = new ArrayList<ProductoFinanciero>();
        productosFinancieros.forEach(p -> {
            if (clienteLoggeado.getEdad() >= p.getEdadMinima() && clienteLoggeado.getEdad() <= p.getEdadMaxima()
                    && clienteLoggeado.getSaldo() >= p.getSaldoMinimo()
                    && clienteLoggeado.getSaldo() <= p.getSaldoMaximo()) {
                productosClienteLoggeado.add(p);
            }
        });
        ProductoFinanciero producto = productosClienteLoggeado.stream()
                .max(Comparator.comparing(ProductoFinanciero::getSaldoMinimo)).orElseThrow();
        clienteLoggeado.setProductoFinanciero(producto);

    }

    public static void imprimirProductoCliente() {
        if (clienteLoggeado.getProductoFinanciero() != null) {
            System.out.println("El producto seleccionado para usted es "
                    + clienteLoggeado.getProductoFinanciero().getNombreProducto());
        }
    }

}
