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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ambiente")
public  class Ambiente implements Serializable {


    @Column(name="responsable",table="ambiente",nullable=false)
    @Basic
    private String responsable;


    @Column(name="codigo",table="ambiente",nullable=false,length=100)
    @Basic
    private String codigo;


    @Column(name="id",table="ambiente",nullable=false)
    @Id
    private Long id;


    @Column(name="anota",table="ambiente")
    @Basic
    private String anota;


    @Column(name="area",table="ambiente",nullable=false)
    @Basic
    private String area;


    @Column(name="ambiente",table="ambiente",nullable=false)
    @Basic
    private String ambiente;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Inventario.class,mappedBy="ambiente")
    private List<Inventario> inventarios;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Movimiento.class,mappedBy="ambiente")
    private List<Movimiento> movimientos;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Codigo.class,mappedBy="ambiente")
    private List<Codigo> codigos;

    public Ambiente(){

    }


   public String getResponsable() {
        return this.responsable;
    }


  public void setResponsable (String responsable) {
        this.responsable = responsable;
    }



   public String getCodigo() {
        return this.codigo;
    }


  public void setCodigo (String codigo) {
        this.codigo = codigo;
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



   public String getArea() {
        return this.area;
    }


  public void setArea (String area) {
        this.area = area;
    }



   public String getAmbiente() {
        return this.ambiente;
    }


  public void setAmbiente (String ambiente) {
        this.ambiente = ambiente;
    }



   public List<Inventario> getInventarios() {
        return this.inventarios;
    }


  public void setInventarios (List<Inventario> inventarios) {
        this.inventarios = inventarios;
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

