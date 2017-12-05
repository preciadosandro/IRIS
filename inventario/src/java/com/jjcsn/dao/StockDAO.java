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
import com.jjcsn.model.Stock;
/**
 *
 * @author spreciado
 */
public class StockDAO {
    private Connection DBConnection = null;

    public StockDAO() {
        try {
            Database db = new Database();
            this.DBConnection = db.getConn();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public StockDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }

    public Stock stockProducto(String producto) {        
        Stock stock = null;
        PreparedStatement prepStm;
        final String SQL = "SELECT ID, CODIGO, NOMBRE_ITEM, CANTIDAD, VALOR_UNITARIO " +
                           "FROM TBSTOCK WHERE CODIGO=?";
        try {
            prepStm = this.DBConnection.prepareStatement(SQL);
            prepStm.setString(1, producto);
            ResultSet RS = prepStm.executeQuery();
            if (RS.next()) {
                stock = new Stock();
                stock.setId(RS.getInt("ID"));
                stock.setCodigo(RS.getString("CODIGO"));
                stock.setNombreItem(RS.getString("NOMBRE_ITEM"));
                stock.setCantidad(RS.getInt("CANTIDAD"));
                stock.setValorUnitario(RS.getInt("VALOR_UNITARIO"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, SQL, ex);
        }
        return stock;
    }

    public boolean updateStockProducto(String producto, int cantidad) {        

        PreparedStatement prepStm;
        final String SQL = "UPDATE TBSTOCK SET CANTIDAD=? WHERE CODIGO=?";
        try {
            prepStm = this.DBConnection.prepareStatement(SQL);
            prepStm.setInt(1, cantidad);
            prepStm.setString(2, producto);
            prepStm.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, SQL, ex);
        }
        return false;
    }

    
}
