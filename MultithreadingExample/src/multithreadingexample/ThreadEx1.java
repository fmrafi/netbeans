package multithreadingexample;

import java.util.logging.Level;
import java.util.logging.Logger;

class MyThread extends Thread {

//    public void run() {
//        System.out.println(" this thread is running ... ");
//    }
    public void run(){  
  for(int i=1;i<5;i++){  
      try { 
          Thread.sleep(1000);
      } catch (InterruptedException ex) {
          Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
      }
    System.out.println(i);  
  } 
}
}

class ThreadEx1 {

    public static void main(String[] args) {
        MyThread t = new MyThread();
        //t.start();
         // t.start();
        t.run();
          t.run();
    }
}
