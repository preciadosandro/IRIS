/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jjcsn.model;

/**
 *
 * @author spreciado
 */
public interface IStock {
    
    public int stockActualProducto(String producto);
    public boolean updateStockProducto(String producto, int cantidad);
    
}
