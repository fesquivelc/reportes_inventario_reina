package com.inventario.entidades;

import java.io.Serializable;

import java.lang.Long;
import java.lang.String;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="provs")
public  class Proveedor implements Serializable {


    @Column(name="id",table="provs",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    @Column(name="direccion",table="provs")
    @Basic
    private String direccion;


    @Column(name="contacto",table="provs")
    @Basic
    private String contacto;


    @Column(name="prov",table="provs",nullable=false)
    @Basic
    private String prov;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Documento.class,mappedBy="proveedor")
    private List<Documento> documentos;


    @Column(name="ruc",table="provs")
    @Basic
    private String ruc;


    @Column(name="telefono",table="provs",length=45)
    @Basic
    private String telefono;

    public Proveedor(){

    }


   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public String getDireccion() {
        return this.direccion;
    }


  public void setDireccion (String direccion) {
        this.direccion = direccion;
    }



   public String getContacto() {
        return this.contacto;
    }


  public void setContacto (String contacto) {
        this.contacto = contacto;
    }



   public String getProv() {
        return this.prov;
    }


  public void setProv (String prov) {
        this.prov = prov;
    }



   public List<Documento> getDocumentos() {
        return this.documentos;
    }


  public void setDocumentos (List<Documento> documentos) {
        this.documentos = documentos;
    }



   public String getRuc() {
        return this.ruc;
    }


  public void setRuc (String ruc) {
        this.ruc = ruc;
    }



   public String getTelefono() {
        return this.telefono;
    }


  public void setTelefono (String telefono) {
        this.telefono = telefono;
    }

}

