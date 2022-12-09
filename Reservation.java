import java.util.*;

// association class: realizing link of object :Guest and object :Table
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

    public int getReservationID(){
        return reservationID;
    }

    public void cancelReservation()
    {
        Vector<Reservation> reservations = rev_table.getReservation();
        // search for reservation in list of references to Reservation
        for(int i=0; i<reservations.size(); i++)
        {
            // check whether this instance equals the reference
            if(reservations.get(i) == this)
            {
                // remove reservation from the list of references
                for(int j=i; j<reservations.size()-1; j++)
                {
                    reservations.set(j, reservations.get(j+1));
                }                
                reservations.remove(reservations.size()-1);
                break;
                // reservation removed
            }
        }
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
        // argTable.assignTable();
        groupSize = argGroupSize;
        reservationTime = argReservationTime;
        
        // reservationID(s) are assigned subsequent numbers beginning from 100001
        reservationID = ++count + 100000;       
        // add this Reservation to the list of references in argTable
        argTable.addReservation(this);
    }
}
