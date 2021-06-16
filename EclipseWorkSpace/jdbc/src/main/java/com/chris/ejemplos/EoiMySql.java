package com.chris.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EoiMySql {
    private static final String url = "jdbc:mysql://localhost:3306/eoi";
    private static final String user = "root";
    private static final String password = "12341234";
    private static final String sql = "SELECT * FROM eoi.oficinas where region = ? and ciudad = ?";

    public static void probarConexion() {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("funcionakkkkk");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void selectStatementScroll(String sql) {
        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY)) {
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.afterLast();
            while (resultSet.previous()) {
                System.out.println(resultSet.getString("oficina"));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void selectStatementModificado(String sql) {
        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE)) {
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.absolute(4);
            resultSet.updateString("ciudad", "EOI");
            resultSet.updateRow();
            System.out.println("La fila ha sido actualizada.");
        } catch (Exception e) {
            System.err.println(e);
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

    public static void selectStatementConInsercion(String sql) {
        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE)) {
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.moveToInsertRow();
            resultSet.updateLong("oficina", 120);
            resultSet.updateLong("dir", 101);
            resultSet.updateLong("objetivo", 1099991);
            resultSet.updateLong("ventas", 1099991);
            resultSet.updateString("region", "Region EOI");
            resultSet.updateString("ciudad", "Ciudad EOI");
            resultSet.insertRow();
            System.out.println("Fila insertada");
            resultSet.last();
            System.out.println(resultSet.getLong("oficina") + " " + resultSet.getString("ciudad") + " "
                    + resultSet.getString("region") + " " + resultSet.getInt("dir") + " "
                    + resultSet.getString("objetivo") + " " + resultSet.getInt("ventas"));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void selectStatementBorrado(String sql) {
        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE)) {
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.last();
            resultSet.deleteRow();
            // System.out.println(resultSet.getLong("oficina") + " " +
            // resultSet.getString("ciudad") + " "
            // + resultSet.getString("region") + " " + resultSet.getInt("dir") + " "
            // + resultSet.getString("objetivo") + " " + resultSet.getInt("ventas"));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Always Use PreparedStatement when users insert data
    public static void selectPreparedStatement(String sql) {
        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "Este");
            ps.setString(2, "Alicante");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                            rs.getLong("oficina") + " " + rs.getString("ciudad") + " " + rs.getString("region") + " "
                                    + rs.getInt("dir") + " " + rs.getString("objetivo") + " " + rs.getInt("ventas"));
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        // probarConexion();
        // selectBasica();
        // selectStatementScroll(sql);
        // selectStatementModificado(sql);
        // selectStatementConInsercion(sql);
        // selectStatementBorrado(sql);
        selectPreparedStatement(sql);
    }
}
