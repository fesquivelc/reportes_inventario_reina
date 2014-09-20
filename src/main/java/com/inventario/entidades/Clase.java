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
@Table(name="clase")
public  class Clase implements Serializable {


    @Column(name="codigo",table="clase",nullable=false)
    @Basic
    private String codigo;


    @Column(name="id",table="clase",nullable=false)
    @Id
    private Long id;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Bien.class,mappedBy="clase")
    private List<Bien> bienes;


    @Column(name="clase",table="clase",nullable=false)
    @Basic
    private String clase;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Campo.class,mappedBy="clase")
    private List<Campo> campos;


    @ManyToOne(optional=false,targetEntity=CtaCtb.class)
    @JoinColumn(name="cta_ctb_codigo",referencedColumnName="codigo",insertable=true,nullable=true,unique=false,updatable=true)
    private CtaCtb ctaCtble;

    public Clase(){

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



   public List<Bien> getBienes() {
        return this.bienes;
    }


  public void setBienes (List<Bien> bienes) {
        this.bienes = bienes;
    }



   public String getClase() {
        return this.clase;
    }


  public void setClase (String clase) {
        this.clase = clase;
    }



   public List<Campo> getCampos() {
        return this.campos;
    }


  public void setCampos (List<Campo> campos) {
        this.campos = campos;
    }



   public CtaCtb getCtaCtble() {
        return this.ctaCtble;
    }


  public void setCtaCtble (CtaCtb ctaCtble) {
        this.ctaCtble = ctaCtble;
    }

}

