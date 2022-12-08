import java.util.*;

public class control{
    private ReservationSystem s;
    
    public static control controller;
    public static control createControl()
    {
        if(controller)
            return controller;
        else
            return control();
    }
    
    static
    {
        controller = NULL;
    }

    private control(){
        s = new ReservationSystem("Admin1");
    }

    private void addTable(int argDefaultSize){
        Table new_table = s.admin_user.createTable(argDefaultSize);
        s.total_tables.addElement(new_table);
    }

    private void addReservation(Guest argGuest, Table argTable, int argGroupSize, int argReservationTime){
        s.admin_user.createReservation(argGuest, argTable, argGroupSize, argReservationTime);
    }

    private void addGuest(String argName, String argPhoneNumber){
        Guest new_guest = s.admin_user.createGuest(argName, argPhoneNumber);
        s.guests.addElement(new_guest);
    }

    private Table searchAvailability(int argCapacity, int argStartTime){
        for(int i=0; i<s.total_tables.size(); i++){
            if(s.total_tables.get(i).getTableStatus()!=true && s.total_tables.get(i).getDefaultSize()>=argCapacity){
                return s.total_tables.get(i);
            }else if(s.total_tables.get(i).getTableStatus()==true && s.total_tables.get(i).getDefaultSize()>=argCapacity){
                Vector<Reservation> reservationList = s.total_tables.get(i).getReservation();
                for(int j=0; j<reservationList.size(); j++){
                    if(reservationList.get(j).getReservationTime()==argStartTime){
                        return null;
                    }
                }
                return s.total_tables.get(i);
            }else{
                return null;
            }
        }
        return null;
    }
}
