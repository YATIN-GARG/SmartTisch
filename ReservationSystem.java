import java.util.*;

public class ReservationSystem{
    Vector<Table> total_tables;
    public Admin admin_user;
    public Vector<Guest> guests;

    public ReservationSystem(String Name){
        this.total_tables = new Vector<Table> ();
        this.admin_user = new Admin(Name);
        this.guests = new Vector<Guest> ();
    }
}
