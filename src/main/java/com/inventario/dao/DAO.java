/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.dao;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Kyon
 * @param <T>
 */
public class DAO<T> {

    private final static String PU = "inventario-mysql-PU";
    private static EntityManager em;
    private final Class<T> clase;

    public DAO() { 
        clase = null;
    }
    
    

    public DAO(Class<T> clase) {
        this.clase = clase;
    }

    public EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
            em = emf.createEntityManager();
        }
        return em;
    }

    public void guardar(T objeto) {

        getEntityManager().getTransaction().begin();
        getEntityManager().persist(objeto);
        getEntityManager().getTransaction().commit();
    }

    public void modificar(T objeto) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(objeto);
        getEntityManager().getTransaction().commit();
    }

    public void eliminar(T objeto) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(objeto);
        getEntityManager().getTransaction().commit();
    }

    public List<T> buscar(String queryJPQL) {
        return this.buscar(queryJPQL, null, -1, -1);
    }

    public List<T> buscar(String queryJPQL, Map<String, Object> parametros) {
        return this.buscar(queryJPQL, parametros, -1, -1);
    }

    public List<T> buscar(String queryJPQL, Map<String, Object> parametros, int inicio, int tamanio) {
        Query query = getEntityManager().createQuery(queryJPQL);

        if (parametros != null) {
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

        if (inicio != -1) {
            query.setFirstResult(inicio);
        }

        if (tamanio != -1) {
            query.setMaxResults(tamanio);
        }

        List<T> lista = query.getResultList();

        return lista;
    }

    public List<T> buscarTodos() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(clase));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public int contar(){
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(clase);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public T buscarPorId(Object id){
        return getEntityManager().find(clase, id);
    }
}
