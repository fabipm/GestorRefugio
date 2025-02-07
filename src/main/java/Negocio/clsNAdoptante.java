/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Config.Conexion;
import Entidad.clsEAdoptante;
import Entidad.clsEDistrito;
import Entidad.clsEVoluntario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author zouoz
 */
public class clsNAdoptante {
        Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs; //almaceba datos en la consulta
    Statement st;
    clsEVoluntario A = new clsEVoluntario();
    public boolean mtdGuardarAdoptante(clsEAdoptante objEAdop, clsEDistrito objDi) {
    String dni = objEAdop.getDni();
    
    // Consulta SQL para verificar la existencia de un adoptante con el mismo DNI
    String consultaSQL = "SELECT dni FROM adoptante WHERE dni = ?";
    
    try (Connection con = cn.getConnection();
         PreparedStatement psConsulta = con.prepareStatement(consultaSQL)) {
         
        psConsulta.setString(1, dni);
        
        try (ResultSet rs = psConsulta.executeQuery()) {
            if (rs.next()) {
                // Si la consulta devuelve resultados, significa que ya existe un adoptante con el mismo DNI
                JOptionPane.showMessageDialog(null, "Ya existe un adoptante con el mismo DNI en la base de datos.");
                System.out.println("Ya existe un adoptante con el mismo DNI en la base de datos.");
                return false; // Devolver false indicando que no se pudo guardar el adoptante
            }
        }
        
        // Si no hay otro adoptante con el mismo DNI, proceder con la inserción
        System.out.println("Insertando nuevo adoptante...");
        
        String SQL = "INSERT INTO adoptante(fecha, nombres, apellidopaterno, apellidomaterno, idDistrito, genero, ocupacion, celular, edad, dni) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(SQL)) {
            ps.setDate(1, java.sql.Date.valueOf(objEAdop.getFecha()));
            ps.setString(2, objEAdop.getNombres());
            ps.setString(3, objEAdop.getApellidoPaterno());
            ps.setString(4, objEAdop.getApellidoMaterno());
            ps.setInt(5, objDi.getIddistrito());
            ps.setString(6, objEAdop.getGenero().toString());
            ps.setString(7, objEAdop.getOcupacion());
            ps.setString(8, objEAdop.getCelular());
            ps.setString(9, objEAdop.getEdad());
            ps.setString(10, dni);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Adoptante guardado exitosamente.");
            } else {
                System.out.println("Error al intentar guardar el adoptante.");
            }
            return rowsAffected > 0;
        }

    } catch (SQLException e) {
        System.out.println("Error al guardar el adoptante: " + e.getMessage());
        return false;
    }
}
      
    public String obtenerIdAdoptante() {
            String idAdoptante = "-1"; // Valor por defecto si no se encuentra ningún adoptante
    String SQL = "SELECT idAdoptante FROM adoptante ORDER BY idAdoptante DESC LIMIT 1";

    try {
        con = cn.getConnection();
        ps = con.prepareStatement(SQL);
        rs = ps.executeQuery();

        if(rs.next()) {
            idAdoptante = String.valueOf(rs.getInt("idAdoptante"));
        }

        return idAdoptante;
    } catch (SQLException e) {
        System.out.println("Error: " + e.toString());
        return idAdoptante;
    } finally {
        try {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexiones: " + e.toString());
        }
    }
    }
    
}
