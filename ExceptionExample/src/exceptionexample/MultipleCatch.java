package exceptionexample;

public class MultipleCatch {

    public static void main(String[] args) {
        try {
           int a[] = new int[5];
           a[5] = 30 / 0;
           try{
           int aa=25/0;
           
           }
           catch(ArithmeticException e){
           
           }
           
           }
        
//        catch (ArithmeticException e) {
//            System.out.println("task1 is completed==" + e);
//        }
//         catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("task 2 completed");}
        catch (Exception e) {
            System.out.println("common task completed=="+e);
        }

        System.out.println("rest of the code...");
    }
}
