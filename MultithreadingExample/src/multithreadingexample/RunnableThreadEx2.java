package multithreadingexample;

class MyThread1 implements Runnable {

    public void run() {
        System.out.println(" this thread is running ... ");
    }
}
class RunnableThreadEx2 {

    public static void main(String[] args) {
        Thread t = new Thread(new MyThread1());
        t.start();
    }
}
