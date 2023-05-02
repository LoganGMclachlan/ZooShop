package Models;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author logan
 */
public class Order {
    
    // attributes for Order class
    private int orderID;
    private Date orderDate;
    private double orderTotal;
    private String status;
    // hashmap holds each line of the order as OrderLine class
    private HashMap<Integer, OrderLine> orderLines;
    
    // class constructors
    // 0 parameter constructor 
    public Order()
    {
        orderID = 0;
        orderDate = new Date();
        orderTotal = 0.0;
        status = "In progress";
        orderLines = new HashMap();
    }
    
    // 4 parameter constructor (all except orderLines)
    public Order(int orderIDIn, Date orderDateIn, double orderTotalIn, String statusIn)
    {
        orderID = orderIDIn;
        orderDate = orderDateIn;
        orderTotal = orderTotalIn;
        status = statusIn;
        orderLines = new HashMap();
    }
    
    public void removeOrderLine(int animalID){
        
        int orderLineID = -1;
        for(Map.Entry<Integer, OrderLine> olEntry : orderLines.entrySet())
        {
            OrderLine existingOrderLine = olEntry.getValue();
            
            if(animalID == existingOrderLine.getAnimal().getAnimalID()){
                orderLineID = existingOrderLine.getOrderLineID();
                orderTotal -= existingOrderLine.getAnimal().getCost();
            }
        }
        
        if(orderLineID != -1){
            orderLines.remove(orderLineID);
        }
    }
    
    public boolean addOrderLine(OrderLine ol){
        
        boolean canBeAdded = true;
        for(Map.Entry<Integer, OrderLine> olEntry : orderLines.entrySet())
        {
            OrderLine existingOrderLine = olEntry.getValue();
            
            if(ol.getAnimal().getAnimalID() == existingOrderLine.getAnimal().getAnimalID()){
                canBeAdded = false;
            }
        }
        
        if(canBeAdded){
            int orderLineId = 0;
        
            while (orderLines.containsKey(orderLineId)){
               orderLineId++;
            }
        
            ol.setOrderLineID(orderLineId);
            orderLines.put(orderLineId, ol);
            
            orderTotal += ol.getAnimal().getCost();
            
            return true;
        }
        else{
            return false;
        }
    }
    
    
    // class getteres
    public int getOrderID()
    {
        return orderID;
    }
    
    public Date getOrderDate()
    {
        return orderDate;
    }
    
    public double getOrderTotal()
    {
        return orderTotal;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public HashMap<Integer, OrderLine> getOrderLines()
    {
        return orderLines;
    }
    
    // class setters
    public void setOrderID(int orderIDIn)
    {
        orderID = orderIDIn;
    }
    
    public void setOrderDate(Date orderDateIn)
    {
        orderDate = orderDateIn;
    }
    
    public void setOrderTotal(double orderTotalIn)
    {
        orderTotal = orderTotalIn;
    }
    
    public void setStatus(String statusIn)
    {
        status = statusIn;
    }
    
    public void setOrderLines(HashMap<Integer, OrderLine> orderLinesIn)
    {
        orderLines = orderLinesIn;
    }
}
