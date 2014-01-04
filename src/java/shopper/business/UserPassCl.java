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
public class UserPassCl implements Serializable {

    private String userName;
    private String password ;
    
    public UserPassCl() {
       userName="";
       password="";
    }
    
    public void setUserName(String name) {
        this.userName= name;
    }
    
    public void setPassword(String password) {
        this.password= password;
    }
    
    public String getUserName() {
            return userName;
}
    
    public String getPassword() {
        return password;
    }
}

