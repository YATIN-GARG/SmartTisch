// class of entity objects :Table 
public class Table
{
    private int tableNumber;
    // section
    private int defaultSize;
    private boolean tableStatus;    // signifies whether reserved
    
    // add fields
    
    public void assignTable(Reservation arg)
    {
        //
        tableStatus = 1;
    }
    
    public void clearTable()
    {
        //
        tableStatus = 0;
    }
    
    public boolean CheckStatus()
    {
        return tableStatus;
    }
    // add methods
    
    public Table(int argDefaultSize)
    {
        // define constructor
        defaultSize = argDefaultSize;
        tableStatus = 0;
    }
}


// class of entity objects :Guest
public class Guest
{
    private int guestID;
    private String name;
    private String phoneNumber;
    
    // add fields
    
    // add methods
    
    public Guest(String argName, String argPhoneNumber)
    {
        // define constructor
        name = argName;
        phoneNumber = argPhoneNumber;
    }
}


// association class: realising link of object :Guest and object :Table 
public class Reservation
{
    // add fields
    
    // add methods
    
    public Reservation(Guest argGuest, Table argTable)
    {
        // define constructor
    }
}


// add more class definitions
