/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package webclient;

/*@author mcast*/
import archivioSocialNetwork.message.MessageWrapper;
import java.io.Serializable;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

public class SocialNetworkWebClient
{
    public static void main(String[] args) {
        try {
            //Aggiunta la creazione del contesto//
            InitialContext ctx = new InitialContext();
            ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
            Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");

            // Correzione della creazione dello scanner per input utente
            Scanner scanner = new Scanner(System.in);

            System.out.print("Inserisci il nome del nuovo iscritto: ");
            String nome = scanner.nextLine();
            
            System.out.print("Inserisci l'età del nuovo iscritto: ");
            int eta = scanner.nextInt();
            
            // Creazione dell'oggetto MessageWrapper
            MessageWrapper messageWrapper = new MessageWrapper(nome, eta);

            try (JMSContext jmsContext = cf.createContext()) {
                // Creazione del produttore JMS e invio del messaggio
                JMSProducer producer = jmsContext.createProducer();
                ObjectMessage message = jmsContext.createObjectMessage((Serializable) messageWrapper);
                producer.send(topic, message);

                System.out.println("Messaggio inviato per il nuovo iscritto: " + nome);
            }
        } catch (NamingException e) {
            System.err.println("Errore durante il lookup delle risorse JMS: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Errore generico: " + e.getMessage());
        }
    }
}
