package SmartTisch;

// class of entity objects :Employee
public class System{
    vector<Table> total_tables;
    private Admin admin_user;
    private vector<Guest> guests;

    private System(String Name){
        this.total_tables = new Vector<table> ();
        this.admin_user = Admin(Name);
        this.guests = new Vector<Guest> ();
    }
}


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
        return Guest(argName, argPhoneNumber);
    }

    public Table createTable(int argDefaultSize)
    {
        return Table(argDefaultSize);
    }

    public void deleteTable()
    {
        // either define destructor or assign NULL to references
    }

    public void createReservation(Guest argGuest, Table argTable, int argGroupSize, int argReservationTime){
        Reservation r = Reservation(argGuest, argTable, argGroupSize, argReservationTime)
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
    private int defaultSize;
    private boolean tableStatus;    // signifies whether reserved

    private vector<Reservation> reservationList;

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

    public void addReservation(Reservation argReservation){
        reservationList.addElement(argReservation);
    }

    public vector<Reservation> getReservation(){
        return reservationList;
    }

    public Table(int argDefaultSize)
    {
        tableNumber = ++count + 100;        // tableNumber(s) are assigned subsequent numbers beginning from 101
        defaultSize = argDefaultSize;
        tableStatus = false;
        reservationList = new Vector<Reservation> ();
    }
}


// class of entity objects :Guest
public class Guest
{
    static int count;
    static
    {
        count = 0;
    }

    private int guestID;
    private String name;
    private String phoneNumber;

    // add fields


    // add methods

    public Guest(String argName, String argPhoneNumber)
    {
        guestID = ++count + 1000;       // guestID(s) are assigned subsequent numbers beginning from 1001
        name = argName;
        phoneNumber = argPhoneNumber;
    }
}


// association class: realising link of object :Guest and object :Table
public class Reservation
{
    static int count;
    static
    {
        count = 0;
    }

    private int reservationID;
    private int groupSize;
    private int reservationTime;        //Reservation Start time and duration is fixed

    private Guest visitor;              // Guest who reserves table(s)
    private Table rev_table;   // List of reserved table(s)

    public void cancelReservation()
    {
        // setting the reserved tables free
        for(int index = 0; index < tableCount; ++index)
            tableList[index].tableStatus = false;
    }

    // argAlternative signifies the kind of modification
    public boolean modifyReservation(int argAlternative, int argCount = 0, Table argTable[] = NULL)
    {
        switch(expression)
        {
            case 1:     // reserve table(s) in addition
                for(int index = 0; index < argCount; ++index)
                {
                    tableList.addElement(argTable[index]);
                    argTable[index].tableStatus = true;
                }
                tableCount += argCount;
                break;

            // add more alternatives
        }

        return 0;   // success
    }

    // add methods

    public int getReservationTime(){
        return reservationTime;
    }

    public Reservation(Guest argGuest, Table argTable, int argGroupSize, int argReservationTime)
    {
        visitor = argGuest;
        rev_table = argTable;
        argTable.tableStatus = true;

        argTable.addReservation(this);

        groupSize = argGroupSize;
        reservationTime = argReservationTime;
        reservationID = ++count + 100000;       // reservationID(s) are assigned subsequent numbers beginning from 100001
    }
}


// add more class definitions
