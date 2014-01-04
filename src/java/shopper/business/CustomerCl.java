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
public class CustomerCl implements Serializable{
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address1;
    private String address2;
    private String city;
    private String companyName;
    private String country;
    private String creditCardExpirationDate;
    private String creditCardNumber;
    private String creditCardType;
    private String state;
    private String zipCode;
    private int customerID;
    private String userName;
    
   
    
   
    public CustomerCl()
    {
        firstName = "";
        lastName = "";
        emailAddress = "";
        companyName = "";
        address1 = "";
        address2 = "";
        city = "";
        state = "";
        zipCode = "";
        country = "";
        creditCardType = "";
        creditCardNumber = "";
        creditCardExpirationDate = "";
        userName= "";
    } 
    
     public void setCustomerID(int customerID) {
        this.customerID=customerID;
    }
     
     public int getCustomerID() {
         return this.customerID;
     }
    
    
  public String getFirstName() {
      
      return this.firstName;
      
  } 
  
  public String getLastName() {
      return this.lastName;
      
  }
  
  public String getEmailAddress() {
      return this.emailAddress;
      
  }
  
  public String getAddress1() {
      return address1;
  }
  
  public String getAddress2() {
      return address2;
      
  } 
  
  public String getCity() {
      return city;
      
  } 

  public String getCompanyName() {
      return companyName;
      
  }
  public String getCountry() {
      return country;
      
  }
  
  public String getState() {
      return state;
      
  }
  
  public String getCreditCardExpirationDate() {
      return creditCardExpirationDate;
  }
  
  public String getCreditCardNumber() {
      return creditCardNumber;
  }
  
  public String getCreditCardType() {
      return creditCardType;
  }
  
  public String getZipCode() {
      return zipCode;
      
  }
  
  public void setUserName(String userName) {
      this.userName=userName;
  }
  
  public String getUserName() {
      return userName;
  }
          
  
  //This is correct but mixes view and model
  public String getAddressHtmlFormat() {
   
      String address= firstName + lastName+"<br>";
      
      if(companyName==null || companyName.equals("") || companyName.equals(" ")) 
          address+=" ";
      else {
          address+=companyName+"<br>";
          address+=address1+"<br>";
      }
      if(address2==null || address2.equals("") || address2.equals(" ")) 
          address+=" ";
      else 
          address+= address2+"<br>";
      
          address+= city+","+state +" " +zipCode+"<br>";
          address+=country;
      
      return address;
      }
  
  

public void setFirstName(String f) {
     firstName=f;
}

public void setLastName(String l) {
    lastName=l;
}

public void setAddress1(String a1) {
    address1=a1;
}


public void setAddress2(String a2) {
    address2=a2;
}

public void setEmailAddress(String e) {
    emailAddress=e;
}

public void setCity(String c) {
    city = c;
}


public void setState(String st) {
    state=st;
}


public void setCountry(String con) {
    country= con;
}

public void setZipCode(String z) {
    zipCode =z;
}


public void setCompanyName(String comp) {
    companyName= comp;
}

public void setCreditCardExpirationDate(String date) {
    
    creditCardExpirationDate= date;
    
}

public void setCreditCardType(String type) {
    creditCardType = type;
}

public void setCreditCardNumber(String num) {
    creditCardNumber= num;
}

}




