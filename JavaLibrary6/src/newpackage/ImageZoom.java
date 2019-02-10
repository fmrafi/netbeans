/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Morshed's
 */
import java.awt.*;
import java . io . File ;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;

class ImgArea extends Canvas{
Image orImg;
BufferedImage orBufferedImage;
BufferedImage bimg;
BufferedImage bimg1;
float e;
float radian;
Dimension ds;
int mX;
int mY;
int x;
int y;
static boolean imageLoaded;
boolean actionSlided;
boolean actionResized;
boolean actionCompressed;
boolean actionTransparent;
boolean actionRotated;
boolean actionDraw;
boolean drawn;
MediaTracker mt;
static Color c;
Color colorTextDraw;
Robot rb;
boolean dirHor;
String imgFileName;
String fontName;
int fontSize;
String textToDraw;





class Zoom extends Canvas implements ImageObserver{
Image img;
int iw;
int ih;
int x;
int y;
int adjX=0;
int adjY=0;
int adjW=0;
int adjH=0;
Dimension ds;
Zoom(){

 ds=getToolkit().getScreenSize();
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
}
 class MainInter extends JFrame implements ActionListener{
JButton btZoomIn;
JButton btZoomOut;
JPanel panel;
Zoom z;
MainInter(){
setTitle("Image zoom");
z=new Zoom();
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
}
}
//public class ImageZoom{

        
   //public class ImageZoom{
public static void main(String args[]){
    class Mainn extends JFrame implements ActionListener{
ImgArea ia;
JFileChooser chooser;
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
Mainn(){
ia=new ImgArea();
Container cont=getContentPane();
cont.add(ia,BorderLayout.CENTER );
mainmenu=new JMenuBar();
menu=new JMenu("File");
menu.setMnemonic(KeyEvent.VK_F);
mopen=new JMenuItem("Open...");
mopen.setMnemonic(KeyEvent.VK_O);
mopen.addActionListener(this);
msaveas=new JMenuItem("Save as...");
msaveas.setMnemonic(KeyEvent.VK_S);
msaveas.addActionListener(this);
msave=new JMenuItem("Save");
msave.setMnemonic(KeyEvent.VK_V);
msave.addActionListener(this);
mexit=new JMenuItem("Exit");
mexit.setMnemonic(KeyEvent.VK_X);
mexit.addActionListener(this);
menu.add(mopen);
menu.add(msaveas);
menu.add(msave);
menu.add(mexit);
editmenu=new JMenu("Edit");
editmenu.setMnemonic(KeyEvent.VK_E);
mbright=new JMenuItem("Image brightness");
mbright.setMnemonic(KeyEvent.VK_B);
mbright.addActionListener(this);
maddtext=new JMenuItem("Add text on image");
maddtext.setMnemonic(KeyEvent.VK_A);
maddtext.addActionListener(this);
mresize=new JMenuItem("Image resize");
mresize.setMnemonic(KeyEvent.VK_R);
mresize.addActionListener(this);
mcompress=new JMenuItem("Image compression");
mcompress.setMnemonic(KeyEvent.VK_P);
mcompress.addActionListener(this);
mrotate=new JMenuItem("Image rotation");
mrotate.setMnemonic(KeyEvent.VK_T);
mrotate.addActionListener(this);
mtransparent=new JMenuItem("Image transparency");
mtransparent.setMnemonic(KeyEvent.VK_T);
mtransparent.addActionListener(this);
mcancel=new JMenuItem("Cancel editing");
mcancel.setMnemonic(KeyEvent.VK_L);
mcancel.addActionListener(this);
editmenu.add(maddtext);
editmenu.add(mbright);
editmenu.add(mcompress);
editmenu.add(mresize);
editmenu.add(mrotate);
editmenu.add(mtransparent);
editmenu.add(mcancel);
mainmenu.add(menu);
mainmenu.add(editmenu);
setJMenuBar(mainmenu);
setTitle("Image Editor");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
setVisible(true);
chooser = new JFileChooser();
FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "gif","bmp","png");
chooser.setFileFilter(filter);
chooser.setMultiSelectionEnabled(false);
enableSaving(false);
ia.requestFocus();
}

        private void enableSaving(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }


}
}
    
    
    
//new MainInter();

