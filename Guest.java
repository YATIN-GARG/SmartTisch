import java.util.*;

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

    public int getGuestID(){
        return guestID;
    }

    public String getName(){
        return name;
    }

    public Guest(String argName, String argPhoneNumber)
    {
        guestID = ++count + 1000;       // guestID(s) are assigned subsequent numbers beginning from 1001
        name = argName;
        phoneNumber = argPhoneNumber;
    }
}