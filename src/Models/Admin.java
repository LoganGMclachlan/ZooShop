package Models;


import java.util.Date;


/**
 *
 * @author logan
 */

// inherits from Person class
public class Admin extends Person{
    
    // attributes for admin class
    private boolean superUser;
    
    // 0 parameter constructor
    public Admin()
    {
        // calls 0 parameter constuctor from Person class
        super();
        superUser = true;
    }
    
    // 5 parameter constructor
    public Admin(boolean superUserIn, String emailIn, String nameIn, String passwordIn, Date dobIn)
    {
        // calls 4 parameter constuctor from Person class
        super(emailIn, nameIn, passwordIn, dobIn);
        superUser = superUserIn;
    }
    
    
    public String displayGreeting()
    {
        String greeting = "<html>Hello " + getName() + "<br>"
                        + "You are logged in as a ";
        
        if (superUser)
        {
            greeting += "Super User.</html>";
        }
        else
        {
            greeting += "non Super User.</html>";
        }
        
        
        return greeting;
    }
    
    
    // getter for admin class
    public boolean getSuperUser()
    {
        return superUser;
    }
    
    // setter for admin class
    public void setSuperUser(boolean superUserIn)
    {
        superUser = superUserIn;
    }
}
