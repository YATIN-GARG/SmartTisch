import java.util.*;

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
    private Vector<Reservation> reservationList;


    public boolean getTableStatus(){
        return tableStatus;
    }

    public int getDefaultSize(){
        return defaultSize;
    }

    public int getTableNumber(){
        return tableNumber;
    }

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

    public Vector<Reservation> getReservation(){
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