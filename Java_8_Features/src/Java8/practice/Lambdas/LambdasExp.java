package Java8.practice.Lambdas;
//---------------------------Process to write lambdas--------------------------------
// 1. Remove access modifier (public , private , protected)
// 2. Remove the name of the function (print , add , sum , printAge...)
// 3. If there is a single statement to return just remove curly bracket {}
// 4. No return type is required
// 5. No data type is required when taking arguments (--compiler automatic detect the type of data--)
// 6. Just remove return keyword if there is only single item to be returned (return a+b)

//---------------------------Benefits of lambdas Exp------------------------
//1. To Enable Functional Programming
//2. To make code more concise and increase readability
//3. To enable parallel processing
//4. JAR file size reduction
//5. Elimination of shadow Variable



public class LambdasExp {
    public void printData(){
        System.out.println("Data is Printing");
    }
//    ()->System.out.println("Data is printing"); // Required Functional interface to run lambdas

    public int sum(int a , int b){
        return a+b;
    }
//    (a,b)->return a+b;  // Required Functional interface to run lambdas


    public static void main(String[] args) {

    }
}
