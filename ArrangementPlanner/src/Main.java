
import java.awt.EventQueue;
import javax.swing.JFrame;



public class Main {
    
    public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
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
    

