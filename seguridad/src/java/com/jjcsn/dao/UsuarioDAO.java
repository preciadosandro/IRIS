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

/**
 *
 * @author spreciado
 */
public class UsuarioDAO {
    private Connection DBConnection = null;

    public UsuarioDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }

    public boolean validarUsuario(String usuario, String clave) {
        PreparedStatement prepStm = null;
        final String SQL = "SELECT NOMBRES FROM TBUSUARIO WHERE USUARIO=? and CLAVE=?";

        try {
            prepStm = this.DBConnection.prepareStatement(SQL);
            prepStm.setString(1, usuario);
            prepStm.setString(2, clave);
            ResultSet RS = prepStm.executeQuery();
            if (RS.next()) {
                return !RS.getString("NOMBRES").equals("");
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, SQL, ex);
            return false;
        }
    }
    
}
