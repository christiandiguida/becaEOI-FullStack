package com.chris.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EoiPostgres {

    private static final String url = "jdbc:postgresql://localhost:5432/eventos";
    private static final String user = "postgres";
    private static final String password = "postgres";
    private static Connection con = null;
    private static Statement st = null;
    private static final String sql = "SELECT id, nombre, descripcion, precio, fecha FROM public.evento;";

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

    public static void insertTabla(String sql) {
        try {
            st.executeUpdate(sql);
            System.out.println("La insert se executò correctamente.");
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        // probarConexion();
        // probarConexion2();
        conexion();
        insertTabla(
                "insert into evento (nombre,descripcion,precio,fecha) values('fullstack','ejemplo insert',10.50,'03/04/2021') ");
        // selectBasica(sql);
        desconexion();
    }
}
