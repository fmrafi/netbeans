/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pic;

/**
 *
 * @author Morshed's
 */
import java.awt.*;
	import javax.swing.*;

	import java.awt.event.*;

	import javax.imageio.ImageIO;

	import java.io.File;

	import java.io.IOException;

	import java.net.URL;

	import java.awt.Color;

	import javax.swing.JLabel;

	import javax.swing.ImageIcon;

	import java.awt.image.BufferedImage;

	 

	 

	 
public class pic1 extends JComponent implements ActionListener

	{

	    public BufferedImage picture1;

	    public JFrame frame;

	    public String filename;

	     

	    //create the buttons

	    JButton button1 = new JButton("Black & White");

	    JButton button2 = new JButton("Brighter");

	    JButton button3 = new JButton("Darker");

	    JButton button4 = new JButton("Negative");

	     

	     

	 
	public int length, height;

	public Color[][] picArray;
    private int i;

  public pic1(int length, int height) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public pic1(int w, int h)

	    {  

	    picture1 = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);

	    filename = w + "-by-" + h;

	    } 
     

	//get the picture from the class file

	    public pic1(String filename) {

	        this.filename = filename;

	        try {

	            // try to read from file in working directory

	            File file = new File(filename);

	            if (file.isFile()) {

	                picture1 = ImageIO.read(file);

}

	            // now try to read from file in same directory as this .class file

	            else {

	                URL url = getClass().getResource(filename);

	                if (url == null) { url = new URL(filename); }

	                picture1 = ImageIO.read(url);

	            }

	        }

	        catch (IOException e) {

	            // e.printStackTrace();

	            throw new RuntimeException("Could not open file: " + filename);

	        }

	 

	        // check that image was read in

	        if (picture1 == null) {

	            throw new RuntimeException("Invalid image file: " + filename);

	        }

	    }

	 

	     

	    //create the picture by reading it from the file

	   

	    public pic1(File file) {

	        try { picture1 = ImageIO.read(file); }

	        catch (IOException e) {

	            e.printStackTrace();

	            throw new RuntimeException("Could not open file: " + file);

	        }

	        if (picture1 == null) {

	            throw new RuntimeException("Invalid image file: " + file);

	        }

	    }

	 

	 

	     

	//put the picture in a label

	public JLabel getJLabel()

	{

	    if(picture1 == null)

	    {

	        return null;

	    }

	    ImageIcon icon = new ImageIcon(picture1);

	     

	    return new JLabel(icon);

	}

	 

	 

	 

	public void show()

	    {

	     

	    if(frame==null){

	        frame = new JFrame();

	     

	    JPanel area = new JPanel();

	    area.setLayout(new GridLayout(0,1));

	    area.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));

	     

	    area.add(button1);

	    area.add(button2);

	    area.add(button3);
    area.add(button4);

	 

	    button1.addActionListener(this);

	    button2.addActionListener(this);

	    button3.addActionListener(this);

	    button4.addActionListener(this);

	     

	     

	    frame.add(area, BorderLayout.EAST);

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    frame.setTitle("Picture Editor");

	    frame.setVisible(true);

	    frame.pack();

	    frame.add(getJLabel(), BorderLayout.CENTER);

	     

	     

	    }else

	     

	    {

	     

	    frame.repaint();

	    }

	     

	 

	    }

	 

	 

	//2. Extract the pixels into an array

	 

	 

	public int height()

	    {

	    return picture1.getHeight();

	    }

	 

	public int length()

	    {

	    return picture1.getWidth();

	    }

	 

	public Color get(int i, int j)

	    {

	    return new Color(picture1.getRGB(i,j));

	    }

	public void set(int i, int j, Color c)

	    {

	    if (c == null) { throw new RuntimeException("can't set Color to null"); }

	    picture1.setRGB(i,j,c.getRGB());

	    }

	     

	     

	     

	    // function that turns the picture into a black & white picture

	    public void blackwhite()

	    {

	        pic1 p2 = new pic1(length,height);


	        {

	            for(int j=0; j<height; j++)

	            {

	                Color c = picArray[i][j];
	                int r = c.getRed();

	                int g = c.getGreen();

	                int b = c.getBlue();

	                 

	                int black = (int)(.3*r + .59*g + .11*b);

	                Color bl = new Color(black, black, black);

	                p2.set(i, j, bl);

	            }

	        }

	        p2.show();

	    }

	     

	 

	     

	     

	    // function that makes the picture brighter
	    public void brighter()

	    {

	        pic1 p2 = new pic1(length,height);

	        for(int i = 0; i<length; i++)

	        {

	            for(int j = 0; j<height; j++)

	            {

	                Color c = picArray[i][j];

	                int r = c.getRed();

	                int g = c.getGreen();

	                int b = c.getBlue();

	                 

	                int brighterRed = (int)(Math.sqrt((r/255))*255);

	                int brighterGreen = (int)(Math.sqrt((g/255))*255);

	                int brighterBlue = (int)(Math.sqrt((b/255))*255);

	                 

	                Color bright = new Color(brighterRed, brighterGreen, brighterBlue);

	                p2.set(i, j, bright);

	                 

	                 

	            }

	        }

	        p2.show();

	    }

	     

	    //function that makes the picture darker   

	    public void darker()

	    {

	        for(int i = 0; i<length; i++)

	        {

	            for(int j = 0; j<height; j++)

	            {

	                 

	                Color c = picArray[i][j];

	                int r = c.getRed();

	                int g = c.getGreen();

	                int b = c.getBlue();


	                //now add the code to darken the pixels

	                 

	                 

	            }

	        }

	    }

	 

	     

	    //function that turns the picture into the negative

	    //ALSO BELOW IS HOW I ORIGINALLY DID IT

	    public void negative()

	    {

	        for(int i=0; i<length; i++)

	        {

	            for(int j=0; j<height; j++)

	            {

	                Color c = picArray[i][j];

	                int r = c.getRed();

	                int g = c.getGreen();

	                int b = c.getBlue();

	                 

	                int negR = 255 - r;

	                int negG = 255 - g;

	                int negB = 255 - b;

	                 

	                Color NegColor = new Color(negR, negG, negB);

	                picArray[i][j] = NegColor;

	                 

	                 

	            }

	        }

	    }

	     

	     

	     

	    //from page 553 in Java for Dummies

	    public void actionPerformed(ActionEvent pushed)

	    {

	        if(pushed.getSource() == button1)

	        {

	            blackwhite();

	            frame.repaint();

	        }

	         

	        if(pushed.getSource() == button2)

	        {

	            brighter();

	            frame.repaint();

	        }

	         

	        if(pushed.getSource() == button3)

	        {

	            darker();

	            frame.repaint();   

	        }

	         

	        if(pushed.getSource() == button4)

	        {

	            negative();

	            frame.repaint();

	        }

	    }

	     

	     

	     

	    //main argument

	    public static void main(String[] args)

	    {

	         

	        pic1 pic = new pic1(args[0]);

	        pic.show();

	         

	         

	    }

	     

	     

	}