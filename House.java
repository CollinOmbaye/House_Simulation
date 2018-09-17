
package housesimulation;

import java.awt.*;
import java.awt.Graphics;
import static java.lang.Integer.parseInt;
import javax.swing.JPanel;

/**
 *1
 * @author Snilloc
 */

public class House extends JPanel {
    //draw the shapes
    int width=0;
    int height=0;
    
    //base colors
    int base1=0;
    int base2=0;
    int base3=0;
    
    //
//    roof color
    int roof1=0;
    int roof2=0;
    int roof3=0;
    
    int flower1=0;
    int flower2=0;
    int flower3=0;
    
    String basesh="";
    String roof="";
    String flowersh="";
//generating an a random  heighst and widths
  public void lengthWidth(){
      int max=200;
      int min=50;
      int length=0;
      boolean check=true;
      for(;check;){
          length=(int)(Math.random()*1000);
          if(length>=min && length<=max){
              check=false;
          }
      }
      width=length;
      height=length*(5/2);
      
       
  }
  
  //method to generate color in rgba
  public Color rrandomColor(String type){

        int R = (int)(Math.random()*256);
        int G = (int)(Math.random()*256);
        int B= (int)(Math.random()*256);
        Color newcolor = new Color(R, G, B);
      
      
      
      return newcolor;
  }
  
  //method to generate random color
  public Color randomColor(String type){

      int R = (int)(Math.random()*256);
      int G = (int)(Math.random()*256);
      int B= (int)(Math.random()*256);
      
      Color color = new Color(R, G, B);
      if(type.equals("flowers")){
          flower1=R;
          flower2=G;
          flower3=B;
      }
      
      if(type.equals("base")){
          base1=R;
          base2=G;
          base3=B;
      }
      if(type.equals("triangle")){
          roof1=R;
          roof2=G;
          roof3=B;
      }
      
      return color;
      
  }
 
  
  //method to do the drawing
  public void paintComponent(Graphics paint){
    super.paintComponent(paint);
    this.setBackground(Color.WHITE);
    //run lenghtwidth
    lengthWidth();
    Color base=randomColor("base");
    paint.setColor(base);
    paint.fillRect(200,200,height,width);
    
    //draw the roof
    paint.setColor(randomColor("triangle"));
     int x[]={200,200+height,200+height/2};
     int y[]={200,200,150-(width/2)};
     Polygon p=new Polygon(x,y,3);
     
  
   paint.fillPolygon(p);
    
   
   //write text
   paint.setColor(Color.red);
   
   paint.drawString("Length:"+height,40,10);
   paint.drawString("Hieght:"+width,40,25);
   paint.drawString("base color : rgb("+base1+","+base2+","+base3+")",40,40);
   paint.drawString("Roof color : rgb("+roof1+","+roof2+","+roof3+")",40,55);
    paint.drawString("Flower color :  rgb("+flower1+","+flower2+","+flower3+")",40,70);
   
   
   
   //flowers
   
   
   
    Color petal=randomColor("flowers");
      
  
    //loop to draw more flowers
    for(int space=0;space<=400;){
        
        
         Graphics2D g2 = (Graphics2D) paint;

    // Draw the stem.
    g2.setStroke(
        new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    g2.setColor(new Color(0, 128, 0));  // green
    g2.drawLine(toScreenX(100+space), toScreenY(400), toScreenX(100+space), toScreenY(350));

    // Draw the center.
    g2.setColor(new Color(255, 165, 0));  // orange
    g2.fillOval(toScreenX(85+space), toScreenY(340), toScreenX(30), toScreenY(30));

    // Draw eight petals at N, NE, E, SE, S, SW, W, NW positions on the center.
    int petalWidth = toScreenX(20);
    int petalHeight = toScreenY(20);
    g2.setColor(petal);  // pink
    
    
    g2.fillOval(toScreenX(90+space), toScreenY(320), petalWidth, petalHeight);
    g2.fillOval(toScreenX(90+space), toScreenY(370), petalWidth, petalHeight);
    g2.fillOval(toScreenX(64+space), toScreenY(350), petalWidth, petalHeight);
    g2.fillOval(toScreenX(115+space), toScreenY(350), petalWidth, petalHeight);
    g2.fillOval(toScreenX(108+space), toScreenY(368), petalWidth, petalHeight);
    g2.fillOval(toScreenX(108+space), toScreenY(332), petalWidth, petalHeight);
    g2.fillOval(toScreenX(72+space), toScreenY(368), petalWidth, petalHeight);
    g2.fillOval(toScreenX(72+space), toScreenY(332), petalWidth, petalHeight);
    
    space+=100;
        
    }
   
  }
  /** Converts an x-coordinate from a 200-width screen to the actual width. */
  private int toScreenX(int x) {
//    return Math.round(x * getWidth() / 200f);
      return x;
  }

  /** Converts an y-coordinate from a 200-width screen to the actual width. */
  private int toScreenY(int y) {
//    return Math.round(y * getHeight() / 200f);
      return y;
  }
  
    
}
