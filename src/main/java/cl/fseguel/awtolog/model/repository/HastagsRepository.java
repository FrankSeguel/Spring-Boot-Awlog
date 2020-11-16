/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.model.repository;

import cl.fseguel.awtolog.model.entity.AwlogHashtag;
import cl.fseguel.awtolog.model.entity.AwlogLoggerHashtag;
import cl.fseguel.awtolog.model.util.Constantes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author fseguel
 * @see https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa
 */
@Configuration
@EnableTransactionManagement
public class HastagsRepository {

    private final EntityManagerFactory factory;

    public HastagsRepository() {
        factory = Persistence.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT_NAME);
    }

    public AwlogHashtag save(AwlogHashtag hashtag) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(hashtag);
        em.getTransaction().commit();
        em.close();
        return hashtag;
    }

    public AwlogHashtag refresh(AwlogHashtag hashtag) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.refresh(hashtag);
        em.getTransaction().commit();
        em.close();
        return hashtag;
    }

    public AwlogLoggerHashtag save(AwlogLoggerHashtag loggerHashtag) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(loggerHashtag);
        em.getTransaction().commit();
        em.close();
        return loggerHashtag;
    }

    public List<AwlogHashtag> findById(Integer id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT a FROM AwlogHashtag a WHERE a.id = :id ORDER BY a.description DESC ");
        q.setParameter("id", id);
        List<AwlogHashtag> awlogHashtagList = q.getResultList();
        em.close();
        return awlogHashtagList;
    }

    public List<AwlogHashtag> findByDescription(String descripcion) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT a FROM AwlogHashtag a WHERE a.description = :description ");
        q.setParameter("description", descripcion);
        List<AwlogHashtag> awlogHashtagList = q.getResultList();
        em.close();
        return awlogHashtagList;
    }

    public List<AwlogHashtag> findByAll() {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT a FROM AwlogHashtag a ORDER BY a.description DESC ");
        List<AwlogHashtag> awlogHashtagList = q.getResultList();
        em.close();
        return awlogHashtagList;
    }

}
