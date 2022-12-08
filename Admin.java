import java.util.*;

// class of entity object :Admin (subclass of Employee)
public class Admin
{
    // add fields
    private String name;

    public Admin(String argName)
    {
        name = argName;
    }

    public Guest createGuest(String argName, String argPhoneNumber)
    {
        return new Guest(argName, argPhoneNumber);
    }

    public Table createTable(int argDefaultSize)
    {
        return new Table(argDefaultSize);
    }

    // public void deleteTable()
    // {
    //     // either define destructor or assign NULL to references
    // }

    public void createReservation(Guest argGuest, Table argTable, int argGroupSize, int argReservationTime){
        Reservation r = new Reservation(argGuest, argTable, argGroupSize, argReservationTime);
    }
}