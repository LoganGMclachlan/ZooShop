package Models;


import Models.Animal;



/**
 *
 * @author logan
 */

// inherits from animal class
public class Fish extends Animal{
    
    // attributes for fish class
    private String waterType;
    
    
    // o parameter constructor
    public Fish()
    {
        super();
        waterType = "";
    }
    
    // 8 parameter constructor
    public Fish(String waterTypeIn, int animalIDIn, String nameIn, String typeIn, int ageIn, double costIn,
            boolean isAvailableIn, char genderIn)
    {
        super(animalIDIn, nameIn, typeIn, ageIn, costIn,
            isAvailableIn, genderIn);
        waterType = waterTypeIn;
    }
    
    // 7 parameter constructor
    public Fish(String waterTypeIn, String nameIn, String typeIn, int ageIn, double costIn,
            boolean isAvailableIn, char genderIn)
    {
        super(nameIn, typeIn, ageIn, costIn,
            isAvailableIn, genderIn);
        waterType = waterTypeIn;
    }
    
    
    // getters for fish class
    public String getWaterType()
    {
        return waterType;
    }
    
    // setters for fish class
    public void setCanFly(String waterTypeIn)
    {
        waterType = waterTypeIn;
    }
}
