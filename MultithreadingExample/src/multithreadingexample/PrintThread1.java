/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadingexample;

public class PrintThread1 extends Thread { 
    String name; 
    public PrintThread1(String name) { 
        this.name = name; 
    } 
    public void run() {
        for (int i=1; i<100 ; i++) { 
            try { 
                sleep((long)(Math.random() * 100)); 
            } catch (InterruptedException ie) { } 	
            System.out.print(name); 
        }
} 

public static void main(String args[]) { 
        PrintThread1 a = new PrintThread1("*\n");
        PrintThread1 b = new PrintThread1("-");
        
        a.start(); 
        b.start();         
	}
}
