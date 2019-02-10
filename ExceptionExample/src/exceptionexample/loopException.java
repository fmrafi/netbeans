
package exceptionexample;

public class loopException {
     public static void main(String[] args) {
         int i;
         try{
         for(i=2;i>1;i++){
         System.out.print(i);
          throw new ArithmeticException(); 
         }
         }
         catch(Exception e){
         System.out.println("catch exception ");
         }
     }
}
