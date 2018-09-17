
package housesimulation;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Snilloc
 */
public class Housesimulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame=new JFrame("House Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850,550);
        House house=new House();
        
        JPanel flower = new Flower();
        flower.setBackground(Color.white);
        frame.add(flower);
        frame.add(house);
        frame.setVisible(true);
                
        
    }
    
}
