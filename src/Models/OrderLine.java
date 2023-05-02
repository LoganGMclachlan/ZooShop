package Models;


import Models.Animal;


/**
 *
 * @author logan
 */
public class OrderLine {
    
    // attributse for OrderLine class
    private int orderLineID;
    private Animal animal;
    private double lineTotal;
    
    // class costructors
    // 3 paramenter constructor
    public OrderLine(int orderLineIDIn, Animal animalIn, double lineTotalIn)
    {
        orderLineID = orderLineIDIn;
        animal = animalIn;
        lineTotal = lineTotalIn;
    }
    
    // 2 parameter constructor (all except lineTotal)
    public OrderLine(int orderLineIDIn, Animal animalIn)
    {
        orderLineID = orderLineIDIn;
        animal = animalIn;
        // gets lineTotal from animal object
        lineTotal = animal.getCost();
    }
    
    // class getters
    public int getOrderLineID()
    {
        return orderLineID;
    }
    
    public Animal getAnimal()
    {
        return animal;
    }
    
    public double getLineTotal()
    {
        return lineTotal;
    }
    
    // class setters
    public void setOrderLineID(int orderLineIDIn)
    {
        orderLineID = orderLineIDIn;
    }
    
    public void setAnimal(Animal animalIn)
    {
        animal = animalIn;
    }
    
    public void setLineTotal(double lineTotalIn)
    {
        lineTotal = lineTotalIn;
    }
}
