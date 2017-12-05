/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jjcsn.impl;

import com.jjcsn.model.Stock;
import com.jjcsn.model.IStock;
import com.jjcsn.dao.StockDAO;
/**
 *
 * @author spreciado
 */
public class StockImpl implements IStock {

    StockDAO dao;
    
    @Override
    public int stockActualProducto(String producto) {
        dao = new StockDAO();
        Stock stock = dao.stockProducto(producto);
        
        if (stock!=null && stock.getId()!=0) {
            return stock.getCantidad();
        }
        return 0;
    }

    @Override
    public boolean updateStockProducto(String producto, int cantidad) {
        dao = new StockDAO();
        return dao.updateStockProducto(producto, cantidad);
    }
    
}
