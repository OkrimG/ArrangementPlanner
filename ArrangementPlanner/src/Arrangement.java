import java.io.Serializable;

public class Arrangement implements Serializable {

	private static final long serialVersionUID = 1L;
	private String type;
    private String name;
    private String artist;
    private String program;
    private double time;
    private int ticketprice;
    //---------------------------------------------------------
    private int arrnr = 0;
    private static int nextnr= 1;
    private int contactperson = 0;
    private int ticketnr = 0;
    private int location = 0;
    //---------------------------------------------------------
    
    public Arrangement(){}
    
    public Arrangement (String t, String n, String art, String p, double ti, int tp) {
        type = t;
        name = n;
        artist = art;
        program = p;
        time = ti;
        ticketprice = tp;
        
        arrnr = nextnr;
        nextnr++;
    }
//---------------------------------------------------------    
    public int getArrnr() {
        return arrnr;
    }
    
    public int getNestenr() {
        return nextnr;
    }
    
    public void setArrnr(int arrnr) {
        Arrangement.nextnr = arrnr;
    }
//---------------------------------------------------------    
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public String getProgram() {
        return program;
    }
    
    public double getTime() {
        return time;
    }
    
    public int getPrice() {
        return ticketprice;
    }
//---------------------------------------------------------    
    public int getContactperson() {
        return contactperson;
    }
    
    public void setContactperson(int contactperson) {
        this.contactperson = contactperson;
    }
    
    public void setLocation( int locationnr ) {
        location = locationnr;
    }
    
    public int getLocation() {
        return location;
    }
    
    public int getTicket() {
        return tp;
    }
    
    public void setBnr( int tp ) {
        this.tp = tp;
    }
//---------------------------------------------------------    
    public String toString(boolean value) {
        
        if(value) {
            return "----------------------------------------------------------\n"
                    + "[ARRANGEMENT]\t" + name + "\n";
        }   
        else    
            return "-Arrangementnr: " + arrnr + "-\n Name: "+	name	+ "\n Type: "+	type	+
                   "\n Artist: "+	artist	+"\n Program: "+	program	+
                   "\n Time "+	time	+"\n Ticketprice: "+	ticketprice	+"\n";
    }
}