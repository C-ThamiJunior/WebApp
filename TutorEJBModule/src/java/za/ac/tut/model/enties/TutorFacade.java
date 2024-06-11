/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.enties;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ltham
 */
@Stateless
public class TutorFacade extends AbstractFacade<Tutor> implements TutorFacadeLocal {

    @PersistenceContext(unitName = "TutorEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TutorFacade() {
        super(Tutor.class);
    }

    @Override
    public Long getTotalNumber(String gender) {
        Query q = em.createQuery("SELECT COUNT(t) FROM tutor t WHERE t.gender=:gender");
        q.setParameter("gender", gender);
        Long cnt = (Long) q.getSingleResult();
        
        return cnt;
    }

    @Override
    public Double getAvarage(String gender) {
        Query q = em.createQuery("SELECT AVG(t) FROM tutor t WHERE t.gender =:gender");
        q.setParameter("gender", gender);
        Double avg = (Double) q.getSingleResult();
        
        return avg;
    }

    @Override
    public Tutor getYoungestTutor() {
         Query q = em.createQuery("SELECT t FROM tutor t WHERE t.age=(SELECT MIN(t.age) FROM tutor t)");
         Tutor totor = (Tutor) q.getResultList().get(0);
         
         return totor;
    }
    
}
