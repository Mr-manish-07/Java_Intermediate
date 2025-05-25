package Java8.practice.Lambdas;

//1. We required Functional Interface to use lambda expression
//2. We don't need to make a separate class to override the one abstract method which is in Inside Interface
//3. Lambdas will override the abstract method directly without defining seperate class
//4. Exp :-     InterfaceName objName = ()-> statement to be returned
//5. No return statement is required as well as no curly bracket is too.
//5. Fun fact :-    Functional Interface = lambdas exp



@FunctionalInterface
interface myFunction {
    String printData();
}


//      ---------------------------------------- Since lambda is used so this class is useless--------------------

//class myClass implements myFunction {
//    @Override
//    public String printData() {
//        return "Printing data from my class overriding my interface";
//    }
//}


public class Lambdas_Uses_With_Functional {
    public static void main(String[] args) {
        myFunction myObj  = ()-> "Printing data from my class overriding my interface";
        System.out.println(myObj.printData());
    }
}
