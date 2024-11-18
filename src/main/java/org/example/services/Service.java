package org.example.services;

import org.example.models.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private static EntityManagerFactory emf;

    public Service(EntityManagerFactory emf) {
        this.emf = emf;
    }


    /**
     *  Guarda una pelicula en la base de datos
     *  @param m
     */
    public void save(Movie m){
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Quiero tener un listado con todas las películas
     */
    public List<Movie> getMovies(){

        List<Movie> salida = new ArrayList<Movie>(0);

        try{
            EntityManager em = emf.createEntityManager();
            TypedQuery<Movie> q = em.createQuery("SELECT m FROM Movie m", Movie.class);
            salida = q.getResultList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        return salida;
    }

    /**
     *  Quiero saber el número de películas de un director concreto
     */

    public Long countMoviesByDirector(String director){
        Long count = 0L;
        try{
            EntityManager em = emf.createEntityManager();
            TypedQuery<Long> q = em.createQuery(
                    "select count(m) from Movie m where m.director=:dir",
                    Long.class);
            q.setParameter("dir", director);
            count = q.getSingleResult();
            em.close();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return count;
    }





}
