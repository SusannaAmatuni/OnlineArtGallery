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
public class ArtistCl implements Serializable {
    
    private int artistID;
    private String artistCode;
    private String artistFirstName;
    private String artistLastName;
    private String artistEmail;
    private String bioFile;
    private String imageURL;
    
    public void setArtistCode(String artistCode) {
        this.artistCode= artistCode; 
    }
    
    public String getArtistCode() {
        return artistCode;
    }
    
    public void setArtistID(int artistID){
        
        this.artistID=artistID;
    }
    
    public int getArtistID() {
        return this.artistID;
    }
    
    public void setArtistFirstName(String artistFirstName) {
        
        this.artistFirstName = artistFirstName;
        
    }
    
    public void setArtistLastName(String artistLastName){
        
       this.artistLastName= artistLastName;
       
    }

    public void setArtistEmail(String artistEmail) {
        this.artistEmail= artistEmail;
        
    }
    
    public void setBioFile(String bioFile) {
       this.bioFile = bioFile;
    }
    
    
    public String getArtistFirstName() {
        
        return artistFirstName;
    }
    
    public String getArtistLastName() {
        return artistLastName;
    }
    
    public String getArtistEmail() {
        return artistEmail;
        
    }
    
    public String getBioFile() {
        
        return bioFile;
    }
    
    public String getImageURL() {
     
        String url = "/OnlineShopper2/biofiles/"+ artistCode +".JPG";
        return url;
    }
    
}
