package digengill;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameControl extends sortVisual implements ActionListener {
	
	public FrameControl(int arr[])
	{
		super(arr,arr.length);
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(2000, 1000);
		frame.add(new sortVisual(arr,arr.length),BorderLayout.CENTER);
		
		sort = new JButton("Sort");
		sort.addActionListener(this);
		
		frame.add(sort,BorderLayout.SOUTH);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {0,100, 54, 65, 34 ,23 ,23 ,43 ,43, 32, 21, 43 ,23, 54 ,65, 54 ,43,32,23,54 ,55,15
				,10,10,10,10,10,10};
		
		FrameControl test = new FrameControl(arr);
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		Object source = e.getSource(); 	                
		if (source == sort)
		{
			  isSorting = true;
			  System.out.println("SORT"+isSorting);

		}
		
		
	}

}
