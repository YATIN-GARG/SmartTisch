package SmartTisch;

public class control{
    private System s;

    private control(){
        s = System("Admin1");
    }

    private void addTable(int argDefaultSize){
        Table new_table = s.admin_user.createTable(argDefaultSize);
        total_tables.addElement(new_table);
    }

    private void addReservation(Guest argGuest, Table argTable, int argGroupSize, int argReservationTime){
        s.admin_user.createReservation(argGuest, argTable, argGroupSize, argReservationTime);
    }

    private void addGuest(String argName, String argPhoneNumber){
        Guest new_guest = s.admin_user.createGuest(argName, argPhoneNumber);
        s.guests.addElement(new_guest);
    }

    private Table searchAvailablity(int argCapacity, int argStartTime){
        for(int i=0; i<s.total_tables.size(); i++){
            if(s.total_tables[i].tableStatus!=true && s.total_tables[i].defaultSize>=argCapacity){
                return total_tables[i];
            }else if(s.total_tables[i].tableStatus==true && s.total_tables[i].defaultSize>=argCapacity){
                vector<Reservation> reservationList = table_tables[i].getReservation();
                for(int i=0; i<reservationList.size(); i++){
                    if(reservationList[i].getReservationTime()==argStartTime){
                        return NULL;
                    }
                }
                return total_tables[i];
            }else{
                return NULL;
            }
        }
    }
}