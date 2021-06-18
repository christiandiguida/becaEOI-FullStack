package com.chris.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utilidades.JdbcUtils;

public class EoiPostgres {

    private static final String url = "jdbc:postgresql://localhost:5432/eventos";
    private static final String user = "postgres";
    private static final String password = "postgres";
    private static Connection con = null;
    private static Statement st = null;
    private static PreparedStatement ps = null;
    private static Scanner sc = new Scanner(System.in);
    private static String sql = "SELECT id, nombre, descripcion, precio, fecha FROM public.evento;";

    public static void probarConexion() {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("funcionakkkkk");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Viejo metodo
    public static void probarConexion2() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("funciona");
        } catch (Exception e) {
        }

    }

    public static void conexion() {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
        } catch (Exception e) {
        }
    }

    public static void desconexion() {
        try {
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectBasica(String sql) {
        ResultSet rs = null;
        try {
            rs = st.executeQuery(sql);
            int registros = 0;
            while (rs.next()) {
                registros++;
                System.out.println(rs.getLong("id") + " " + rs.getString("nombre") + " " + rs.getString("descripcion"));
            }
            System.out.println("El total de registros es: " + registros);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static String sqlInjectionTest() {
        System.out.println("Introduzca el nombre del evento: ");
        return sc.nextLine();
    }

    public static void insertTabla(String sql) {
        try {
            st.executeUpdate(sql);
            System.out.println("La insert se executò correctamente.");
        } catch (Exception e) {
        }
    }

    public static void borrarRegistroTabla(String sql) {
        try {
            int numeroFIlas = st.executeUpdate(sql);
            System.out.println(
                    (numeroFIlas > 0) ? "El delete se ejecuto correctamente y se borraron " + numeroFIlas + " filas."
                            : "Nada ha sido borrado");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("El metodo no ha funcionado");
        }
    }

    public static void modificarRegistroTabla(String sql) {
        try {
            int numeroFIlas = st.executeUpdate(sql);
            System.out.println((numeroFIlas > 0)
                    ? "El update se ejecuto correctamente y se actualizaron " + numeroFIlas + " filas."
                    : "Nada ha sido actualizado.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("El metodo no ha funcionado");
        }
    }

    public static void modificarRegistroTablaPreparedStatement(String sql) {
        System.out.println("Introduzca el id a modificar: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Introduzca el nombre a modificar: ");
        String nombre = sc.nextLine();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("El registro numero " + id + " ha sido modificado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void selectBasica() {
        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(resultSet.getInt(0));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void probarStatementGenerico() {
        ResultSet rs = JdbcUtils.StatementGenerico("Select * from evento", con, url, user, password);
        try {
            while (rs.next()) {
                System.out.println(rs.getLong("id") + " " + rs.getString("nombre") + " " + rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // probarConexion();
        // probarConexion2();
        // conexion();
        // insertTabla(
        // "insert into evento (nombre,descripcion,precio,fecha)
        // values('fullstack','ejemplo insert',10.50,'03/04/2021') ");
        // selectBasica(sql);
        // borrarRegistroTabla(sql);
        // modificarRegistroTabla();
        // selectBasica("Select * from evento where nombre = '" + sqlInjectionTest() +
        // "'");
        probarStatementGenerico();
        // modificarRegistroTablaPreparedStatement(sql);
        // desconexion();

    }
}
