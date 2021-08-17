import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BasicStroke;

class PaintApp 
{
    public static void main (String[] args) 
    {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame 
{
    Rect r1, r2, r3;

    PaintFrame() {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
         this.getContentPane().setBackground( Color.WHITE );
        
        this.r1 = new Rect(50, 70, 100, 100, Color.YELLOW, Color.BLUE);
        this.r2 = new Rect(160, 180, 100, 100, Color.RED, Color.GREEN);
        this.r3 = new Rect(270, 290, 100, 100, Color.BLUE, Color.RED);
    }

    public void paint (Graphics g) 
    {
        super.paint(g);
        
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect 
{
    int x, y;
    int w, h;
    Color BorderColor;
    Color BckgColor;

    Rect (int x, int y, int w, int h, Color BorderColor, Color BckgColor) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.BorderColor = BorderColor;
        this.BckgColor = BckgColor;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) 
    {
        Graphics2D g2d = (Graphics2D) g;
        
        //consertar/ajustar bordas
        BasicStroke bs1 = new BasicStroke(8, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER);
	g2d.setStroke(bs1);
        
        g2d.setColor( this.BorderColor);
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(this.BckgColor);
        g2d.fillRect(this.x, this.y, this.w, this.h);
    }
}
