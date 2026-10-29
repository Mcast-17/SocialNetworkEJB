/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivioSocialNetwork.message;

/*@author mcast*/

public class MessageWrapper 
{
    private String nuovoIscritto;
    //cambio variabile id a eta//
    private int eta;
    
    public MessageWrapper(String nuovoIscritto,int eta)
    {
        this.nuovoIscritto=nuovoIscritto;
        this.eta=eta;
    }
    
    public String getNuovoIscritto(){return nuovoIscritto;}
    public int getEta(){return eta;}
    
    public void setNuovoIscritto(String nuovoIscritto){this.nuovoIscritto=nuovoIscritto;}
    public void setEta(int eta){this.eta=eta;}
    
}
