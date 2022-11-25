// class of entity objects :Employee
public class Employee
{
    private String name;
    private String position;
    
    public Employee(String argName, String argPosition)
    {
        name = argName;
        position = argPosition;
    }
}


// class of entity object :Admin (subclass of Employee)
class Admin extends Employee
{
    // add fields
    
    public void createGuest()
    {
        //
    }
    
    public void createTableList()
    {
        //
    }
    
    public void deleteTableList()
    {
        //
    }
}


// class of entity objects :Table 
public class Table
{
    static int count;
    static
    {
        count = 0;            
    }
    
    private int tableNumber;
    private String section;
    private int defaultSize;
    private boolean tableStatus;    // signifies whether reserved
    
    public void assignTable()
    {
        tableStatus = true;
    }
    
    public void clearTable()
    {
        tableStatus = false;
    }
    
    public boolean CheckStatus()
    {
        return tableStatus;
    }
    
    public Table(String argSection, int argDefaultSize)
    {
        tableNumber = ++count + 100;        // tableNumber(s) are assigned subsequent numbers beginning from 101
        section = argSection;
        defaultSize = argDefaultSize;
        tableStatus = false;
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
    private int reservationID;
    private int groupSize;
    private int reservationTime;
    // sectionPreference
    
    private Vector tableList;       // list of associated tables
    // add fields
    
    public void createReservation()
    {
        //
    }
    
    public void cancelReservation()
    {
        //
    }
    
    public void modifyReservation()
    {
        //
    }
    
    // add methods
    
    public Reservation(Guest argGuest, Table[] argTable, int argCount)
    {
        // define constructor
        tableList = new Vector();
        for(int index = 0; index < argCount; ++argCount)
            tableList.addElement(argTable[index]);
    }
}


// add more class definitions
