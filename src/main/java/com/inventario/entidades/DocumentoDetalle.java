package com.inventario.entidades;

import java.io.Serializable;

import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="doc_det")
public  class DocumentoDetalle implements Serializable {


    @Column(name="id",table="doc_det",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    @Column(name="precio",table="doc_det",scale=2,precision=10)
    @Basic
    private Double precio;


    @Column(name="item",table="doc_det")
    @Basic
    private String item;


    @Column(name="cantidad",table="doc_det",length=45)
    @Basic
    private String cantidad;


    @ManyToOne(targetEntity=Documento.class)
    @JoinColumn(name="doc_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Documento documento;


    @Column(name="detalle",table="doc_det")
    @Basic
    private String detalle;


    @ManyToOne(targetEntity=Bien.class)
    @JoinColumn(name="bien_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Bien bien;


    @Column(name="nivel",table="doc_det")
    @Basic
    private Integer nivel;

    public DocumentoDetalle(){

    }


   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public Double getPrecio() {
        return this.precio;
    }


  public void setPrecio (Double precio) {
        this.precio = precio;
    }



   public String getItem() {
        return this.item;
    }


  public void setItem (String item) {
        this.item = item;
    }



   public String getCantidad() {
        return this.cantidad;
    }


  public void setCantidad (String cantidad) {
        this.cantidad = cantidad;
    }



   public Documento getDocumento() {
        return this.documento;
    }


  public void setDocumento (Documento documento) {
        this.documento = documento;
    }



   public String getDetalle() {
        return this.detalle;
    }


  public void setDetalle (String detalle) {
        this.detalle = detalle;
    }



   public Bien getBien() {
        return this.bien;
    }


  public void setBien (Bien bien) {
        this.bien = bien;
    }



   public Integer getNivel() {
        return this.nivel;
    }


  public void setNivel (Integer nivel) {
        this.nivel = nivel;
    }

}

