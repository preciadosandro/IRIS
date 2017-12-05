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

import com.jjcsn.model.IUsuario;
import com.jjcsn.impl.UsuarioImpl;

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
        String msg = "Usuario no existe.";
        
        if ( (user.trim().isEmpty() || pass.trim().equals("")) ) {
            msg = "Usuario y clave son obligatorios";           
        }

        IUsuario usr = (IUsuario) new UsuarioImpl();
        if (usr.validarUsuario(user, pass)) {
            msg = "Ok";
        }
        return msg;
    }
}
