/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.controladores;

import com.inventario.entidades.Clase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author RyuujiMD
 */
public class ClaseControlador extends AbstractControlador<Clase> {

    public ClaseControlador() {
        super(Clase.class);
    }

    public List<Clase> clasesXNombre(String nombre) {
        String jpql = "SELECT a FROM Clase a WHERE UPPER(a.clase) LIKE UPPER(CONCAT('%',:nombre,'%'))";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.getDao().buscar(jpql, parametros);
    }
}
