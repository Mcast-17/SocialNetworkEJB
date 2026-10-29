/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivioSocialNetworkEJB;

import archivioSocialNetwork.message.MessageWrapper;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.enterprise.event.Event;
import java.util.logging.Level;
import java.util.logging.Logger;

/*@author mcast*/

//Aggiunta l'annotazione MessageDriven//
@MessageDriven(mappedName = "jms/javaee7/Topic")
//Aggiunta corretta implementazione per gli eventi//
public class MessageMDB implements MessageListener 
{

    // Correzione: inject per l'evento
    @Inject
    private Event<MessageWrapper> event;

    // Override del metodo onMessage: per il messaggio di alert in caso di minore età dell'iscritto
    @Override
    public void onMessage(Message msg) 
    {
        try {
            // Controllo che il messaggio ricevuto sia di tipo ObjectMessage
            if (msg instanceof ObjectMessage) 
            {
                ObjectMessage objectMessage = (ObjectMessage) msg;

                // Estrae l'oggetto MessageWrapper dal messaggio
                MessageWrapper nuovoIscritto = (MessageWrapper) objectMessage.getObject();
                
                // Log del nuovo iscritto ricevuto
                System.out.println("Ricevuto nuovo iscritto: " + nuovoIscritto.getNuovoIscritto());

                // Se l'iscritto è minorenne, genera un alert
                if (nuovoIscritto.getEta() < 18) 
                {
                    System.out.println("ALERT: Iscritto minorenne!");
                }

                // Lancia l'evento con l'oggetto MessageWrapper
                event.fire(nuovoIscritto);
            }
        } 
        // Eccezione in caso in cui l'evento non venga lanciato o il messaggio sia malformato
        catch (JMSException ex) 
        {
            Logger.getLogger(MessageMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
