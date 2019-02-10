/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionexample;

import java.io.IOException;

class M1 {
    void method() throws IOException  {
        throw new IOException("device error");
    }   }
public class throwsExample1 {
    public static void main(String args[]) {
        try {
            M1 m = new M1();
            m.method();          }
 catch (Exception e) {
            System.out.println("exception handled");
        }
        System.out.println("normal flow...");
    }   }

