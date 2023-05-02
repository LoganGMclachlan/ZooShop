package Models;

// imports used for class
import java.util.Date;


/**
 *
 * @author logan
 */
public class Person {
    
    // attributes for person class
    private String email;
    private String name;
    private String password;
    private Date dob;
    
    // class constructors
    // 0 paramater constructor
    public Person()
    {
        email = "";
        name = "";
        password = "";
        dob = new Date();
    }
    
    // 4 paramater constructor
    public Person(String emailIn, String nameIn, String passwordIn, Date dobIn)
    {
        email = emailIn;
        name = nameIn;
        password = passwordIn;
        dob = dobIn;
    }
    
    
    // class getters
    public String getEmail()
    {
        return email;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public Date getDob()
    {
        return dob;
    }
    
    // class setters
    public void setEmail(String emailIn)
    {
        email = emailIn;
    }
    
    public void setname(String nameIn)
    {
        name = nameIn;
    }
    
    public void setPassword(String passwordIn)
    {
        password = passwordIn;
    }
    
    public void setDob(Date dobIn)
    {
        dob = dobIn;
    }
}
