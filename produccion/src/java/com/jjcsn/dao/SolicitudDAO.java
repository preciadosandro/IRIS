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

import com.jjcsn.services.Database;
import com.jjcsn.model.Solicitud;

/**
 *
 * @author spreciado
 */
public class SolicitudDAO {
    private Connection DBConnection = null;

    public SolicitudDAO() {
        try {
            Database db = new Database();
            this.DBConnection = db.getConn();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public SolicitudDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }

    public boolean registrarSolicitud(Solicitud solicitud ) {
        PreparedStatement prepStm;
        final String SQL = "insert into TBSOLICITUDPRODUCCCION(PRODUCTO, CANTPRODU, OBSERVACION, ESTADO)" +
                " values(?, ?, ?, ?)";
        try {
            prepStm = this.DBConnection.prepareStatement(SQL);
            prepStm.setString(1, solicitud.getProducto());
            prepStm.setInt(2, solicitud.getCantprodu());
            prepStm.setString(3, solicitud.getObservacion());
            prepStm.setString(4, solicitud.getEstado());
            prepStm.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, SQL, ex);
        }
        return false;
    }
    
}
