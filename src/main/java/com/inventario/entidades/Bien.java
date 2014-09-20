package com.inventario.entidades;

import java.io.Serializable;

import java.lang.Long;
import java.lang.String;
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

@Entity
@Table(name="bien")
public  class Bien implements Serializable {


    @Column(name="id",table="bien",nullable=false)
    @Id
    private Long id;


    @Column(name="anota",table="bien")
    @Basic
    private String anota;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=DocumentoDetalle.class,mappedBy="bien")
    private List<DocumentoDetalle> documentoDetalles;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Relbiencampo.class,mappedBy="bienId")
    private List<Relbiencampo> relBienCampos;


    @ManyToOne(targetEntity=Clase.class)
    @JoinColumn(name="clase_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Clase clase;


    @Column(name="foto",table="bien")
    @Basic
    private String foto;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Inventario.class,mappedBy="bien")
    private List<Inventario> inventarios;


    @Column(name="detalle",table="bien")
    @Basic
    private String detalle;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Movimiento.class,mappedBy="bien")
    private List<Movimiento> movimientos;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Codigo.class,mappedBy="bien")
    private List<Codigo> codigos;

    public Bien(){

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



   public List<Relbiencampo> getRelBienCampos() {
        return this.relBienCampos;
    }


  public void setRelBienCampos (List<Relbiencampo> relBienCampos) {
        this.relBienCampos = relBienCampos;
    }



   public Clase getClase() {
        return this.clase;
    }


  public void setClase (Clase clase) {
        this.clase = clase;
    }



   public String getFoto() {
        return this.foto;
    }


  public void setFoto (String foto) {
        this.foto = foto;
    }



   public List<Inventario> getInventarios() {
        return this.inventarios;
    }


  public void setInventarios (List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }



   public String getDetalle() {
        return this.detalle;
    }


  public void setDetalle (String detalle) {
        this.detalle = detalle;
    }



   public List<Movimiento> getMovimientos() {
        return this.movimientos;
    }


  public void setMovimientos (List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }



   public List<Codigo> getCodigos() {
        return this.codigos;
    }


  public void setCodigos (List<Codigo> codigos) {
        this.codigos = codigos;
    }

}

