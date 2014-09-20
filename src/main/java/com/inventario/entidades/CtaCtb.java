package com.inventario.entidades;

import java.io.Serializable;

import java.lang.Double;
import java.lang.Integer;
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
@Table(name="cta_ctb")
public  class CtaCtb implements Serializable {


    @Column(name="nombre",table="cta_ctb")
    @Basic
    private String nombre;


    @Column(name="codigo",table="cta_ctb",nullable=false)
    @Id
    private Integer codigo;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Clase.class,mappedBy="ctaCtble")
    private List<Clase> clases;


    @Column(name="formato",table="cta_ctb")
    @Basic
    private Integer formato;


    @Column(name="deprecia",table="cta_ctb",precision=22)
    @Basic
    private Double deprecia;

    public CtaCtb(){

    }


   public String getNombre() {
        return this.nombre;
    }


  public void setNombre (String nombre) {
        this.nombre = nombre;
    }



   public Integer getCodigo() {
        return this.codigo;
    }


  public void setCodigo (Integer codigo) {
        this.codigo = codigo;
    }



   public List<Clase> getClases() {
        return this.clases;
    }


  public void setClases (List<Clase> clases) {
        this.clases = clases;
    }



   public Integer getFormato() {
        return this.formato;
    }


  public void setFormato (Integer formato) {
        this.formato = formato;
    }



   public Double getDeprecia() {
        return this.deprecia;
    }


  public void setDeprecia (Double deprecia) {
        this.deprecia = deprecia;
    }

}

