package com.inventario.entidades;

import java.io.Serializable;

import java.lang.Integer;
import java.lang.Long;
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
@Table(name="inventario")
public  class Inventario implements Serializable {


    @Column(name="id",table="inventario",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    @Column(name="cantidad",table="inventario")
    @Basic
    private Integer cantidad;


    @ManyToOne(targetEntity=Ambiente.class)
    @JoinColumn(name="ambiente_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Ambiente ambiente;


    @ManyToOne(targetEntity=Bien.class)
    @JoinColumn(name="bien_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Bien bien;

    public Inventario(){

    }


   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public Integer getCantidad() {
        return this.cantidad;
    }


  public void setCantidad (Integer cantidad) {
        this.cantidad = cantidad;
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

