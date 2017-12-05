/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jjcsn.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

import com.jjcsn.model.IStock;
import com.jjcsn.impl.StockImpl;

/**
 *
 * @author spreciado
 */
@WebService(serviceName = "stockWs")
@Stateless()
public class StockWs {

    /**
     * This is a sample web service operation
     * @param producto codigo del producto
     * @return cantidad de elementos en stock
     */
    @WebMethod(operationName = "stockActualProducto")
    public int stockActualProducto( @WebParam(name = "producto") String producto ) {

        if (producto.trim().isEmpty()) {
            return -1;
        }

        IStock stock = (IStock) new StockImpl();
        return stock.stockActualProducto(producto);
    }
}
