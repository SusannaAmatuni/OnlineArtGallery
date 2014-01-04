/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.business;

import java.io.*;

/**
 *
 * @author HP_Owner
 */
public class UserRoleCl implements Serializable{
    
    private String userName;
    
    private String userRole;
    
    public UserRoleCl() {
        
        userName="";
        userRole="";
        
    }
    
    public String getUserName() {
            return this.userName;
    

    }
    
    public String getUserRole() {
        
        return this.userRole;
    }
    
    public void setUserName(String username) {
        this.userName= username;
    }
    
    public void setUserRole(String userRole) {
        
        this.userRole= userRole;
    }
}
    
    
    
    
    
