package com.inventario.entidades;

import java.io.Serializable;

import java.lang.Double;
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
@Table(name="codigo")
public  class Codigo implements Serializable {


    @Column(name="serie",table="codigo")
    @Basic
    private String serie;


    @Column(name="codigo",table="codigo",nullable=false,length=50)
    @Id
    private String codigo;


    @Column(name="anota",table="codigo")
    @Basic
    private String anota;


    @Column(name="estado",table="codigo",length=45)
    @Basic
    private String estado;


    @Column(name="precio",table="codigo",precision=22)
    @Basic
    private Double precio;


    @Column(name="caracteristicas",table="codigo")
    @Basic
    private String caracteristicas;


    @ManyToOne(targetEntity=Documento.class)
    @JoinColumn(name="doc_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Documento documento;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Relbiencampo.class,mappedBy="codigoCodigo")
    private List<Relbiencampo> relBienCampos;


    @ManyToOne(targetEntity=Ambiente.class)
    @JoinColumn(name="ambiente_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Ambiente ambiente;


    @Column(name="foto",table="codigo")
    @Basic
    private String foto;


    @ManyToOne(targetEntity=Bien.class)
    @JoinColumn(name="bien_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Bien bien;

    public Codigo(){

    }


   public String getSerie() {
        return this.serie;
    }


  public void setSerie (String serie) {
        this.serie = serie;
    }



   public String getCodigo() {
        return this.codigo;
    }


  public void setCodigo (String codigo) {
        this.codigo = codigo;
    }



   public String getAnota() {
        return this.anota;
    }


  public void setAnota (String anota) {
        this.anota = anota;
    }



   public String getEstado() {
        return this.estado;
    }


  public void setEstado (String estado) {
        this.estado = estado;
    }



   public Double getPrecio() {
        return this.precio;
    }


  public void setPrecio (Double precio) {
        this.precio = precio;
    }



   public String getCaracteristicas() {
        return this.caracteristicas;
    }


  public void setCaracteristicas (String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }



   public Documento getDocumento() {
        return this.documento;
    }


  public void setDocumento (Documento documento) {
        this.documento = documento;
    }



   public List<Relbiencampo> getRelBienCampos() {
        return this.relBienCampos;
    }


  public void setRelBienCampos (List<Relbiencampo> relBienCampos) {
        this.relBienCampos = relBienCampos;
    }



   public Ambiente getAmbiente() {
        return this.ambiente;
    }


  public void setAmbiente (Ambiente ambiente) {
        this.ambiente = ambiente;
    }



   public String getFoto() {
        return this.foto;
    }


  public void setFoto (String foto) {
        this.foto = foto;
    }



   public Bien getBien() {
        return this.bien;
    }


  public void setBien (Bien bien) {
        this.bien = bien;
    }

}

