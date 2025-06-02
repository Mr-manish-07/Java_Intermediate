package Java8.practice.Functional;

//-------------------------------------Uses of Functional Interface---------------------
//1. It should have 1 abstract method and can have multiple Static and default methods
//2. It is used to Invoke Lambdas Expression
//3. If parent having abstract method and child extending it,
//          so it is also consider as abstract
//          if we add another abstract method in child will throw error
//          due to 2 abstract 1 from self and 1 from parent
//4. In functional Interface we can write default methods multiple times




@FunctionalInterface
interface MyInterface{
    public void print();
    public default void defMeth(){
        System.out.println("Default method");
    }

}

@FunctionalInterface
interface ChildInterface extends MyInterface{
//    public void byy();    // This line throws error
}

class child implements MyInterface{
    @Override
    public void print() {
        System.out.println("Implementing Abstract Method");
    }
}

public class Function {
    public static void main(String[] args) {
        child child = new child();
        child.defMeth();
    }
}
