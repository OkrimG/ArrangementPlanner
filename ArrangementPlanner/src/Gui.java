import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

	public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;

    private Locationregister lregister = new Locationregister();
    private JLabel labelUsername = new JLabel("Enter username: ");
    private JLabel labelPassword = new JLabel("Enter password: ");
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox textUsername = new JComboBox(new String[]{"User","Admin"});
    private JPasswordField fieldPassword = new JPasswordField(20);
    private JButton buttonLogin = new JButton("Login");

    public  Gui() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(900, 700);
        setResizable(true);
        
        JPanel newPanel = new JPanel(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        constraints.gridx = 0;
        constraints.gridy = 0;     
        newPanel.add(labelUsername, constraints);
 
        	
        constraints.gridx = 1;
        newPanel.add(textUsername, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 1;     
        newPanel.add(labelPassword, constraints);
         
        constraints.gridx = 1;
        newPanel.add(fieldPassword, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonLogin, constraints);
         
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));
         
        // add the panel to this frame
        add(newPanel);
         
        pack();
        
        
        Buttonlistener listener = new Buttonlistener();
        buttonLogin.addActionListener(listener);
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

    private class Buttonlistener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonLogin) {
            	  String uname = (String) textUsername.getSelectedItem();
                  String pass = new String(fieldPassword.getPassword());
                   if (uname.equals("Admin") && pass.equals("admin"))
                  {
                	Admin newadmin = new Admin();
                	newadmin.setVisible(true);
                	newadmin.setLocationRelativeTo(null);
                	dispose();
                  }
                   else if (uname.equals("User") && pass.equals("user"))
                   {
                 	User newuser = new User();
                 	newuser.setVisible(true);
                 	newuser.setLocationRelativeTo(null);
                 	dispose();
                   }
                   else
                    {
                      JOptionPane.showMessageDialog(buttonLogin, "Incorrect login or password",
                       "Error",JOptionPane.ERROR_MESSAGE);  
                    }
                 
            }   
        }
    }

}
