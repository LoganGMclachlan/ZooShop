
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author logan
 */
public class DBManager {
    
    // sets driver and connection string as constants
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private final String connectionString = 
            "jdbc:ucanaccess://C:\\Users\\logan\\Documents\\Files\\Collage Stuff\\year 2\\block 1-2\\OOP monday\\ZooShop\\Data\\ZooShopDB.accdb";

    // ----------------------------------------------------------------------------------------------------
    
    public HashMap<Integer, Animal> loadAnimals()
    {
        HashMap<Integer, Animal> animals = new HashMap();
        
        try
        {
            // connects to DB
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            // Creates and executes a query to get all items from Animal table on DB
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Animals");
            
            while (rs.next())
            {
                // gets data from db fields
                int animalID = rs.getInt("AnimalID");
                String animalName = rs.getString("AnimalName");
                char gender = rs.getString("Gender").charAt(0);
                String type = rs.getString("Type");
                int age = rs.getInt("Age");
                float cost = rs.getFloat("Cost");
                boolean availability = rs.getBoolean("Availability");
                String location = rs.getString("Location");
                String waterType = rs.getString("WaterType");
                boolean canFly = rs.getBoolean("CanFly");
                
                // if watertype if empty, create a bird object
                if ("".equals(waterType) || waterType == null)
                {
                    // adds a bird to hashmap
                    Bird bird = new Bird(canFly, animalID, animalName, type, age, cost, availability, gender);
                    animals.put(animalID, bird);
                }
                else// create a fish object 
                {
                    // adds a fish to hashmap
                    Fish fish = new Fish(waterType, animalID, animalName, type, age, cost, availability, gender);
                    animals.put(animalID, fish);
                }
                conn.close();
            }
        }
        catch (Exception e)// if an error occurs
        {
            // sned error message to command line
            System.out.println("Error loading ZooKeepers: " + e.getMessage());
        }
        finally
        {
            return animals;
        }
    }
    
    
    
    // loads DB data into hashmap of zookeepers
    public HashMap<String, ZooKeeper> loadZooKeepers()
    {
        // creates empty hashmap
        HashMap<String, ZooKeeper> zooKeepers = new HashMap();
        
         
        try
        {
            // connects to DB
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            // Creates and executes a query to get all items from ZooKeeper table on DB
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ZooKeepers");
            
            // loops through data found on Zookeeper table
            while(rs.next())
            {
                // gets data from colums
                String email = rs.getString("EmailAddress");
                String name = rs.getString("PersonName");
                String password = rs.getString("Password");
                Date dob = rs.getDate("DateOfBirth");
                String telephoneNo = rs.getString("TelephoneNo");
                
                // creates new Zookeeper object with data
                ZooKeeper zooKeeper = new ZooKeeper(telephoneNo, email, name, password, dob);
                
                // puts new ZooKeeper object into hashmap with email as its key
                zooKeepers.put(email, zooKeeper);
            }
            
            // closes the DB connection
            conn.close();
        }
        catch(Exception e)// if an error occurs
        {
            // sned error message to command line
            System.out.println("Error loading ZooKeepers: " + e.getMessage());
        }
        finally// alwasy execute the following
        {
            // returns hashmap
            return zooKeepers;
        }
    }
    
    public ZooKeeper zooKeeperLogin(String email, String password)
    {
        HashMap<String, ZooKeeper> zooKeepers = loadZooKeepers();
        
        if (zooKeepers.containsKey(email))
        {
            ZooKeeper zooKeeper = zooKeepers.get(email);
            if (zooKeeper.getPassword().equals(password))
            {
                return zooKeeper;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
    
    // zookeeper stuff
    // -----------------------------------------------------------
    // admin stuff
    
    public HashMap<String, Admin> loadAdmins()
    {
        // creates empty hashmap
        HashMap<String, Admin> admins = new HashMap();
        
         
        try
        {
            // connects to DB
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            // Creates and executes a query to get all items from Admin table on DB
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Admins");
            
            // loops through data found on Admin table
            while(rs.next())
            {
                // gets data from colums
                String email = rs.getString("EmailAddress");
                String name = rs.getString("PersonName");
                String password = rs.getString("Password");
                Date dob = rs.getDate("DateOfBirth");
                boolean superUser = rs.getBoolean("SuperUser");
                
                // creates new Admin object with data
                Admin admin = new Admin(superUser, email, name, password, dob);
                
                // puts new Admin object into hashmap with email as its key
                admins.put(email, admin);
            }
            
            // closes the DB connection
            conn.close();
        }
        catch(Exception e)// if an error occurs
        {
            // sned error message to command line
            System.out.println("Error loading Admins: " + e.getMessage());
        }
        finally// alwasy execute the following
        {
            // returns hashmap
            return admins;
        }
    }
    
    // logs in admin
    public Admin adminLogin(String email, String password)
    {
        // gets admin data from db
        HashMap<String, Admin> admins = loadAdmins();
        
        // compairs db data to what user inputted
        if (admins.containsKey(email))
        {
            Admin admin = admins.get(email);
            if (admin.getPassword().equals(password))
            {
                // if username exists and password matches login is succesful
                return admin;
            }
            else
            {
                // login failed
                return null;
            }
        }
        else
        {
            // login failed
            return null;
        }
    }
    
    
    public void registerZooKeeper(ZooKeeper zooKeeper){
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO ZooKeepers (EmailAddress, PersonName, Password, DateOfBirth, TelephoneNo) VALUES (" 
                    + "'" +  zooKeeper.getEmail() + "',"
                    + "'" +  zooKeeper.getName() + "',"
                    + "'" +  zooKeeper.getPassword() + "',"
                    + "'" +  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(zooKeeper.getDob()) + "',"
                    + "'" +  zooKeeper.getPhoneNumber() + "')");
            
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error writing zooKeeper: " + e.getMessage());
        }
    }
    
    public void EditAnimal(Animal animal){
        String waterType = "";
        String canFly = "false";
        
        if(animal.getClass().getName().equals("Models.Bird")){
            Bird bird = (Bird)animal;
            canFly = String.valueOf(bird.getCanFly());
        }
        else{
            Fish fish = (Fish)animal;
            waterType = fish.getWaterType();
        }
        
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Animals SET "
                    + "AnimalName = '" + animal.getName() + "',"
                    + "Gender = '" + animal.getGender() + "',"
                    + "Type = '" + animal.getType() + "',"
                    + "Age = '" + animal.getAge() + "',"
                    + "Location = '',"
                    + "WaterType = '" + waterType + "',"
                    + "CanFly = '" + canFly +  "',"
                    + "Availability = '" + animal.getIsAvailable() + "',"
                    + "Cost = '" + animal.getCost() + "' "
                    + "WHERE AnimalID = '" + animal.getAnimalID() + "'");
            
            conn.close();
            
        }
        catch(Exception e){
            System.out.println("Error editing animals: " + e.getMessage());
        }
    }
    
    
    public void DeleteAnimal(int animalId){
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE FROM Animals WHERE AnimalID = '" + animalId + "'");
            
            conn.close();
            
        }
        catch(Exception e){
            System.out.println("Error deleting animals: " + e.getMessage());
        }
    }
    
    
    public void WriteOrder(Order order, String zooKeeperEmail){
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO Orders (OrderId, OrderDate, zooKeeper, OrderTotal, Status) VALUES (" +
                    "'" + order.getOrderID() + "'," +
                    "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderDate()) + "'," +
                    "'" + zooKeeperEmail + "'," +
                    "'" + order.getOrderTotal() + "'," +
                    "'" + order.getStatus() + "')"
            );
            
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error writeing order: " + e.getMessage());
        }
    }
}
