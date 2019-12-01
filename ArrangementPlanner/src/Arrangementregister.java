import java.io.*;
import java.util.*;
import javax.swing.JTextArea;

public class Arrangementregister implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Arrangement> reg = new ArrayList<>();
        
    public boolean emptyRegister(){
        return reg.isEmpty();
    }
    
    public boolean insert( Arrangement a ){
        if(a == null)
            return false;
        
        reg.add(a);
        return true;
    }
    
    public Arrangement searchArrangement( int arrnr ){
        try {
            for (Arrangement exists : reg)
                if(exists.getArrnr() == arrnr)
                    return exists;
        } catch (Exception ex){
            return null;
        }
        return null;
    }
        
    public void writeList( JTextArea list, Contactpersonregister contactreg, Locationregister locationreg)
    {
        String message = "";
        if(emptyRegister()) {
            message = "No arrangements found!";
        }
        else
        {       
                for ( Arrangement a : reg) {
                	message += a.toString(false);
                	message += locationreg.findArrangement(a.getArrnr());
                	message += contactreg.findArrangement(a.getArrnr());
                }
        } list.setText(message);      
    }
}