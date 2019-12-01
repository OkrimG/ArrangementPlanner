
import java.io.*;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
	private int seatnumber, telephonenumber;
    private int ticketnr;
    private static int nextSeatnr = 1;
    private static int nextnr = 10001;
    private int arrangementnr;
    private int arrangement;
    
    
    public Ticket ( int anr, int tlf, int seatnr ) {
        this.arrangement = anr;
        seatnumber = seatnr;
        seatnumber = nextSeatnr;
        nextnr++;
        telephonenumber = tlf;
        
        ticketnr = nextnr;
        nextnr++;
    }
    
        
    public int getTicketnr() {
        return ticketnr;
    }
    
    int getArrangementnr() {
        return arrangementnr;
    }
    
    public int getNextnr() {
        return nextnr;
    }
    
    public void setTicketnr( int ticketnr ) {
        Ticket.nextnr = ticketnr;
    }
    
    public int getSeatnr() {
        return seatnumber;
    }

    public int getTelephonnumber() {
        return telephonenumber;
    }

    public int getArrangement() {
        return arrangement;
    }
    
    public void setArrangement(int arrangement) {
        this.arrangement = arrangement;
    }
    
    public String toString() {
        return " " + seatnumber + " ;\n";
    }
 
}