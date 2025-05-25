package Java8.practice.Predicate;
/*
1. Predicate is a functional interface having one abstract method "test" whose return type is boolean.
2. So lambdas can be use to implement it.
3. It can be used for any testing purpose (as is name starts with "s" or not , is his salary is more than "10k" or not).

4. There are some default method.
5. "and" checks two predicate (both predicate should true to get true). predicate.and.test()
6. "or" checks two predicate (any one is true then true). predicate.or.test()
7. "negate" it reverse the condition , predicate.negate.test();

8. There are some static method.
9.


 */


import java.util.Scanner;
import java.util.function.Predicate;

public class Myclass {
    public static void main(String[] args) {
        Predicate<Integer> predicate = a -> a > 1000;
        System.out.println(predicate.test(1001));

        Predicate<Integer> predicate1 = b -> b % 2 == 0;
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println("Given Number is " + (predicate1.test(input)?"Even":"Odd"));

        Predicate<String> firstLetterChecker = a -> a.toLowerCase().charAt(0) == 'm';
        System.out.println("For Manish "+firstLetterChecker.test("Manish"));
        System.out.println("For Amit "+firstLetterChecker.test("Amit"));
    }
}
