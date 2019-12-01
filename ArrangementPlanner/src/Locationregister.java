import javax.swing.JTextArea;
import java.io.*;
import java.util.*;


public class Locationregister implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private ArrayList<Location> reg = new ArrayList<>();
    
    public boolean emptyRegister(){
		return reg.isEmpty();
    }    
    
    public String findArrangement(int arrnr) {
        String text = "";
        for (Location found : reg) {
                if (found.getLocationnr() == arrnr) 
                    return text += found.toString(false)+"\n";
        }
        return text;
    }
    
    public void insert( Location l ){
		reg.add(l);
    }
    
    public Location searchLocation(int locationnr) {
        try {
            for (Location found : reg) {
                if (found.getLocationnr() == locationnr) {
                    return found;
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }
    
    public String searchLokale(int locationnr) {
        if (searchLocation(locationnr) == null) {
            return "null";
        } else {
            return searchLocation(locationnr).toString(true);
        }
    }
    
    public void writeList( JTextArea locations ) {
        if (reg.isEmpty() ) {
        	locations.setText( "Ingen lokaler registrert."); }
        else {
            String message = "";
            for (Location l : reg) {
                message += l.toString(true) + "\n";
            }
            locations.setText( message );
        }
    }
    
    public boolean ifExists(String name){
        try {
            for (Location funnet : reg) {
                if (funnet.getName() == name) {
                    return true;
                }
            }
        } catch (Exception ex) {
            return false;
        }
        return false;
    }
}