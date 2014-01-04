/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.business;

import java.io.Serializable;
/**
 *
 * @author HP_Owner
 */
public class ArtTypeCl implements Serializable{
    private int art_ID;
    private String artTypeName;
    
    
    public void setArt_ID(int art_ID) {
        this.art_ID= art_ID;
    }
    
    
    public int getArt_ID() {
        return art_ID;
    }
    
    public void setArtTypeName(String artTypeName){
        this.artTypeName= artTypeName;
        
    }
    
    public String getArtTypeName() {
        return artTypeName;
    }

}
