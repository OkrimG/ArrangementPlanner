import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;

class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
    private Locationregister lregister = new Locationregister();


    public Gui() {

        setSize(900, 700);
        setResizable(false);
        setLayout(new BorderLayout());
        setTitle("ArrangementPlanner");
        }
      
    
    public void writeObjectToFile (String filename) {
        try (ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(filename + "KH.lokale"))) {
            Location l = new Location();
            file.writeInt(l.getNextnr());
            file.writeObject(lregister);
        } catch (NotSerializableException nse) {
            System.out.println("File NotSerializableException");
        } catch (IOException ioe) {
            System.out.println("File IOException");
        }
    }

    public void readObjectFromFile(String filename) {
        try (ObjectInputStream file = new ObjectInputStream(new FileInputStream(filename + "KH.lokale"))) {
            Location l = new Location();
            l.setLocationnr(file.readInt());
            lregister = (Locationregister) file.readObject();
        } catch (ClassNotFoundException cnfe) {
            lregister = new Locationregister();
        } catch (FileNotFoundException fnfe) {
            lregister = new Locationregister();
        } catch (IOException ioe) {
            lregister = new Locationregister();
        }
    }
}
