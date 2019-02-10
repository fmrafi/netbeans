/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package picL;

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
import static javax.swing.JFrame.EXIT_ON_CLOSE;


class Zoom22 extends Canvas implements ImageObserver{
Image img;
  BufferedImage imgg;
  
  
JFileChooser chooser;

int iw;
int ih;
int x;
int y;
int adjX=0;
int adjY=0;
int adjW=0;
int adjH=0;
Dimension ds;

ImgArea ia;
JMenuBar mainmenu;
JMenu menu;
JMenu editmenu;
JMenuItem mopen;
JMenuItem msaveas;
JMenuItem msave;
JMenuItem mexit;
JMenuItem mbright;
JMenuItem mcompress;
JMenuItem mresize;
JMenuItem mrotate;
JMenuItem mtransparent;
JMenuItem maddtext;
JMenuItem mcancel;
String filename;








Zoom22(){
    
    
    
     //img=getToolkit().getImage("image03.jpg");
//imgg=(BufferedImage) getToolkit().getImage(BufferedImage);
 ds=getToolkit().getScreenSize();
 
Zoom22 ia;
 ia=new Zoom22();
//Container cont=getContentPane();
//cont.add(ia,BorderLayout.CENTER );
mainmenu=new JMenuBar();
menu=new JMenu("File");
menu.setMnemonic(KeyEvent.VK_F);
mopen=new JMenuItem("Open...");
mopen.setMnemonic(KeyEvent.VK_O);
mopen.addActionListener((ActionListener) this);
msaveas=new JMenuItem("Save as...");
msaveas.setMnemonic(KeyEvent.VK_S);
msaveas.addActionListener((ActionListener) this);
msave=new JMenuItem("Save");
msave.setMnemonic(KeyEvent.VK_V);
msave.addActionListener((ActionListener) this);
mexit=new JMenuItem("Exit");
mexit.setMnemonic(KeyEvent.VK_X);
mexit.addActionListener((ActionListener) this);
menu.add(mopen);
menu.add(msaveas);
menu.add(msave);
menu.add(mexit);
 
 
//setDefaultCloseOperation(EXIT_ON_CLOSE);
//setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
setVisible(true);
chooser = new JFileChooser();
FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "gif","bmp","png");
chooser.setFileFilter(filter);
chooser.setMultiSelectionEnabled(false);
//enableSaving(false);
ia.requestFocus();
 
 
 
 
 
}
public void paint(Graphics g){
 Graphics2D g2d=(Graphics2D)g;
 setImageBounds();
 g2d.translate(x,y);
 g2d.drawImage(img,0,0,iw,ih,this);
}
 public void setImageBounds(){
x=(int)ds.getWidth()/2-img.getWidth(this)/2+adjX;
y=(int)ds.getHeight()/2-img.getHeight(this)/2+adjY;
iw=img.getWidth(this)+adjW;
ih=img.getHeight(this)+adjH;
}
 public void zoomIn(){
adjX-=10;
adjY-=10;
adjW+=20;
adjH+=20;
}
 public void zoomOut(){
if(x<(int)ds.getWidth()/2-img.getWidth(this)/2){
adjX+=10;
adjY+=10;
adjW-=20;
adjH-=20;

}
}
 class MainInterrr extends JFrame implements ActionListener{
JButton btZoomIn;
JButton btZoomOut;
JPanel panel;
Zoom22 z;
MainInterrr(){
setTitle("Image zoom");
z=new Zoom22();
btZoomIn=new JButton("+");
btZoomIn.addActionListener(this);
btZoomOut=new JButton("-");
btZoomOut.addActionListener(this);
btZoomOut.setOpaque(false);
add(z,BorderLayout.CENTER );
panel=new JPanel();
panel.setLayout(new FlowLayout());
panel.add(btZoomIn);
panel.add(btZoomOut);
add(panel, BorderLayout.SOUTH);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
setVisible(true);
}
public void actionPerformed(ActionEvent e){


JMenuItem source = (JMenuItem)(e.getSource());
if(source.getText().compareTo("Open...")==0)
{
setImage();
ia.repaint();
validate();
}
else if(source.getText().compareTo("Save as...")==0)
{
showSaveFileDialog();
}
else if(source.getText().compareTo("Save")==0)
{
ia.saveToFile(filename);
}

if(e.getSource()==btZoomIn)
{
z.zoomIn();
z.repaint();
}
else if(e.getSource()==btZoomOut)
{
z.zoomOut();
z.repaint();
}



else if(source.getText().compareTo("Cancel editing")==0) {
ia.setImgFileName(filename);
ia.reset();
}
else if(source.getText().compareTo("Exit")==0)
System.exit(0);


}



public void setImage(){
int returnVal = chooser.showOpenDialog(this);
if(returnVal == JFileChooser.APPROVE_OPTION) {
filename=chooser.getSelectedFile().toString();
ia.prepareImage(filename);
}
}
public void showSaveFileDialog(){
int returnVal = chooser.showSaveDialog(this);
if(returnVal == JFileChooser.APPROVE_OPTION) {
String filen=chooser.getSelectedFile().toString();
ia.saveToFile(filen);
}
}
//The enableSaving method defines code to enable or disable saving sub-menu items
public void enableSaving(boolean f){
msaveas.setEnabled(f);
msave.setEnabled(f);
}








 }}

public class Zoom{
public static void main(String args[]){
    


    
}}
