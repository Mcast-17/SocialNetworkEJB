## SocialNetworkEJB
Un progetto Java di programmazione distribuita che dimostra la gestione di un archivio di membri di un social network attraverso le tecnologie Java Enterprise.

## Panoramica del progetto
Il progetto è organizzato in diversi moduli e applicazioni NetBeans:

- CASTIELLOMATTIAarchivioDatiSocialNetwork — applicazione enterprise che integra i moduli EJB e web.
- CASTIELLOMATTIAarchivioDatiSocialNetwork-ejb — contiene la logica di business, l'entità JPA e le query, l'interfaccia EJB remota, il componente JMS basato su messaggi, l'inizializzazione del database e un interceptor per il conteggio delle invocazioni dei metodi.
- CASTIELLOMATTIAarchivioDatiSocialNetwork-war — modulo web incluso nell'applicazione enterprise.
- StdClientSocialNetwork — client autonomo che individua e richiama l'EJB remoto tramite JNDI.
- WebClient — client che invia messaggi attraverso JMS.

## Tecnologie utilizzate

- Java (versione del linguaggio configurata per Java 8)
- Enterprise JavaBeans (EJB)
- Java Persistence API (JPA) ed EclipseLink
- Java Naming and Directory Interface (JNDI)
- Java Message Service (JMS)
- Struttura dei progetti Ant di NetBeans
- GlassFish e API dell'ecosistema Java EE 7

## Funzionalità principali

- Aggiunta, rimozione e ricerca dei membri del social network attraverso i metodi di business EJB.
- Ricerca dei membri tramite identificativo e professione mediante query JPA nominate (Named Queries).
- Inizializzazione e cancellazione dei dati di esempio all'avvio dell'applicazione.
- Invio di messaggi JMS per gestire gli eventi di registrazione dei membri, compresa la generazione di un avviso per i membri minorenni.
- Conteggio delle invocazioni dei metodi tramite un interceptor.
- Accesso all'EJB remoto da un client Java autonomo attraverso JNDI.

## Requisiti e configurazione
Il progetto utilizza tecnologie Java EE legacy e non è un'applicazione Spring Boot. La configurazione è pensata per un server della generazione di GlassFish 4 e per le API Java EE 7.
Per compilare ed eseguire il progetto sono necessari un ambiente NetBeans compatibile, un JDK, un server GlassFish e le librerie Java EE e le risorse del database correttamente configurate.
La configurazione della persistenza utilizza la sorgente dati JTA "java:global/jdbc/EsameDS" e prevede l'utilizzo di Derby con EclipseLink. Prima di eseguire l'applicazione, è necessario configurare in GlassFish la sorgente dati e le risorse JMS corrispondenti. I nomi delle risorse e le impostazioni di distribuzione potrebbero richiedere modifiche in base all'ambiente utilizzato.
Per aprire il progetto, utilizzare NetBeans e i file "project.xml" e ".properties" presenti nelle cartelle dei moduli.
Compilare e distribuire prima l'applicazione enterprise. Successivamente, con il server attivo, eseguire il client autonomo configurando correttamente il nome JNDI dell'EJB remoto per il proprio ambiente. Il client JMS richiede inoltre la destinazione e la connection factory corrispondenti.

## Contenuto del repository
Il repository contiene esclusivamente il codice sorgente e i file di progetto e configurazione necessari.
Sono stati esclusi i file generati durante la compilazione, i binari compilati, gli archivi di distribuzione e le impostazioni locali di NetBeans contenute nelle cartelle "nbproject/private".

## Note
Questo repository documenta un progetto dedicato alla Programmazione Distribuita in Java e all'utilizzo dei componenti Java EE.
Il progetto mantiene la sua architettura originale e non è stato convertito in una moderna applicazione Jakarta EE o Spring Boot.
