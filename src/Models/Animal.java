package Models;


/**
 *
 * @author logan
 */
public class Animal {
 
    // attributes for animal class
    private int animalID;
    private String name;
    private String type;
    private int age;
    private double cost;
    private boolean isAvailable;
    private char gender;
    
    // class constructors
    // 0 paramater constructor
    public Animal()
    {
        animalID = 0;
        name = "";
        type = "";
        age = 0;
        cost = 0.0;
        isAvailable = false;
        gender = ' ';
    }
    
    // 7 paramater constructor
    public Animal(int animalIDIn, String nameIn, String typeIn, int ageIn, double costIn,
            boolean isAvailableIn, char genderIn)
    {
        animalID = animalIDIn;
        name = nameIn;
        type = typeIn;
        age = ageIn;
        cost = costIn;
        isAvailable = isAvailableIn;
        gender = genderIn;
    }
    
    // 6 paramater constructor (without animal ID)
    public Animal(String nameIn, String typeIn, int ageIn, double costIn,
            boolean isAvailableIn, char genderIn)
    {
        animalID = 0;
        name = nameIn;
        type = typeIn;
        age = ageIn;
        cost = costIn;
        isAvailable = isAvailableIn;
        gender = genderIn;
    }
    
    @Override
    public String toString()
    {
        String display = name + " the " + type;
        return display;
    }
    
    // class getters
    public int getAnimalID()
    {
        return animalID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getType()
    {
        return type;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public double getCost()
    {
        return cost;
    }
    
    public boolean getIsAvailable()
    {
        return isAvailable;
    }
    
    public char getGender()
    {
        return gender;
    }
    
   
    // class setters
    public void setAnimalID(int animalIDIn)
    {
        animalID = animalIDIn;
    }
    
    public void setName(String nameIn)
    {
        name = nameIn;
    }
    
    public void setType(String typeIn)
    {
        type = typeIn;
    }
    
    public void setAge(int ageIn)
    {
        age = ageIn;
    }
    
    public void setCost(double costIn)
    {
        cost = costIn;
    }
    
    public void setIsAvailable(boolean isAvailableIn)
    {
        isAvailable = isAvailableIn;
    }
    
    public void setGender(char genderIn)
    {
        gender = genderIn;
    }
}
