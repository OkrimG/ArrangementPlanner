
import java.io.*;
import java.util.*;
import javax.swing.JTextArea;

public class Ticketregister implements Serializable {
   

	private static final long serialVersionUID = 1L;
	private ArrayList<Ticket> reg = new ArrayList<>();
    
    public boolean emptyRegister(){
        return reg.isEmpty();
    }
    
    public boolean settInn( Ticket t ){
        if(t == null)
            return false;
        
        reg.add(t);
        return true;
    }
    
    
    public void writeList ( JTextArea tickets ) {
        if (reg.isEmpty()) {
        	tickets.setText("No Tickets found");
        } else {
            String message = "";
            for (Ticket t : reg) {
            	message += t.toString() + "\n";
            }
            tickets.setText(message);
        }
    }
    
    public Ticket findTicket (int ticketnr) {
        try {
            for (Ticket exists : reg) {
                if (exists.getTicketnr()== ticketnr) {
                    return exists;
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }
    
    public Ticket findArrTicket(int arrangementnr) {
        try {
            for (Ticket exists : reg) {
                if (exists.getArrangementnr() == arrangementnr) {
                    return exists;
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
        
    }
    
    public Ticket checkArrTicket(int anr, int seatnr) {
        try {
            for (Ticket exists : reg) {
                if (exists.getArrangementnr() == anr
                        && exists.getSeatnr() == seatnr) {
                    return exists;
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }
    
    public int checkMaxamount(int anr) {
        int max = 1;
        
        for (Ticket exists : reg) {
            if (exists.getArrangementnr() == anr) {
                max++;
            }
        }
        return max;
    }

}
