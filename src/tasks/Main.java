package tasks;


import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        try{
//            try{
//                throw new MyTestException("error!");
//            } catch (RuntimeException e){
//                System.out.println("catched");
//            }
//
//            if (true)throw new IllegalAccessException();
//             System.out.println("down");
//        } catch (Exception e){
//            System.out.println("exception");
//        }

//        try{
//            System.out.println("try");
//        }catch (MyTestException1 e){
//        } catch (MyTestException e){
//
//        }


    }

//    static class MyTestException extends RuntimeException {
//        public MyTestException(String message) {
//            super(message);
//        }
//    }
//
//    static class MyTestException1 extends MyTestException {
//        public MyTestException1(String message) {
//            super(message);
//        }
//    }

   static class A{
        public void f() throws IOException {} }
   static class B extends A{
       public void f() {}
   }
}
