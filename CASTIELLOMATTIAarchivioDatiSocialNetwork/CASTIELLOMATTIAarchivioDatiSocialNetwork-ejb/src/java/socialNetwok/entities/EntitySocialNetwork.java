/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialNetwok.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/*@author mcast*/

@Entity
@NamedQueries({
    // Correzione query TROVA_PER_ID: aggiunta all'entità TROVA_PER_ID
    @NamedQuery(name = EntitySocialNetwork.TROVA_PER_ID, query = "SELECT esn FROM EntitySocialNetwork esn WHERE esn.id = :id"),
    @NamedQuery(name = EntitySocialNetwork.TROVA_PER_PROFESSIONE, query = "SELECT esn FROM EntitySocialNetwork esn WHERE esn.professione = :professione"),
    @NamedQuery(name = EntitySocialNetwork.TROVA_TUTTI, query = "SELECT esn FROM EntitySocialNetwork esn")
})


public class EntitySocialNetwork implements Serializable 
{
        public static final String TROVA_PER_ID = "EntitySocialNetwork.trovaPerId";
        public static final String TROVA_PER_PROFESSIONE = "EntitySocialNetwork.trovaPerProfessione";
        public static final String TROVA_TUTTI = "EntitySocialNetwork.trovaTutti";

        
        private static final long serialVersionUID = 1L;
        
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
    
	private String nickname;
	private String password;
	private String nome;
	private String cognome;
        //Aggiunta dell'informazione citta//
        private String citta;
	private String dataNascita;
	private String professione;
	private List<String>interessi;
    
        public EntitySocialNetwork(){};//Costruttore//
        //Aggiunta del parametro citta al costruttore//
	public EntitySocialNetwork(String nickname,String password,String nome,String cognome,String citta,String dataNascita,String professione,List<String>interessi)
	{
		this.nickname = nickname;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
                this.citta=citta;
		this.dataNascita = dataNascita;
		this.professione = professione;
		this.interessi=interessi;
	}
	

    //Metodi getters e setters:AVEVO DIMENTICATO IL PARAMETRO CITTA AGGIUNTO DURANTE L'IMPLEMENTAZIONE//
    public int getId(){return id;}
    public String getNickname(){return nickname;}
    public String getPassword(){return password;}
    public String getNome(){return nome;}
    public String getCognome(){return cognome;}
    public String getCitta(){return citta;}
    public String getDataNascita(){return dataNascita;}
    public String getProfessione(){return professione;}
    public List<String>getInteressi(){return interessi;}
    
    public void setId(int id){this.id = id;}
    public void setNickname(String nickname){this.nickname=nickname;}
    public void setPassword(String password){this.password=password;}
    public void setNome(String nome){this.nome=nome;}
    public void setCognome(String cognome){this.cognome=cognome;}
    public void setCitta(String citta){this.citta=citta;}
    public void setDataNascita(String dataNascita){this.dataNascita=dataNascita;}
    public void setProfessione(String professione){this.professione=professione;}
    public void setList(List<String>Interessi){this.interessi=interessi;}

    @Override
    public String toString() 
    {
        return "EntitySocialNetwork" +id+","+","+nickname+","+password+","+nome+","+cognome+","+citta+","+dataNascita+","+professione+","+interessi+".";
    }   
}
