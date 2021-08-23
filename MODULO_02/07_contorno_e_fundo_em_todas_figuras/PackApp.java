import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackApp
{
	public static void main(String[] args)
	{
		PackFrame frame = new PackFrame();
		frame.setVisible(true);
	}	
}

class PackFrame extends JFrame
{
	Rect r1;
	Ellipse e1;
	Triangle t1;
	
	PackFrame() 
	{
		this.addWindowListener (
		    new WindowAdapter() {
		        public void windowClosing (WindowEvent e) {
		            System.exit(0);
		        }
		    }
		);
		
		this.setTitle("Java Packages");
		this.setSize(350, 350);
		this.r1 = new Rect(100, 50, 50, 50, Color.BLACK,Color.ORANGE);
		this.e1 = new Ellipse(100,120, 50,50, Color.BLACK,Color.GRAY);
		this.t1 = new Triangle(125,200, 50,50, Color.BLACK,Color.GREEN);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		this.r1.paint(g);
		this.e1.paint(g);
		this.t1.paint(g);
	}
}
