/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inventario.controladores;

import com.inventario.entidades.Ambiente;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author RyuujiMD
 */
public class AmbienteControlador extends AbstractControlador<Ambiente>{

    public AmbienteControlador() {
        super(Ambiente.class);
    }
    
    public List<Ambiente> ambientesXNombre(String nombre){
        String jpql = "SELECT a FROM Ambiente a WHERE UPPER(a.ambiente) LIKE UPPER(CONCAT('%',:nombre,'%'))";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.getDao().buscar(jpql, parametros);
    }
    
}
