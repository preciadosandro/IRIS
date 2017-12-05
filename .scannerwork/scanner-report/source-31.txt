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

import com.jjcsn.model.ISolicitud;
import com.jjcsn.impl.SolicitudImpl;

/**
 *
 * @author spreciado
 */
@WebService(serviceName = "produccionWs")
@Stateless()
public class produccionWs {

    /**
     * This is a sample web service operation
     * @param producto
     * @param cantidad
     * @param observacion
     * @return Ok si existe
     */
    @WebMethod(operationName = "registrarSolicitud")
    public String registrarSolicitud(
            @WebParam(name = "producto") String producto,
            @WebParam(name = "cantidad") int cantidad,
            @WebParam(name = "observacion") String observacion
    ) {

        String msg = "Error registrando solicitud";
        
        if ( (producto.trim().isEmpty() || observacion.trim().isEmpty() || cantidad == 0) ) {
            msg = "Campos son obligatorios";
        }

        ISolicitud solicitud = (ISolicitud) new SolicitudImpl();
        if (solicitud.registrarSolicitud(producto, cantidad, observacion)) {
            msg = "Ok";
        }
        return msg;        
    }
}
