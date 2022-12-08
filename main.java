import java.util.*;

// driver
public class main
{
  public static void main(String args[])
  {
    System.out.println("SmartTisch");
    // add calls and definitions as per flow
    control obj = control.createControl();

    //Multiple Tables in system
    obj.addTable(2);
    obj.addTable(2);
    obj.addTable(2);
    obj.addTable(3);
    obj.addTable(4);

    // obj.print_Tables();

    int user_id1 = obj.addGuest("Sakshi", "12345");
    int user_id2 = obj.addGuest("yatin", "12345");
    int user_id3 = obj.addGuest("harshit", "12345");

    Guest g1 = obj.signIn(user_id1);
    Guest g2 = obj.signIn(user_id2);
    Guest g3 = obj.signIn(user_id3);


    Table t1 = obj.searchAvailability(2, 9);
    int r1=0;
    if(t1!=null){
      r1 = obj.addReservation(g1, t1, 2, 9);
    }else{
      System.out.println("Table Not Available");
    }


    Table t2 = obj.searchAvailability(2, 9);
    if(t2!=null){
      obj.addReservation(g2, t2, 2, 9);
    }else{
      System.out.println("Table Not Available");
    }

    Table t3 = obj.searchAvailability(2, 9);
    if(t3!=null){
      obj.addReservation(g3, t3, 2, 9);
    }else{
      System.out.println("Table Not Available");
    }
  }
}
