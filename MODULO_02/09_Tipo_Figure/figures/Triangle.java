package figures;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.BasicStroke;

public class Triangle extends Figure
{
	int x, y;
	int w, h;
	Color BorderColor;
	Color BckgColor;
	
	public Triangle(int x,int y, int w,int h, Color BorderColor, Color BckgColor)
	{
		this.x = x; 
		this.y = y;
		this.w = w;
		this.h = h;
		this.BorderColor = BorderColor;
		this.BckgColor = BckgColor;
	}
	
	public void paint (Graphics g) 
	{
		Graphics2D g2d = (Graphics2D)g;
		
		//consertar/ajustar bordas
		BasicStroke bs1 = new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs1);
		
		int x[] = {this.x, this.x-w, this.x+w};
		int y[] = {this.y, this.y+w, this.y+w};
		
		g2d.setColor(this.BorderColor);
		g2d.drawPolygon(x,y,3);
		
		g2d.setColor(this.BckgColor);
		g2d.fillPolygon(x,y,3);
        }
}
