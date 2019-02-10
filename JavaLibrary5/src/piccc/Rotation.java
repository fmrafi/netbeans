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
class Rotation1 extends Canvas implements ImageObserver{
Image img;
double radian=0.0;
Dimension ds;
Rotation1(){
 img=getToolkit().getImage("image03.jpg");
 ds=getToolkit().getScreenSize();
}
 public void paint(Graphics g){
rotateImage(g);
}
public void rotateImage(Graphics g){
 Graphics2D g2d=(Graphics2D)g;
 int iw=img.getWidth(this);
 int ih=img.getHeight(this);
 int mX=(int)ds.getWidth()/2;
 int mY=(int)ds.getHeight()/2;
 g2d.translate(mX,mY);
 g2d.rotate(radian);
 g2d.drawImage(img,-img.getWidth(this)/2,-img.getHeight(this)/2,iw,ih,this);
}
 public void rotateClockwise(){
radian+=Math.PI/2;
}
 public void rotateCounterClockwise(){
radian-=Math.PI/2;
}
}
 class Main extends JFrame implements ActionListener{
JButton btrotateClockwise;
JButton btrotateCounterClockwise;
JPanel panel;
Rotation r;
ImageIcon clockwiseIcon;
ImageIcon counterclockwiseIcon;
Main(){
r=new Rotation();
setTitle("Image Rotate Program");
clockwiseIcon=new ImageIcon("dir1.png");
btrotateClockwise=new JButton("",clockwiseIcon);
btrotateClockwise.setBackground(Color.BLACK);
btrotateClockwise.addActionListener(this);
counterclockwiseIcon=new ImageIcon("dir2.png");
btrotateCounterClockwise=new JButton("",counterclockwiseIcon);
btrotateCounterClockwise.setBackground(Color.BLACK);
btrotateCounterClockwise.setOpaque(true);
btrotateCounterClockwise.addActionListener(this);
panel=new JPanel();
panel.setLayout(new FlowLayout());
panel.add(btrotateClockwise);
panel.add(btrotateCounterClockwise);
//add(r,BorderLayout.CENTER );
add(panel, BorderLayout.SOUTH);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
setVisible(true);
}
 public void actionPerformed(ActionEvent e){
if(e.getSource()==btrotateClockwise)
{
r.rotateClockwise();
r.repaint();
}
else if(e.getSource()==btrotateCounterClockwise)
{
r.rotateCounterClockwise();
r.repaint();
}
}
}
public class Rotation{
public static void main(String args[]){
new Main();

}
    void rotateClockwise() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void repaint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void rotateCounterClockwise() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

