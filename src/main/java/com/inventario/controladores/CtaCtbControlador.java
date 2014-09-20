/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inventario.controladores;

import com.inventario.entidades.CtaCtb;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author RyuujiMD
 */
public class CtaCtbControlador extends AbstractControlador<CtaCtb>{

    public CtaCtbControlador() {
        super(CtaCtb.class);
    }
    
    public List<CtaCtb> cuentasXNombre(String nombre){
        String jpql = "SELECT a FROM CtaCtb a WHERE UPPER(a.nombre) LIKE UPPER(CONCAT('%',:nombre,'%'))";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.getDao().buscar(jpql, parametros);
    }
    
}
