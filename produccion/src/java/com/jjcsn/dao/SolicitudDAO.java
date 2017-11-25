/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jjcsn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author spreciado
 */
public class SolicitudDAO {
    private Connection DBConnection = null;

    public SolicitudDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }

    public boolean registrarSolicitud(String producto, int cantidad, String observacion ) {
        PreparedStatement prepStm = null;
        final String SQL = "insert into TBSOLICITUDPRODUCCCION(PRODUCTO, CANTPRODU, OBSERVACION, ESTADO)" +
                " values(?, ?, ?, ?)";

        try {
            prepStm = this.DBConnection.prepareStatement(SQL);
            prepStm.setString(1, producto);
            prepStm.setInt(2, cantidad);
            prepStm.setString(3, observacion);
            prepStm.setString(4, "A");
            prepStm.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, SQL, ex);
            return false;
        }
    }
    
}
