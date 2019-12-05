
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Main {
    
    public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable()
          {
            public void run()
            {
                Gui gui = new Gui();
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.setVisible(true);
                gui.setLocationRelativeTo(null);
                gui.writeObjectToFile("");

            }
      });
   }
} 
    

