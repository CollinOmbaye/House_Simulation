
package housesimulation;
/**
 *  This turtle draws a simple flower on the display using a series of arcs.
 */

import java.awt.*;
import javax.swing.*;

/** 
  * @author Snilloc
 */
public class Flower extends JPanel {

  /** Display flower. */
  public static void main(String[] args) {
    JFrame frame = new JFrame("Flower");
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel flower = new Flower();
    flower.setBackground(Color.white);

    frame.add(flower);
    frame.setVisible(true);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);  // paint background

    Graphics2D g2 = (Graphics2D) g;

    // Draw the stem.
    g2.setStroke(
        new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    g2.setColor(new Color(0, 128, 0));  // green
    g2.drawLine(toScreenX(100), toScreenY(190), toScreenX(100), toScreenY(70));

    // Draw the center.
    g2.setColor(new Color(255, 165, 0));  // orange
    g2.fillOval(toScreenX(75), toScreenY(45), toScreenX(50), toScreenY(50));

    // Drawing petals at diiferent positions from the center.
    int petalWidth = toScreenX(20);
    int petalHeight = toScreenY(30);
    g2.setColor(new Color(255, 192, 203));  // pink
    g2.fillOval(toScreenX(90), toScreenY(35), petalWidth, petalHeight);
    g2.fillOval(toScreenX(90), toScreenY(85), petalWidth, petalHeight);
    g2.fillOval(toScreenX(64), toScreenY(60), petalWidth, petalHeight);
    g2.fillOval(toScreenX(115), toScreenY(60), petalWidth, petalHeight);
    g2.fillOval(toScreenX(108), toScreenY(78), petalWidth, petalHeight);
    g2.fillOval(toScreenX(108), toScreenY(42), petalWidth, petalHeight);
    g2.fillOval(toScreenX(72), toScreenY(78), petalWidth, petalHeight);
    g2.fillOval(toScreenX(72), toScreenY(42), petalWidth, petalHeight);
    
    
    
  }

  /** Converts an x-coordinate from a 200-width screen to the actual width. */
  private int toScreenX(int x) {
    return Math.round(x * getWidth() / 200f);
  }

  /** Converts an y-coordinate from a 200-width screen to the actual width. */
  private int toScreenY(int y) {
    return Math.round(y * getHeight() / 200f);
  }

}