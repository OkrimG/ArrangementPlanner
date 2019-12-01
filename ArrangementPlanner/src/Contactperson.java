import java.io.*;
import javax.swing.JTextField;

public class Contactperson implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
   	private String epost;
   	private String firma;
   	private String type;
	private int telephonnumber;
    private int arrangement = 0;

        
        
    	public Contactperson (String name, String mail, String f, String t, int nr)
	{
			this.name = name;
			epost = mail;
			firma = f;
			type = t;
			telephonnumber = nr;
		}

    		public String getName()
    		{
    	    	return name;
    		}

    		public String getFirma()
    		{
        		return firma;
    		}

    		public String getType()
    		{
        		return type;
    		}

    		public int getTelephonnumber()
    		{
        		return telephonnumber;
    		}
               
                public String getEpost()
    		{
        		return epost;
    		}
//------------------------------------------------------------ 
                public void setArrangement(int arrnr) {
                    arrangement = arrnr;
                }

                public int getArrangement() {
                    return arrangement;
                }
//------------------------------------------------------------
    public String toString(boolean value)
    {
        String s;

            if(arrangement > 0)
            	s = "Ja";
            else
            	s = "Contactperson has no arrangement";

            if(value) 
                return "Name: "+	name	+"\nEpost: "+	epost	+
                		"\nFirma: "+	firma	+"\nType: "+	type	+
            			"\nTelephonnummer: "+	telephonnumber +"\nArrangement: "+	s	+"\n" ;
            else
                return "\tName: "+	name	+"\n\tEpost: "+	epost	+
			       	"\n\tFirma: "+	firma	+"\n\tType: "+	type	+
            			"\n\tTelephonnummer: "+	telephonnumber + "\n";        
    }
}

	
