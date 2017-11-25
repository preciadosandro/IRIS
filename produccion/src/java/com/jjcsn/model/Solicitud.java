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
public class Solicitud {

    private Long id;
    private Long cantprodu;
    private String estado;
    private String observacion;
    private String producto;
    
    public Solicitud() {
    }

    public Solicitud(Long id, Long cantprodu, String estado,
        String observacion, String producto) {
        this.id = id;
        this.cantprodu = cantprodu;
        this.estado = estado;
        this.observacion = observacion;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCantprodu() {
        return cantprodu;
    }

    public void setCantprodu(Long cantprodu) {
        this.cantprodu = cantprodu;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }    
    
}
