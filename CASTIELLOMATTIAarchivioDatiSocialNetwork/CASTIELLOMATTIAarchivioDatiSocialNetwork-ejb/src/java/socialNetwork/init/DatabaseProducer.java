/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialNetwork.init;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*@author mcast*/

//Correzione della classe DatabaseProducer//
public class DatabaseProducer 
{
    //Aggiunta delle annotazioni//
    @Produces
    @PersistenceContext(unitName="EsamePU")
    private EntityManager em;
}
