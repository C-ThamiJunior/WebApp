/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.enties;

import javax.ejb.EJBException;

/**
 *
 * @author ltham
 */
public class StuffNumberInvalid extends EJBException{
    StuffNumberInvalid(String message){
        super(message);
    }
}
