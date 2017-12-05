/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jjcsn.impl;

import com.jjcsn.dao.SolicitudDAO;
import com.jjcsn.model.Solicitud;
import com.jjcsn.model.ISolicitud;

/**
 *
 * @author spreciado
 */
public class SolicitudImpl implements ISolicitud{

    @Override
    public boolean registrarSolicitud(String producto, int cantidad, String observacion) {
        Solicitud solicitud = new Solicitud();
        solicitud.setProducto(producto);
        solicitud.setCantprodu(cantidad);
        solicitud.setObservacion(observacion);
        solicitud.setEstado("A");
        SolicitudDAO dao = new SolicitudDAO();
        return dao.registrarSolicitud(solicitud);
    }
    
}
