/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jjcsn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jjcsn.services.Database;
import com.jjcsn.model.Usuario;

/**
 *
 * @author spreciado
 */
public class UsuarioDAO {
    private Connection DBConnection = null;

    public UsuarioDAO() {
        try {
            Database db = new Database();
            this.DBConnection = db.getConn();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UsuarioDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }

    public Usuario getUsuario(String usuario, String clave) {
        Usuario user = null;
        PreparedStatement prepStm;
        final String SQL = "SELECT " + 
                "ID, USUARIO, CLAVE, NOMBRES, APELLIDOS, TELEFONO, DIRECCION, SEXO, AREA, ID_ROL " +
                "FROM TBUSUARIO " +
                "WHERE USUARIO=? and CLAVE=?";
        try {
            prepStm = this.DBConnection.prepareStatement(SQL);
            prepStm.setString(1, usuario);
            prepStm.setString(2, clave);
            ResultSet RS = prepStm.executeQuery();
            if (RS.next()) {
                user = new Usuario();
                user.setId(RS.getLong("ID"));
                user.setUsuario(RS.getString("USUARIO"));
                user.setClave(RS.getString("CLAVE"));
                user.setNombres(RS.getString("NOMBRES"));
                user.setApellidos(RS.getString("APELLIDOS"));
                user.setTelefono(RS.getLong("TELEFONO"));
                user.setDireccion(RS.getString("DIRECCION"));
                user.setSexo(RS.getString("SEXO"));
                user.setArea(RS.getString("AREA"));
                user.setIdRol(RS.getLong("ID_ROL"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, SQL, ex);
        }
        return user;
    }
    
}
