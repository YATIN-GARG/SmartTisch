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
public class Admin extends Employee
{
    // add fields

    public Guest createGuest(String argName, String argPhoneNumber)
    {
        return Guest(argName, argPhoneNumber);
    }

    public Vector<Table> createTableList(int argCount, String argSection[], int argDefaultSize[])
    {
        Vector<Table> TableList = new Vector<Table>();
        for(int index = 0; index < argCount; ++index)
            TableList.addElement(Table(argSection[index], argDefaultSize[index]));
        return TableList;
    }

    public void deleteTableList()
    {
        // either define destructor or assign NULL to references
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
    private int reservationTime;
    private String sectionPreference;

    private Guest visitor;              // Guest who reserves table(s)
    private Vector<Table> tableList;    // List of reserved table(s)
    private int tableCount;             // Count of reserved table(s)

    public void createReservation()
    {
        // constructor would serve the purpose
    }

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

    public Reservation(Guest argGuest, Table[] argTable, int argTableCount, int argGroupSize, int argReservationTime, String argSectionPreference)
    {
        visitor = argGuest;
        tableList = new Vector<Table>();
        for(int index = 0; index < argTableCount; ++argCount)
        {
            tableList.addElement(argTable[index]);
            argTable[index].tableStatus = true;
        }
        tableCount = argTableCount;

        groupSize = argGroupSize;
        reservationTime = argReservationTime;
        sectionPreference = argSectionPreference;
        reservationID = ++count + 100000;       // reservationID(s) are assigned subsequent numbers beginning from 100001
    }
}


// add more class definitions
