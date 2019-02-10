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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
class Zoomm extends Canvas implements ImageObserver{
Image img;
  BufferedImage imgg;

int iw;
int ih;
int x;
int y;
int adjX=0;
int adjY=0;
int adjW=0;
int adjH=0;
Dimension ds;
Zoomm(){
     //img=getToolkit().getImage("image03.jpg");
//imgg=(BufferedImage) getToolkit().getImage(BufferedImage);
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
Zoomm z;
MainInter(){
setTitle("Image zoom");
z=new Zoomm();
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
public class Zoom2{
public static void main(String args[]){
new MainInter();
}
}