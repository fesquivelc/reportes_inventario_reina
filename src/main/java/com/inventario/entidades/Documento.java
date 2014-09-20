package com.inventario.entidades;

import java.io.Serializable;

import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="doc")
public  class Documento implements Serializable {


    @Column(name="id",table="doc",nullable=false)
    @Id
    private Long id;


    @Column(name="anota",table="doc")
    @Basic
    private String anota;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=DocumentoDetalle.class,mappedBy="documento")
    private List<DocumentoDetalle> documentoDetalles;


    @Column(name="fecha",table="doc")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fecha;


    @Column(name="doc",table="doc",nullable=false)
    @Basic
    private String doc;


    @ManyToOne(optional=false,targetEntity=Proveedor.class)
    @JoinColumn(name="prov_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Proveedor proveedor;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Codigo.class,mappedBy="documento")
    private List<Codigo> codigos;

    public Documento(){

    }


   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public String getAnota() {
        return this.anota;
    }


  public void setAnota (String anota) {
        this.anota = anota;
    }



   public List<DocumentoDetalle> getDocumentoDetalles() {
        return this.documentoDetalles;
    }


  public void setDocumentoDetalles (List<DocumentoDetalle> documentoDetalles) {
        this.documentoDetalles = documentoDetalles;
    }



   public Date getFecha() {
        return this.fecha;
    }


  public void setFecha (Date fecha) {
        this.fecha = fecha;
    }



   public String getDoc() {
        return this.doc;
    }


  public void setDoc (String doc) {
        this.doc = doc;
    }



   public Proveedor getProveedor() {
        return this.proveedor;
    }


  public void setProveedor (Proveedor proveedor) {
        this.proveedor = proveedor;
    }



   public List<Codigo> getCodigos() {
        return this.codigos;
    }


  public void setCodigos (List<Codigo> codigos) {
        this.codigos = codigos;
    }

}

