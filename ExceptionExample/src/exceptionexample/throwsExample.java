package exceptionexample;

import java.io.IOException;

class M {

    void method() throws IOException {
        throw new IOException("device error");
    }
}
public class throwsExample {
    public static void main(String args[]) throws IOException {//declare exception  
        M m = new M();
        m.method();
        System.out.println("normal flow...");
    }
}
