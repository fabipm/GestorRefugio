/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Config.Conexion;
import Entidad.clsEAdmin;
import Entidad.clsEAdoptante;
import Entidad.clsEDistrito;
import Entidad.clsEEvidencia;
import Entidad.clsEFormularioAdopcion;
import Entidad.clsEVoluntario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author mario
 */
public class clsNFormularioAdopcion {
    //Variables de conexion
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs; //almaceba datos en la consulta
    Statement st;
    clsEVoluntario A = new clsEVoluntario();
    //public String dniGlobal; // Variable global

    public boolean mtdGuardarFormulario(clsEFormularioAdopcion objFo,clsEVoluntario objVO, clsEEvidencia objEVI) {
        String SQL ="INSERT INTO formularioadopcion(fecha,idvoluntario,p1,p2,p3,p4,p5,idusuarioregistro,estado,idEvidencia,dniIngresante)"
               + "VALUES ('"+objFo.getFecha()+"','"+objVO.getIdVoluntario()+"','"+objFo.getP1()+"','"+objFo.getP2()
               +"','"+objFo.getP3()+"','"+objFo.getP4()+"','"+objFo.getP5()+"','"
                +objFo.getEstado()+"','"+objEVI.getIdevidencia()+"','"+ objFo.getNombre()+"')";
        

        System.out.println(SQL);
        try {
            Conexion cn = new Conexion();
            Connection con = cn.getConnection();
            Statement st=con.createStatement();
            st.executeUpdate(SQL);
            return true; // Registro exitoso
            
        } catch (SQLException e){
            System.out.println("error"+e.toString());
            return false; // Fallo en el registro
        }
    }

    public boolean mtdGuardarFormulario(clsEFormularioAdopcion objFo, clsEAdoptante objAdop, clsEEvidencia objEVI) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                String SQL ="INSERT INTO formularioadopcion(fecha,p1,p2,p3,p4,p5,estado,idEvidencia,idAdoptante,nombre)"
               + "VALUES ('"+objFo.getFecha()+"','"+objFo.getP1()+"','"+objFo.getP2()+"','"+objFo.getP3()+"','"
               +objFo.getP4()+"','"+objFo.getP5()+"','"+objFo.getEstado()
               +"','"+objEVI.getIdevidencia()+"','"+objAdop.getIdAdoptante()+"','"+ objFo.getNombre()+"')";
        

        System.out.println(SQL);
        try {
            Conexion cn = new Conexion();
            Connection con = cn.getConnection();
            Statement st=con.createStatement();
            st.executeUpdate(SQL);
            return true; // Registro exitoso
            
        } catch (SQLException e){
            System.out.println("error"+e.toString());
            return false; // Fallo en el registro
        }
    }
//
//    public void asignarDniIngresante(String DniIngresante) {
//        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        this.dniGlobal = DniIngresante;
//       // return Dni;
//    }

    public String obtenerNombre(String dni) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String nombre = "";
    try {
        // Establecer conexión con la base de datos
        Connection con = cn.getConnection(); 

        // Consultar en la tabla admin
        String sqlAdmin = "SELECT nombre FROM administrador WHERE dni = ?";
        ps = con.prepareStatement(sqlAdmin);
        ps.setString(1, dni);
        rs = ps.executeQuery();

        // Si se encuentra en la tabla admin, asignar el nombre
        if (rs.next()) {
            nombre = rs.getString("nombre");
        } else {
            // Si no se encuentra en la tabla admin, consultar en la tabla voluntario
            String sqlVoluntario = "SELECT nombres FROM voluntario WHERE dni = ?";
            ps = con.prepareStatement(sqlVoluntario);
            ps.setString(1, dni);
            rs = ps.executeQuery();

            // Si se encuentra en la tabla voluntario, asignar el nombre
            if (rs.next()) {
                nombre = rs.getString("nombres");
            }
        }

        // Cerrar conexión y recursos
        rs.close();
        ps.close();
        con.close();
    } catch (SQLException e) {
        System.out.println("Error: " + e.toString());
    }
    return nombre;

    }
    
    
    
    
    
    public ResultSet mtdListarProcesoAdopcion() {
        ResultSet rs = null;
        String sql = "SELECT fa.idFormularioAdopcion, fa.fecha, fa.estado, a.idAdoptante, e.idEvidencia,fa.nombre FROM formularioadopcion fa "
                + "INNER JOIN adoptante a ON fa.idAdoptante = a.idAdoptante "
                + "INNER JOIN evidencia e ON fa.idEvidencia = e.idEvidencia";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch(SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }

    public String obtenerNombreAdoptante(int idAdoptante) {
        String nombreAdoptante = "";
        try {
            String sql = "SELECT nombres FROM adoptante WHERE idAdoptante = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAdoptante);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombreAdoptante = rs.getString("nombres");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nombreAdoptante;
    }

    public String obtenerDescripcionEvidencia(int idEvidencia) {
        String descripcionEvidencia = "";
        try {
            String sql = "SELECT nombre FROM evidencia WHERE idEvidencia = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEvidencia);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                descripcionEvidencia = rs.getString("nombre");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return descripcionEvidencia;

    }

    public void actulizarProceso(clsEFormularioAdopcion objFA, clsEEvidencia objEE) {
        String SQL = "UPDATE formularioadopcion SET estado = ?, idEvidencia = ? WHERE idFormularioAdopcion = ?";
    
        try {
            Conexion cn = new Conexion();
            Connection con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);

            // Establecer los valores de los parámetros en la consulta preparada
            ps.setString(1, objFA.getEstado().toString()); // Convertir el Estado a String
            ps.setInt(2, objEE.getIdevidencia());
            ps.setInt(3, objFA.getIdformularioadopcion());

            // Ejecutar la consulta
            ps.executeUpdate();

            System.out.println("Actualización exitosa");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el proceso: " + e.toString());
        }

    }
    
    


    
    
}

    



