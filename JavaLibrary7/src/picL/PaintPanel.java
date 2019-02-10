package picL;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PaintPanel extends JFrame {

	private int pointCount = 0; // count number of points
	private Point[] points = new Point[10000];

	// set up GUI and register mouse event handler
	public PaintPanel() {
		// handle frame mouse motion event
		addMouseMotionListener(new MouseMotionAdapter() {

			// store drag coordinates and repaint
			public void mouseDragged(MouseEvent event) {
				if (pointCount < points.length) {
					points[pointCount] = event.getPoint(); // find point
					++pointCount; // increment number of points in array
					repaint(); // repaint JFrame
				} // end if
			} // end method mouseDragged
		});

                 
                JFrame application = new JFrame("A simple paint program");

		//PaintPanel paintPanel = new PaintPanel(); // create paint panel
		//application.add(paintPanel, BorderLayout.CENTER); // in center
		application.add(new JLabel("Drag the mouse to draw"),
				BorderLayout.SOUTH);

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(400, 200); // set frame size
		application.setVisible(true); // display frame
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g); // clears drawing area

		// draw all points in array
		for (int i = 0; i < pointCount; i++)
			g.fillOval(points[i].x, points[i].y, 4, 4);
               
}
                
	} // end method paintComponent

