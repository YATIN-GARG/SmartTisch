import java.util.*;

public class control{
    private ReservationSystem s;

    public static control controller;
    public static control createControl()
    {
        if(controller!=null)
            return controller;
        else{
            controller = new control();
            return controller;
        }
    }

    static
    {
        // System.out.println("static");
        controller = null;
    }

    private control(){
        s = new ReservationSystem("Admin1");
        // System.out.println("constructor");
    }

    public Guest signIn(int id){
        for(int i=0; i<s.guests.size(); i++){
            if(s.guests.get(i).getGuestID()==id){
                return s.guests.get(i);
            }
        }
        return null;
    }

    public void addTable(int argDefaultSize){
        Table new_table = s.admin_user.createTable(argDefaultSize);
        s.total_tables.addElement(new_table);
    }

    public void print_Tables(){
        for(int i=0; i<s.total_tables.size(); i++){
            System.out.println(s.total_tables.get(i).getDefaultSize() + " "+s.total_tables.get(i).getTableNumber());
        }
    }

    public int addReservation(Guest argGuest, Table argTable, int argGroupSize, int argReservationTime){
        Reservation r = s.admin_user.createReservation(argGuest, argTable, argGroupSize, argReservationTime);
        s.reservations.addElement(r);
        String user = argGuest.getName();
        System.out.println("Table Reservation Successful for " + user);
        return r.getReservationID();
    }

    public void cancelReservation(int reservation_id){
        for(int i=0; i<s.reservations.size(); i++){
            if(s.reservations.get(i).getReservationID() == reservation_id){
                Reservation r = s.reservations.get(i);

                r.cancelReservation();

                for(int j=i; j<s.reservations.size()-1; j++){
                    s.reservations.set(j, s.reservations.get(j+1));
                }
                s.reservations.remove(s.reservations.size()-1);
                break;
            }
        }
    }

    public int addGuest(String argName, String argPhoneNumber){
        Guest new_guest = s.admin_user.createGuest(argName, argPhoneNumber);
        s.guests.addElement(new_guest);
        return new_guest.getGuestID();
    }

    public Table searchAvailability(int argCapacity, int argStartTime){
        for(int i=0; i<s.total_tables.size(); i++){
            if(s.total_tables.get(i).getDefaultSize()>=argCapacity){
                Vector<Reservation> reservationList = s.total_tables.get(i).getReservation();
                boolean flag=false;
                for(int j=0; j<reservationList.size(); j++){
                    if(reservationList.get(j).getReservationTime()==argStartTime){
                        flag=true;
                        break;
                    }
                }

                if(!flag) return s.total_tables.get(i);
            }
        }
        return null;
    }
}
