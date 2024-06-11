/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.enties;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ltham
 */
@Local
public interface TutorFacadeLocal {

    void create(Tutor tutor);

    void edit(Tutor tutor);

    void remove(Tutor tutor);

    Tutor find(Object id);

    List<Tutor> findAll();

    List<Tutor> findRange(int[] range);

    int count();
    
    Long getTotalNumber(String gender);
    
    Double getAvarage(String gender);
    
    Tutor getYoungestTutor();
    
}
