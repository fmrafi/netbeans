package picL;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import picL.PaintPanel;


public class Painter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//JFrame application = new JFrame("A simple paint program");

		PaintPanel paintPanel = new PaintPanel(); // create paint panel
                
   
		//application.add(paintPanel, BorderLayout.CENTER); // in center
		/*application.add(new JLabel("Drag the mouse to draw"),
				BorderLayout.SOUTH);

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(400, 200); // set frame size
		application.setVisible(true); // display frame*/
	}

}
