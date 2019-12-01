import java.io.*;
import javax.swing.JTextArea;
import java.util.*;

public class Contactpersonregister implements Serializable {
    
    private ArrayList<Contactperson> reg = new ArrayList<>();
    
    public boolean emptyRegister(){
        return reg.isEmpty();
    }
    	
    public boolean settInn( Contactperson cp ){
        if(cp == null)
            return false;
        
        reg.add(cp);
        return true;
    } 
    
    public Contactperson findContactperson(int telephonenumber) {
        try {
            for (Contactperson exists : reg) {
                if (exists.getTelephonnumber()== telephonenumber) {
                    return exists;
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }
    
    public Contactperson checkContactperson(int telephonenumber) {    
        try {
            for (Contactperson exists : reg) {
                if (exists.getTelephonnumber() == telephonenumber) {
                    if( exists.getArrangement() > 0 ) {
                        return null;
                    } else
                        return exists;
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }
    
    public String findArrangement(int arrnr) {
        String text = "";
        for (Contactperson exists : reg) {
            if (exists.getArrangement() == arrnr) {
                return text += exists.toString(false) + "\n";
            }
        }
        return text;
    }

   	public void writeList( JTextArea contactperson ) {
            if (reg.isEmpty()) {
            	contactperson.setText("Ingen kontaktpersoner registrert.");
        } else {
            String message = "";
            for (Contactperson cp : reg) {
            	message += cp.toString(true) + "\n";
            }
            contactperson.setText(message);
        }
    }
}
