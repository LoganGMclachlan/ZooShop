package Models;


import Models.Order;
import java.util.Date;
import java.util.HashMap;


/**
 *
 * @author logan
 */

// inherits from Person class
public class ZooKeeper extends Person {
    
    // atributes for zookeeper class
    private String phoneNumber;
    private boolean isRegistered;
    private HashMap<Integer, Order> orders;
    
     // 0 parameter constructor
    public ZooKeeper()
    {
        // calls 0 parameter constuctor from Person class
        super();
        phoneNumber = "";
        isRegistered = true;
        orders = new HashMap();
    }
    
    // 6 parameter constructor
    public ZooKeeper(String phoneNumberIn, boolean isRegisteredIn, String emailIn, String nameIn,
            String passwordIn, Date dobIn)
    {
        // calls 4 parameter constuctor from Person class
        super(emailIn, nameIn, passwordIn, dobIn);
        phoneNumber = phoneNumberIn;
        isRegistered = isRegisteredIn;
        orders = new HashMap();
    }
    
    // 5 parameter constructor
    public ZooKeeper(String phoneNumberIn, String emailIn, String nameIn,
            String passwordIn, Date dobIn)
    {
        // calls 4 parameter constuctor from Person class
        super(emailIn, nameIn, passwordIn, dobIn);
        phoneNumber = phoneNumberIn;
        isRegistered = true;
        orders = new HashMap();
    }
    
    
    public String displayGreeting()
    {
        String greeting = "<html>Hello " + getName() + "<br>"
                        + "You are logged in as a zooKeeper.</html>";
        
        return greeting;
    }
    
    
    // getters for zookeeper class
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    public boolean getIsRegistered()
    {
        return isRegistered;
    }
    
    public HashMap<Integer, Order> getOrders()
    {
        return orders;
    }
    
    // setter for zookeeper class
    public void setSuperUser(String phoneNumberIn)
    {
        phoneNumber = phoneNumberIn;
    }
    
    public void setIsRegistered(boolean isRegisteredIn)
    {
        isRegistered = isRegisteredIn;
    }
    
    public void setOrders(HashMap<Integer, Order> ordersIn)
    {
        orders = ordersIn;
    }
}
