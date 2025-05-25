package Java8.practice.Lambdas;

/*
1. If there is any interface we can directly make their object into main method
2. And also we can override abstract method of interface directly into main method
3. By doing this we can skip creation of class and memory can be saved.
4. Syntax : InterfaceName obj = new InterfaceName() {
            @Override
            public void abstract1(){};
            @Override
            public void abstract2(){};
            };
5. If there is only one Abstract method then replace it with lambdas else keep as it is.
6. Suppose there is single method Called Run in Runnable
7. The syntax is :  Runnable runnable = () -> print("Run method is running");
        Since this returns nothing so we are printing.

------------------------- THREAD -----------------------------
1. To create a thread we use Runnable interface.
2. The working of thread to execute code as we pass obj in thread
3. Syntax : Thread t = new Thread (runnable);
4. When we do thread.run(); it just calls run method from Runnable
5. When we do thread.start(); a new Thread is made by os and run concurrently with main method
6. Sometimes it seems that main is executing first then thread but not abjectly.
7. Because of   //Allocate memory for the new thread
                //Inform the OS
                //Start a new call stack
                //Schedule it
8. But we can say main method to wait for it, so they both can run concurrently \
                by using Thread.sleep(time(in ns):1); so it will wait for 1ns

 */




class main2 {
    public static void main(String[] args) {
//        Runnable runnable = ()-> System.out.println("Running"); // for single statement
        Runnable runnable = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Run method is running " + i + " times");
            }
        };

        Thread thread = new Thread(runnable); // Supports Method overloading
        thread.start();

        for(int i = 0; i<10; i++){
            System.out.println("Main thread");
            // Waiting for 2ns for loading thread class
            try { Thread.sleep(2); } catch (InterruptedException _) {}

        }
    }
}

//class Myclass implements Runnable {
//    @Override
//    public void run() {
//        for (int i = 1; i <= 10; i++) {
//            System.out.println("Run method is running " + i + " times");
//        }
//    }
//}

//interface Runnable2 {
//    void run();
//
//    void notRun();
//}

//class main{
//    public static void main(String[] args) {
//        Myclass myclass = new Myclass();
//        myclass.run();
//    }
//}

//class main3 {
//    Runnable2 runnable2 = new Runnable2() {
//        @Override
//        public void run() {
//
//        }
//
//        @Override
//        public void notRun() {
//
//        }
//    };
//}

public class Runnable_With_Lambdas {
}
