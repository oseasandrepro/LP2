import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Hello2DApp 
{
    public static void main (String[] args) 
    {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame 
{
    public Hello2DFrame () 
    {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        
        this.setTitle("Java2D - Hello World!");
        this.setSize(800, 400);
        this.getContentPane().setBackground( new Color(51,153,255));
       
        this.setVisible(true);
        
    }

    public void paint (Graphics g) 
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setPaint(Color.black);
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
        
        //desenhar um circulo
        Ellipse2D circ = new Ellipse2D.Double(w-200, 100, 100, 100);
        g2d.setPaint(Color.YELLOW);
        g2d.fill( circ );
        
        //desenhar um rectangulo
        Rectangle2D rect = new Rectangle2D.Double(0, h-100, w, 100);
        g2d.setPaint(new Color(0, 153, 0) );
        g2d.fill(rect);
        
        /** Desenhar uma casinha **/
        Rectangle2D rect1 = new Rectangle2D.Double(200, h-300, 300, 200);
        g2d.setPaint(new Color(102, 51,0) );
        g2d.fill(rect1);
        
        
       	Rectangle2D rect2 = new Rectangle2D.Double(341, h-150, 40, 50);
        g2d.setPaint(new Color(153, 102, 0) );
        g2d.fill(rect2);
       
        
    }
    
    
}
