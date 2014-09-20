package com.inventario.entidades;

import java.io.Serializable;

import java.lang.Long;
import java.lang.String;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="relbiencampo")
public  class Relbiencampo implements Serializable {


    @ManyToOne(optional=false,targetEntity=Bien.class)
    @JoinColumn(name="bien_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Bien bienId;


    @ManyToOne(optional=false,targetEntity=Codigo.class)
    @JoinColumn(name="codigo_codigo",referencedColumnName="codigo",insertable=true,nullable=true,unique=false,updatable=true)
    private Codigo codigoCodigo;


    @Column(name="id",table="relbiencampo",nullable=false)
    @Id
    private Long id;


    @Column(name="valor",table="relbiencampo")
    @Basic
    private String valor;


    @ManyToOne(optional=false,targetEntity=Campo.class)
    @JoinColumn(name="campo_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Campo campoId;

    public Relbiencampo(){

    }


   public Bien getBienId() {
        return this.bienId;
    }


  public void setBienId (Bien bienId) {
        this.bienId = bienId;
    }



   public Codigo getCodigoCodigo() {
        return this.codigoCodigo;
    }


  public void setCodigoCodigo (Codigo codigoCodigo) {
        this.codigoCodigo = codigoCodigo;
    }



   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public String getValor() {
        return this.valor;
    }


  public void setValor (String valor) {
        this.valor = valor;
    }



   public Campo getCampoId() {
        return this.campoId;
    }


  public void setCampoId (Campo campoId) {
        this.campoId = campoId;
    }

}

