package com.truper.demo.Dto;


import java.io.Serializable;

public class OrderDTO implements Serializable {

    private int id;
    private String estatus;
    private String descripcion;
    private int codigo;

    public OrderDTO(int id, String estatus, String descripcion, int codigo) {
        this.id = id;
        this.estatus = estatus;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
