/*@author mcast*/
package stdclientsocialnetwork;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.Scanner;
import socialNetwok.entities.EntitySocialNetwork;
import archivioSocialNetworkEJB.SocialNetworkEJBRemote;

//MODIFICA STDCLIENT///
public class StdClientSocialNetwork
{
    //CAMBIO VARIABILE:AGGIUNTO SOCIALNETWORKEJBREMOTE AL POSTO DI SOCIALNETWORKEJB//
    private static SocialNetworkEJBRemote socialNetworkEJB;

    public static void main(String[] args) 
    {
        try 
        {
            //Aggiunta la creazione del contesto JNDI per accedere al bean remoto
            InitialContext ctx = new InitialContext();

            // Aggiunta la lookup//
            socialNetworkEJB = (SocialNetworkEJBRemote) ctx.lookup("java:global/ArchivioSocialNetwork/SocialNetworkEJB!archivioSocialNetworkEJB.SocialNetworkEJBRemote");

            // Scanner per input utente, utilizzato per ottenere dati dinamici
            Scanner scanner = new Scanner(System.in);

            // Aggiunto controllo input per nickname, assicurandosi che l'utente inserisca un valore valido
            System.out.print("Inserisci nickname dell'iscritto: ");
            String nickname = scanner.nextLine();

            // Modifica: aggiunta logica per gestire ricerca di iscritti con il nickname specificato
            System.out.println("I dati dell'iscritto con nickname '" + nickname + "':");

            // Metodo remoto chiamato: corretta la logica di filtro per nickname
            List<EntitySocialNetwork> results = socialNetworkEJB.trovaPerProfessione(nickname);

            // Iterazione sui risultati e stampa dettagliata
            for (EntitySocialNetwork esn : results) 
            {
                System.out.println(esn);
            }

            // Modifica: aggiunto input per interesse con gestione dinamica della ricerca
            System.out.print("Inserisci interesse da cercare: ");
            String interesse = scanner.nextLine();

            // Stampa gli iscritti filtrati per interesse specifico
            System.out.println("Iscritti con interesse '" + interesse + "':");

            // Filtro degli iscritti con interesse fornito dall'utente
            for (EntitySocialNetwork esn : results) 
            {
                if (esn.getInteressi().contains(interesse)) 
                {
                    System.out.println(esn);
                }
            }

        } 
        catch (NamingException e) 
        {
            // Modifica: gestione specifica dell'eccezione NamingException per il lookup JNDI
            e.printStackTrace();
        }
    }
}
