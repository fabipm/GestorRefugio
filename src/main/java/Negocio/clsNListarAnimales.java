/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Config.Conexion;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author RAUL
 */
public class clsNListarAnimales {
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    
    public clsNListarAnimales() {
        con = cn.getConnection();
    }
    
    public ImageIcon mostrarImagenAnimal(int idAnimal, int newWidth, int newHeight) {
    ImageIcon imagen = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = cn.getConnection();
        String sql = "SELECT foto FROM animal WHERE idAnimal = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, idAnimal);
        rs = ps.executeQuery();

        if (rs.next()) {
            byte[] imagenBytes = rs.getBytes("foto");
            // Convertir bytes a imagen
            ByteArrayInputStream bis = new ByteArrayInputStream(imagenBytes);
            BufferedImage bImage = ImageIO.read(bis);

            // Escalar la imagen
            Image scaledImage = bImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            // Crear una imagen BufferedImage a partir de la imagen escalada
            BufferedImage bufferedScaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            bufferedScaledImage.getGraphics().drawImage(scaledImage, 0, 0, null);

            // Crear el ImageIcon con la imagen escalada
            imagen = new ImageIcon(bufferedScaledImage);

            bis.close();
        }
    } catch (SQLException | IOException ex) {
        System.out.println("Error al obtener la imagen del animal: " + ex.getMessage());
    } finally {
        // Cerrar recursos
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar recursos: " + ex.getMessage());
        }
    }
    return imagen;
}
    
    public ResultSet BuscarporEstado(String activo) {
        Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = cn.getConnection();
        String sql = "SELECT idAnimal, nombre, raza, edad, fecha, estado, genero, tipo FROM animal WHERE estado = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, activo); // Set the parameter
        rs = ps.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Error al buscar el animal por estado: " + ex.getMessage());
    }
    return rs;
}
    public ResultSet mtdListarAnimal() {
    ResultSet rs = null;
    String sql = "SELECT idAnimal, nombre, raza, edad, fecha, estado, genero, tipo, foto FROM animal;"; // Incluye la raza y la edad en la consulta

    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
    } catch (SQLException e) {
        System.out.println("Error: " + e.toString());
    }

    return rs;
}   
}


