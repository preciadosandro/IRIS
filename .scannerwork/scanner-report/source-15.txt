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
public class Stock {

    private int id;
    private String codigo;
    private String nombreItem;
    private int cantidad;
    private int valorUnitario;

    public Stock() {
    }

    public Stock(int id, String codigo, String nombreItem, int cantidad, int valorUnitario) {
        this.id = id;
        this.codigo = codigo;
        this.nombreItem = nombreItem;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
}
