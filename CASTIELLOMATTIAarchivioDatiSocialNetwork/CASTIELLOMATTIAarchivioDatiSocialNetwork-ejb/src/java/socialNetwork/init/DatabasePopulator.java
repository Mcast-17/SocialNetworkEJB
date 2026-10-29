/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialNetwork.init;

import archivioSocialNetworkEJB.SocialNetworkEJB;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Singleton;
import socialNetwok.entities.EntitySocialNetwork;



/*@author mcast*/

//Aggiunte le notazioni Singleton,Startup,DataSourceDefinition//
@Singleton
@Startup
//Correzzione del DataSouceDefinition//
//Rimozione del PersistUnit//
@DataSourceDefinition(className = "org.apache.derby.jdbc.EmbeddedDataSource",
   name = "java:global/jdbc/EsameDS",
   user = "esame", password = "esame",
   databaseName = "EsameDB",
   properties = {"connectionAttributes=;create=true"})

public class DatabasePopulator 
{
     //Aggiunta delle iniezioni//
    @Inject
    private SocialNetworkEJB socialNetworkEJB;
    private EntitySocialNetwork socialNetwork;
    
    //Correzione del metodo PopulateDB//
    @PostConstruct
    public void populateDB()
    {
        //Creazione dell'oggetto//
        EntitySocialNetwork socialNetwork = new EntitySocialNetwork();
        socialNetworkEJB.aggiungi(socialNetwork);
        System.out.println("Dati aggiunti con successo");
    }
        
    //Aggiunta del metodo clearDB//
    @PreDestroy
    public void clearDB()
    {
        socialNetworkEJB.rimuovi(socialNetwork);
    }
}