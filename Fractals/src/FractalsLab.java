/**
 * Name:
 * Section: 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FractalsLab extends JApplet implements ActionListener, ChangeListener
{
	Timer t;
	int x = 0;
	int y = 0;
	int ox = 1;
	int oy= 3;
	JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL, 0, 90, 0);
	
	public static void main(String[] arg){
		FractalsLab l = new FractalsLab();
	}
	
	public FractalsLab(){
		t = new Timer(1000,this);
		//t.start();
	}
	int r, gr, b;
	boolean one = false;
	
	
	public void paint(Graphics g)
	{
		super.paint(g);
		this.setSize(1000, 1000); //canvas width and height
		 Graphics2D g2 = (Graphics2D) g;

		circular(g, 100,100, 0);
		//rings(g, 400, 0, 300);
		
		
		
		//rings(g, 400, 400, y);
		//rings(g, 400, 200, 100);
		//rings(g, 400, x, 200);
		//rings(g, 400, 400, 200);
		
	}
	
	int bf = (int) ((200-10)/(2*Math.PI*100));
	int deg;
	public void spiral(Graphics g, int rad, int deg){
		
	
	}
	
	
	public void rings(Graphics g, int radius, int x, int y){
		g.drawOval(x,y,radius,radius);
		
		if(radius > 10){
			//call method to draw
			//g.setColor(new Color(255, 0 ,125 ));
			if(x < 400 && y < 400) rings(g, radius - 1, x + 12, y - 12);
			if(x >= 400 && y < 400) rings(g, radius - 1, x + 12, y + 12);
			if(x >= 400 && y >= 400) rings(g, radius - 1, x - 12, y + 12);
			if(x < 400 && y >= 400) rings(g, radius - 1, x - 12, y - 12);
			
		}
	
	}
	
	public void tree(Graphics g, int x1, int y1, int x2, int y2){
		g.drawLine(x1, y1, x2, y2);
	}
	
	public void circular(Graphics g, int x, int y, int d){
		//g.drawOval((int)(Math.cos(d)+100), (int)(Math.sin(d)+100), 100, 100);
		if(d>0){
			circular( g, x, y, d-2);
		}
	}
	
	
	


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		x+=ox;
		y+=oy;
		if(x>600 || x<=0){
			x = 0;
			ox *=-1;
		}
		if(y>600||y<=0){
			y = 0;
			oy *= -1;
		}

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("here");
	}
	
}


