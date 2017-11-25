/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jjcsn.ws;

import com.jjcsn.dao.SolicitudDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

import com.jjcsn.services.Database;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public String validarUsuario(
            @WebParam(name = "producto") String producto,
            @WebParam(name = "cantidad") int cantidad,
            @WebParam(name = "observacion") String observacion
    ) {
        Database db = new Database();
        String msg = "Error registrando solicitud";
        try {
            SolicitudDAO dao = new SolicitudDAO(db.getConn());
            if (dao.registrarSolicitud(producto, cantidad, observacion)) {
                msg = "Ok";
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(produccionWs.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConn();
        }
        return msg;
    }
}
