/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jjcsn.impl;

import com.jjcsn.model.Usuario;
import com.jjcsn.model.IUsuario;
import com.jjcsn.dao.UsuarioDAO;

/**
 *
 * @author spreciado
 */
public class UsuarioImpl implements IUsuario {

    @Override
    public boolean validarUsuario(String usuario, String clave) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usr = dao.getUsuario(usuario, clave);
        return usr != null && usr.getId()!=0;
    }
    
}
