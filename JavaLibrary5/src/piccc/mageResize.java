/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package piccc;

/**
 *
 * @author Morshed's
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.*;
import javax.swing.filechooser.*;
import java.io.*;
import javax.imageio.*;
import javax.imageio.stream.*;
import java.awt.geom.*;
import java.util.*;

class ImageArea extends Canvas implements ImageObserver{
BufferedImage img;
Dimension ds;
static String filename;
int w;
int h;
ImageArea(){
 ds=getToolkit().getScreenSize();
}
public void paint(Graphics g){
int x=-w/2;
int y=-h/2;
drawIt(g, (BufferedImage) img,x,y);
}
 public void setImageWidth(int width){
w=width;
}
 public void setImageHeight(int height){
h=height;
}
 public void drawIt(Graphics g, BufferedImage img,int x,int y){
Graphics2D g2d=(Graphics2D)g;
int mX=(int)ds.getWidth()/2;
int mY=(int)ds.getHeight()/2;
g2d.translate(mX,mY); //move the coordinate
g2d.drawImage(img,x,y,w,h,this); //draw the image
}
 public void setImageData(BufferedImage bi){
img=bi;
}
public void saveResizedImage(){
BufferedImage bi=(BufferedImage)createImage(w,h); //create empty BufferedImage object
Graphics2D g2d=(Graphics2D)bi.createGraphics(); //Create the Graphics2D object from theBufferedImage objectg2d.drawImage(img,0,0,w,h,this); //draw the current resized image on the BufferedImage object
try{
Calendar cd=Calendar.getInstance();
String resizedFileName=new String(cd.getTimeInMillis()+".jpg");
ImageIO.write(bi,"jpg",new File(resizedFileName)); //save the resized image file
}catch(IOException e){System.out.println("Error in saving the file...");}
}
}
 class Show extends JFrame implements ActionListener{
JPanel panel;
JButton btOK;
JTextField txtWidth;
JTextField txtHeight;
ImageArea ia;
BufferedImage bi;
Show(){
setTitle("Image resize");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
JMenuBar mainmenu=new JMenuBar();
JMenu menu=new JMenu("File");
JMenuItem mopen=new JMenuItem("Open...");
mopen.setMnemonic(KeyEvent.VK_O);
mopen.addActionListener(this);
JMenuItem mexit=new JMenuItem("Exit");
mexit.setMnemonic(KeyEvent.VK_X);
mexit.addActionListener(this);
menu.add(mopen);
menu.add(mexit);
mainmenu.add(menu);
setJMenuBar(mainmenu);
ia=new ImageArea();
add(ia,BorderLayout.CENTER );
btOK=new JButton("OK");
btOK.setBackground(Color.BLACK);
btOK.setForeground(Color.BLUE);
btOK.setToolTipText("Save the resized image file");
btOK.addActionListener(this);
txtWidth=new JTextField(4);
txtWidth.addKeyListener(new KeyList());
txtHeight=new JTextField(4);
txtHeight.addKeyListener(new KeyList());
panel=new JPanel();
panel.setLayout(new FlowLayout());
panel.add(new JLabel("Width:"));
panel.add(txtWidth);
panel.add(new JLabel("Height:"));
panel.add(txtHeight);
panel.add(btOK);
panel.setBackground(Color.GRAY);
add(panel, BorderLayout.SOUTH);
setVisible(true);
activateControls(false);
}
 public void actionPerformed(ActionEvent e){
if(e.getSource()==btOK)
{
ia.saveResizedImage();
}
else {
JMenuItem source = (JMenuItem)(e.getSource());
if(source.getText().compareTo("Open...")==0)
{
setImage();
if(bi!=null){
txtWidth.setText(bi.getWidth()+"");
txtHeight.setText(bi.getHeight()+"");
activateControls(true);
ia.repaint();
validate();//make sure the components display correctly
}
}
else if(source.getText().compareTo("Exit")==0)
System.exit(0);
}
}
 public void activateControls(boolean f){
txtWidth.setEnabled(f);
txtHeight.setEnabled(f);
btOK.setEnabled(f);
}
 public class KeyList extends KeyAdapter{
public void keyTyped(KeyEvent ke){
char c = ke.getKeyChar(); //get the character pressed
int intkey=(int)c; //the character code
if(!(intkey>=48 && intkey<=57 || intkey==8 || intkey==127))
{
ke.consume(); //hide the key
}
}
public void keyReleased(KeyEvent e){
//the image resizes when the key released
if(!txtWidth.getText().equals("") && !txtHeight.getText().equals("")){
ia.setImageWidth(Integer.parseInt(txtWidth.getText()));
ia.setImageHeight(Integer.parseInt(txtHeight.getText()));
ia.repaint();
}
}
}
 public void setImage(){
JFileChooser chooser = new JFileChooser(); //create file chooser object
FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "gif","bmp","png");
//create filter object
chooser.setFileFilter(filter); //apply the file filter to the file chooser object
chooser.setMultiSelectionEnabled(false); //only one file is selected at once
int returnVal = chooser.showOpenDialog(this); //show the file chooser dialog
if(returnVal == JFileChooser.APPROVE_OPTION) {
String filename=chooser.getSelectedFile().toString(); //get selected file path
prepareImage(filename); //invoke the prepareImage method to send image width, height, and data to the ShowArea class
}
}
 public void prepareImage(String filename){
try{
bi=ImageIO.read(new File(filename)); //read the image data
ia.setImageData(bi); //send the image data to the ShowArea class
ia.setImageWidth(bi.getWidth()); //send the image width to the ShowArea class
ia.setImageHeight(bi.getHeight());//send the image height to the ShowArea class
}
catch(IOException e){System.out.println("Problem to load the image file...");}
catch(NullPointerException e){System.out.println("You may select invalid image file...");}
}
}
public class mageResize{
public static void main(String args[]){
new Show();
}
}