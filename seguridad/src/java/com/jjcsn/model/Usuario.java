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
public class Usuario {

    private Long id;
    private String apellidos;
    private String area;
    private String clave;
    private String direccion;
    private Long idRol;
    private String nombres;
    private String sexo;
    private Long telefono;
    private String usuario;

    public Usuario() {
    }

    public Usuario(Long id, String apellidos, String area, String clave,
        String direccion, Long idRol, String nombres, String sexo,
        Long telefono, String usuario) {
        this.id = id;
        this.apellidos = apellidos;
        this.area = area;
        this.clave = clave;
        this.direccion = direccion;
        this.idRol = idRol;
        this.nombres = nombres;
        this.sexo = sexo;
        this.telefono = telefono;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    
}
