import java.io.Serializable;

public class Location implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name, type, picture;
	private int amountofseats;
	private boolean numberedplaces;
	private int locationnr = 0;
	private int nextnr = 1;
	private int arrangement = 0;
	
	public Location(){}    
	
	    public Location (String n, String t, int as, boolean nr, String img) {
	        name = n;
	        type = t;
	        amountofseats = as;
	        numberedplaces = nr;
	        picture = img;
	        locationnr = nextnr;
	        nextnr++;
	    }
	    
	    public int getLocationnr() {
	        return locationnr;
	    }
	    
	    public int getNextnr() {
	        return nextnr;
	    }
	    
	    public void setLocationnr(int locationnr) {
	        this.nextnr = locationnr;
	    }
	    
	    public String getName(){
	        return name;
	    }
	    
	    public String getType(){
	        return type;
	    }
	    
	    public int getAmountofseats(){
	        return amountofseats;
	    }
	    
	    public boolean getsSeatnumber() {
	        return numberedplaces;
	    }
	    
	    public String getPicture() {
	        return picture;
	    }
	    
	    public int getArrangement() {
	        return arrangement;
	    }
	    
	    public void setArrangement(int arrangement) {
	        this.arrangement = arrangement;
	    }
	    
	    public String toString(boolean verdi) {
	        String s;
	        if(numberedplaces == true) {
	            s = "nummerte"; }
	        else {
	            s = "ikke nummerte"; }
	        
	        if(verdi) {
	            return "Locationnr: " + locationnr +  "\nName: " + name  + "\nType: " + type + "\nSeats: " + amountofseats + " Amount " + s + "Seat\n" + picture;
	        } else
	            return " Lokale: " + locationnr + " - " + name;
	    }
}
