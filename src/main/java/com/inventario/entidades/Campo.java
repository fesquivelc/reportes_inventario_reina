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
@Table(name="campo")
public  class Campo implements Serializable {


    @Column(name="id",table="campo",nullable=false)
    @Id
    private Long id;


    @Column(name="campo",table="campo")
    @Basic
    private String campo;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Relbiencampo.class,mappedBy="campoId")
    private List<Relbiencampo> relBienCampo;


    @ManyToOne(targetEntity=Clase.class)
    @JoinColumn(name="clase_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Clase clase;

    public Campo(){

    }


   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public String getCampo() {
        return this.campo;
    }


  public void setCampo (String campo) {
        this.campo = campo;
    }



   public List<Relbiencampo> getRelBienCampo() {
        return this.relBienCampo;
    }


  public void setRelBienCampo (List<Relbiencampo> relBienCampo) {
        this.relBienCampo = relBienCampo;
    }



   public Clase getClase() {
        return this.clase;
    }


  public void setClase (Clase clase) {
        this.clase = clase;
    }

}

