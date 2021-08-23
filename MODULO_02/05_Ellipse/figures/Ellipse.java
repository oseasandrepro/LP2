package figures;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.BasicStroke;

public class Ellipse 
{
    int x, y;
    int w, h;
    Color BorderColor;
    Color BckgColor;

    public Ellipse (int x, int y, int w, int h, Color BorderColor, Color BckgColor)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.BorderColor = BorderColor;
        this.BckgColor = BckgColor;
    }

    public void print()
    {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) 
    {
        Graphics2D g2d = (Graphics2D)g;
        
        //consertar/ajustar bordas
        BasicStroke bs1 = new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
	g2d.setStroke(bs1);
	
	g2d.setColor(this.BorderColor);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setColor(this.BckgColor);
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w,this.h));
    }
}
