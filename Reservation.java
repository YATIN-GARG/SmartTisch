import java.util.*;

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
        // for(int index = 0; index < tableCount; ++index)
        //     tableList[index].tableStatus = false;
    }

    // argAlternative signifies the kind of modification
    //public boolean modifyReservation(int argAlternative, int argCount = 0, Table argTable[] = NULL)
    //{
        // switch(expression)
        // {
        //     case 1:     // reserve table(s) in addition
        //         for(int index = 0; index < argCount; ++index)
        //         {
        //             tableList.addElement(argTable[index]);
        //             argTable[index].tableStatus = true;
        //         }
        //         tableCount += argCount;
        //         break;

        //     // add more alternatives
        // }

        // return 0;   // success
    //}

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
