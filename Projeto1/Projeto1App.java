import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class Projeto1App
{
	public static void main(String[] args)
	{
		ListFrame frame = new ListFrame();
		frame.setVisible(true);
	}	
}

class ListFrame extends JFrame
{
	int defaultH = 80;
	int defaultW = 80;
	
	int windowH = 500;
	int windowW = 500;
	
	ArrayList<Figure> fg = new ArrayList<Figure>();
	Random rand = new Random();
	
	ListFrame() 
	{
		
		this.addWindowListener (
		    new WindowAdapter() 
		    {
		        public void windowClosing (WindowEvent e) {
		            System.exit(0);
		        }
		    }
		);
		
		this.addKeyListener(
			new KeyAdapter() {
				public void keyPressed(KeyEvent evt)
				{
				int x = rand.nextInt(windowW);
				int y = rand.nextInt(windowH);
				int w = defaultH;
				int h = defaultW;
				if( evt.getKeyChar() == 'r')
				{ 
					fg.add( new Rect(x, y, w, h, Color.BLACK, Color.WHITE) );
					repaint();
				}
				else if( evt.getKeyChar() == 'e')
				{
					fg.add( new Ellipse(x, y, w, h, Color.BLACK, Color.WHITE) );
					repaint();
				}
				else if( evt.getKeyChar() == 't' )
				{
					fg.add(new Triangle(x, y, w, h, Color.BLACK, Color.WHITE) );
					repaint();
				}else if( evt.getKeyChar() == 'w')
				{
					fg.add( new Roundrect(x, y, w, h, Color.BLACK, Color.WHITE) );
					repaint();
				}
			}
		}
			
		);
		this.getContentPane().setBackground(Color.WHITE);
		this.setTitle("Projeto1App");
        	this.setSize(500, 500);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		for( Figure fig: this.fg){
			fig.paint(g);
		}
	}
}
