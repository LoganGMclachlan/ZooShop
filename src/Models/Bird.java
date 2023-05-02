package Models;

/**
 *
 * @author logan
 */

// inherits from Animal class
public class Bird extends Animal{
    
    // attributes for bird class
    private boolean canFly;
    
    // o parameter constructor
    public Bird()
    {
        super();
        canFly = true;
    }
    
    // 8 parameter constructor
    public Bird(boolean canFlyIn, int animalIDIn, String nameIn, String typeIn, int ageIn, double costIn,
            boolean isAvailableIn, char genderIn)
    {
        super(animalIDIn, nameIn, typeIn, ageIn, costIn,
            isAvailableIn, genderIn);
        canFly = canFlyIn;
    }
    
    // 7 parameter constructor
    public Bird(boolean canFlyIn, String nameIn, String typeIn, int ageIn, double costIn,
            boolean isAvailableIn, char genderIn)
    {
        super(nameIn, typeIn, ageIn, costIn,
            isAvailableIn, genderIn);
        canFly = canFlyIn;
    }
    
    
    // getters for bird class
    public boolean getCanFly()
    {
        return canFly;
    }
    
    // setters for bird class
    public void setCanFly(boolean canFlyIn)
    {
        canFly = canFlyIn;
    }
}
