/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivioSocialNetworkEJB;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import socialNetwok.entities.EntitySocialNetwork;

/*@author mcast*/

//Aggiunta delle notazioni:Stateless e LocalBean
@Stateless
@LocalBean
public class SocialNetworkEJB implements SocialNetworkEJBRemote
{
    
    @Inject 
    private EntityManager em;
		
    //Correzione del metodo aggiungi:rimozione del return//
    @Override
    public void aggiungi(EntitySocialNetwork esn){em.persist(esn);}

    //Correzione del metodo rimuovi:rimozione del return//
    @Override
    public void rimuovi(EntitySocialNetwork esn){em.remove(em.merge(esn));}

    @Override
    public EntitySocialNetwork aggiorna(EntitySocialNetwork esn){return em.merge(esn);}

    //Correzione della query:aggiunta entità,creazione query//
    @Override
    public List<EntitySocialNetwork>trovaPerId(int id) 
    {
        TypedQuery<EntitySocialNetwork> query = em.createNamedQuery(EntitySocialNetwork.TROVA_PER_ID, EntitySocialNetwork.class);
        return query.getResultList();
    }

    //Correzione della query:aggiunta entità,creazione query//
    @Override
    public List<EntitySocialNetwork>trovaPerProfessione(String professione) 
    {
        TypedQuery<EntitySocialNetwork> query = em.createNamedQuery(EntitySocialNetwork.TROVA_PER_PROFESSIONE, EntitySocialNetwork.class);
        return query.getResultList();
    }
	
}
