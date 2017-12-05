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

import com.jjcsn.services.Database;
import com.jjcsn.dao.UsuarioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author spreciado
 */
@WebService(serviceName = "seguridadWs")
@Stateless()
public class seguridadWs {

    /**
     * This is a sample web service operation
     * @param user usuario
     * @param pass clave
     * @return Ok si existe
     */
    @WebMethod(operationName = "validarUsuario")
    public String validarUsuario(
            @WebParam(name = "usuario") String user,
            @WebParam(name = "clave") String pass
    ) {
        Database db = new Database();
        String msg = "No existe usuario";
        try {
            UsuarioDAO dao = new UsuarioDAO(db.getConn());
            if (dao.validarUsuario(user, pass)) {
                msg = "Ok";
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(seguridadWs.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConn();
        }
        return msg;
    }
}
