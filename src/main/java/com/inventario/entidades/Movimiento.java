package com.inventario.entidades;

import java.io.Serializable;

import java.lang.Long;
import java.lang.String;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="desplaza")
public  class Movimiento implements Serializable {


    @Column(name="id",table="desplaza",nullable=false)
    @Id
    private Long id;


    @Column(name="usu_mov",table="desplaza")
    @Basic
    private String usuMov;


    @Column(name="fecha",table="desplaza",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fecha;


    @ManyToOne(optional=false,fetch=FetchType.LAZY,targetEntity=Ambiente.class)
    @JoinColumn(name="id_ambi",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Ambiente ambiente;


    @ManyToOne(optional=false,fetch=FetchType.LAZY,targetEntity=Bien.class)
    @JoinColumn(name="bien_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Bien bien;

    public Movimiento(){

    }


   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public String getUsuMov() {
        return this.usuMov;
    }


  public void setUsuMov (String usuMov) {
        this.usuMov = usuMov;
    }



   public Date getFecha() {
        return this.fecha;
    }


  public void setFecha (Date fecha) {
        this.fecha = fecha;
    }



   public Ambiente getAmbiente() {
        return this.ambiente;
    }


  public void setAmbiente (Ambiente ambiente) {
        this.ambiente = ambiente;
    }



   public Bien getBien() {
        return this.bien;
    }


  public void setBien (Bien bien) {
        this.bien = bien;
    }

}

