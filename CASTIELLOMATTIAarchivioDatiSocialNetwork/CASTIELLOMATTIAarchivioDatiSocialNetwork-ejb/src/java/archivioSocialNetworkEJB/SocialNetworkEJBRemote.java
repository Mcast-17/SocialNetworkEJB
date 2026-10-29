/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package archivioSocialNetworkEJB;

import java.util.List;
import javax.ejb.Remote;
import socialNetwok.entities.EntitySocialNetwork;

/*@author mcast*/

@Remote
public interface SocialNetworkEJBRemote
{
	void aggiungi(EntitySocialNetwork esn);
	void rimuovi(EntitySocialNetwork esn);
	EntitySocialNetwork aggiorna(EntitySocialNetwork esn);
	List<EntitySocialNetwork>trovaPerId(int id);
	List<EntitySocialNetwork>trovaPerProfessione(String professione);
}