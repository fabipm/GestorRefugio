/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.sql.Connection;
import java.sql.ResultSet;
import Config.Conexion;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 *
 * @author RAUL
 */
public class ClsNAnimal {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;

    public ClsNAnimal() {
        con = cn.getConnection();
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
       
    public boolean insertarDatosAnimal(String nombre, String sexo, String tipo, String estado, String imagePath, String raza, String edad) {
    String sql = "INSERT INTO animal (nombre, genero, tipo, estado, foto, fecha, raza, edad) VALUES (?, ?, ?, ?, ?, NOW(), ?, ?)"; // Utiliza NOW() para obtener la fecha actual
    
    try {
        // Obtener la conexión a la base de datos
        Connection con = cn.getConnection();
        
        // Preparar la consulta SQL
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, sexo);
        ps.setString(3, tipo);
        ps.setString(4, estado);
        
        // imagePath contiene la ruta de la imagen seleccionada, así que deberías convertirla a bytes
        File file = new File(imagePath);
        FileInputStream fis = new FileInputStream(file);
        ps.setBinaryStream(5, fis, (int) file.length());
        
        // Agregar la raza y la edad
        ps.setString(6, raza);
        ps.setString(7, edad);
        
        // Ejecutar la consulta de inserción
        int filasInsertadas = ps.executeUpdate();
        
        // Verificar si se insertaron filas
        if (filasInsertadas > 0) {
            return true; // Se insertaron los datos correctamente
        } else {
            return false; // No se pudo insertar los datos
        }
    } catch (SQLException | FileNotFoundException ex) {
        System.out.println("Error al insertar los datos del animal: " + ex.toString());
        return false;
    }
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
    
    public ResultSet buscarAnimalPorId(int idAnimal) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = cn.getConnection();
            String sql = "SELECT idAnimal, nombre, raza, edad, fecha, estado, genero, tipo FROM animal WHERE idAnimal = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAnimal);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al buscar el animal por ID: " + ex.getMessage());
        }
        return rs;
    }


    public boolean actualizarDatosAnimalsinfoto(int idAnimal, String nuevoNombre, String nuevoSexo, String nuevoTipo, String nuevoEstado, String nuevaRaza, String nuevaEdad) {
    String sql = "UPDATE animal SET nombre = ?, genero = ?, tipo = ?, estado = ?, raza = ?, edad = ? WHERE idAnimal = ?";
    
    try {
        // Obtener la conexión a la base de datos
        Connection con = cn.getConnection();
        
        // Preparar la consulta SQL
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nuevoNombre);
        ps.setString(2, nuevoSexo);
        ps.setString(3, nuevoTipo);
        ps.setString(4, nuevoEstado);
        ps.setString(5, nuevaRaza); 
        ps.setString(6, nuevaEdad); 
        ps.setInt(7, idAnimal);
        
        // Ejecutar la consulta de actualización
        int filasActualizadas = ps.executeUpdate();
        
        // Verificar si se actualizaron filas
        if (filasActualizadas > 0) {
            return true; // Se actualizaron los datos correctamente
        } else {
            return false; // No se pudo actualizar los datos
        }
    } catch (SQLException ex) {
        System.out.println("Error al actualizar los datos del animal: " + ex.getMessage());
        return false;
    }
}

    public boolean actualizarDatosAnimal(int idAnimal, String nuevoNombre, String nuevoSexo, String nuevoTipo, String nuevoEstado, String nuevaRaza, String nuevaEdad, String imagePath) {
    String sql = "UPDATE animal SET nombre = ?, genero = ?, tipo = ?, estado = ?, raza = ?, edad = ?, foto = ? WHERE idAnimal = ?";
    
    try {
        // Obtener la conexión a la base de datos
        Connection con = cn.getConnection();
        
        // Preparar la consulta SQL
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nuevoNombre);
        ps.setString(2, nuevoSexo);
        ps.setString(3, nuevoTipo);
        ps.setString(4, nuevoEstado);
        ps.setString(5, nuevaRaza); 
        ps.setString(6, nuevaEdad); 
        
        // Verificar si hay una nueva imagen seleccionada
        if (imagePath != null) {
            // Convertir la ruta de la imagen a bytes
            File file = new File(imagePath);
            FileInputStream fis = new FileInputStream(file);
            ps.setBinaryStream(7, fis, (int) file.length());
        } else {
            // Si no hay imagen seleccionada, establecer el valor de foto como null
            ps.setNull(7, java.sql.Types.BLOB);
        }
        
        // Establecer el ID del animal para la actualización
        ps.setInt(8, idAnimal);
        
        // Ejecutar la consulta de actualización
        int filasActualizadas = ps.executeUpdate();
        
        // Verificar si se actualizaron filas
        if (filasActualizadas > 0) {
            return true; // Se actualizaron los datos correctamente
        } else {
            return false; // No se pudo actualizar los datos
        }
    } catch (SQLException | FileNotFoundException ex) {
        System.out.println("Error al actualizar los datos del animal: " + ex.getMessage());
        return false;
    }
}
}
