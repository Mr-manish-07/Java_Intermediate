package Java8.practice.Multiple_Inheritance;

interface  A {
    public default void dis(){
        System.out.println("Calling from A");
    }
    public static void done(){
        System.out.println("From Static Method");
    }
}

interface  B {
    public default void dis(){
        System.out.println("Calling from B");
    }
    public static void done(){
        System.out.println("From static method");
    }
}

class C implements A,B{
  @Override
  public void dis(){
        A.super.dis();
        B.super.dis();
  }

    public static void main(String[] args) {
            C c = new C();
            c.dis();
//            c.done();   --> This will throw error because static can't be
//                                be seen by child class due to Part of interface

    }

}



















public class Inheriting {
}
