package figures;
import java.awt.*;

public class Rect extends Figure 
{
    int x, y;
    int w, h;
    Color BorderColor;
    Color BckgColor;

    public Rect (int x, int y, int w, int h, Color BorderColor, Color BckgColor) 
    {
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

    public void paint (Graphics g) 
    {
        Graphics2D g2d = (Graphics2D) g;
        
        //consertar/ajustar bordas
        BasicStroke bs1 = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER);
	g2d.setStroke(bs1);
        
        g2d.setColor( this.BorderColor);
        g2d.drawRect(this.x,this.y, this.w,this.h);
        
        g2d.setColor(this.BckgColor);
        g2d.fillRect(this.x, this.y, this.w, this.h);
        
    }
}
