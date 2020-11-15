/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.model.repository;

import cl.fseguel.awtolog.model.entity.AwlogLogger;
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
 */
@Configuration
@EnableTransactionManagement
public class AwtoLogRepository {

    private final EntityManagerFactory factory;

    public AwtoLogRepository() {
        factory = Persistence.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT_NAME);
    }

    public AwlogLogger save(AwlogLogger logger) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(logger);
        em.getTransaction().commit();
        em.close();
        return logger;
    }

    public List<AwlogLogger> findByAll() {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT a FROM AwlogLogger a ORDER BY a.creationDate DESC ");
        List<AwlogLogger> AwlogHashtag = q.getResultList();
        em.close();
        return AwlogHashtag;
    }

    public List<AwlogLogger> findByAllHashtag(String hashtag) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery(" SELECT a FROM AwlogLogger a inner join a.awlogLoggerHashtagList us WHERE us.hastagId.description = :hashtag ");
        q.setParameter("hashtag", hashtag);
        List<AwlogLogger> AwlogHashtag = q.getResultList();
        em.close();
        return AwlogHashtag;
    }

}
/*
SELECT 
lg
FROM awlog_logger lg 
inner join awlog_logger_hashtag lh on (lh.log_id = lg.id) 
inner join awlog_hashtag ah on (ah.id = lh.hastag_id)
where ah.description = 'hola'
order by lg.creation_date DESC
*/
