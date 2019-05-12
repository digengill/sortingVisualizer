package digengill;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class sortVisual extends JPanel implements ActionListener {

	// graphics read starting at heights[1], RANGE = 0-19
	int heightsRatio[];
	JButton sort;
	int i;
	Color c = Color.blue;
	Timer t = new Timer(500,this);
	boolean isSorting = true;

	public sortVisual()
	{

	}
	public sortVisual(int arr[], int length)
	{
		i=0;
		heightsRatio = new int[length];
		
		for(int i=1;i < heightsRatio.length;i++)
		{
			heightsRatio[i] = arr[i];
			
			
		}
		ratioGenerator(heightsRatio);

		for(int i=0;i < heightsRatio.length;i++)
		{
			System.out.println(heightsRatio[i]);
			
		}
		
	}
	// Pre-condition: Arr of size 20;
	// Post-condition: Arr of ratios from 0-19
	public  void ratioGenerator(int arr[])
	{
		//find largest
		int largest = arr[1];
		for(int i=1; i<heightsRatio.length; i++)
		{
			if (arr[i] > largest)
			{
				largest = arr[i];
				
			}
			
			//System.out.print("largest = "+largest);
		}
		for(int i=1; i<heightsRatio.length; i++)
		{
			double hold =  (double)arr[i] / largest *19.0;
			//System.out.println("After: "+hold);
			arr[i] = (int) hold;
		//	System.out.println(arr[i]);

		}
		
		
		
	}
	  public void paintComponent(Graphics g) {
		super.paintComponent(g);
		 Graphics2D g2d = (Graphics2D) g;
		 Rectangle2D r2d = new Rectangle2D.Float(1.5f, 10f, 130f, 130f);
		createGrid(g);
		g.setColor(c);
		g2d.draw(r2d);
		
		for(int i=1; i<heightsRatio.length; i++)
		{
				
				g.fillRect(35*i+316, 25*(19-heightsRatio[i]+1)+1, 34, 25*heightsRatio[i]-1);
			
		}
		t.start();

	  }
	
	
	public void createGrid(Graphics g)
	{
		 Graphics2D g2d = (Graphics2D) g;
		    Rectangle2D r2d = new Rectangle2D.Double(35, 505, 35.5, 25);
		    g2d.draw(r2d);
		    g2d.fill(r2d);
		    
		for(int j=1; j< 20; j++)
		{
		for(int i =10; i<heightsRatio.length+9;i++)
		{
		//g.drawRect(20*i, 100,20, 50);
		g.drawRect(35*i,25*j,35,25);
		} 	
		}
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		System.out.println("Hello");
		
		
		                int n = heightsRatio.length; 
		                if (i < n && isSorting)
		                {
		                	
		                
		    	            int key = heightsRatio[i]; 
		    	            int j = i - 1;
		    	            
		    	            /* Move elements of heightsRatio[0..i-1], that are 
		    	               greater than key, to one position ahead 
		    	               of their current position */
		    	            while (j >= 0 && heightsRatio[j] > key) { 
		    	            	heightsRatio[j + 1] = heightsRatio[j]; 
		    	                j = j - 1; 
		    	                repaint();/**
		    	                try {
		    		    			Thread.sleep(50);
		    		    		} catch (InterruptedException e1) {
		    		    			// TODO Auto-generated catch block
		    		    			e1.printStackTrace();
		    		    		}
		    	                */
		    	            } 
		    	            heightsRatio[j + 1] = key; 
		    	            i++;
		                }
		                else if(i == n)
		                {
		                	//isSorting = false;
		                	t.stop();
		                }
 	            
 
		
		if (i %2 ==0)
		{
		c = Color.black;
		}
		else
		{
		c = Color.blue;
		}
		//repaint();
	}
		
	
	}



	
	
	

		
		
	