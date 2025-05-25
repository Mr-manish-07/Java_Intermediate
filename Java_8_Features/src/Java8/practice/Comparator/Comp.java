package Java8.practice.Comparator;
/*
1. Comparator is a functional interface , it has only one method .
2. The abstract method id " compare "
3. Compare takes two object, and it also returns a value
        if value is ( - ) : Current object comes before
        if value is ( 0 ) : No change
        if value is ( + ) : Then Current Obj Comes After
4.  Collection.sort(list)       : Default sorting ascending
    Collection.sort(list , Comparator<T> )  : Custom sorting





 */

import java.util.*;

//  Method No 1.

//class c1 implements Comparator<Integer>{
//    @Override
//    public int compare(Integer o1, Integer o2) {
//        return o2- o1;
//    }
//}

// This can be skipped by direct object is created in main class for comparator



class Myclass{

    public static void main(String[] args) {

        // Method No 2

//        Comparator<Integer> comparator = new Comparator<>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        };
        // Now this can be skipped by direct use of lambdas inside collection


        // Method No 3
        // Replace with lambdas expression
        Comparator<Integer> comparator2 = (Integer a, Integer b) -> b-a;

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(898);
        list.add(1);
        list.add(56);
        list.add(0);

//        Collections.sort(list,c1);
//        Collections.sort(list,comparator);
//        Collections.sort(list,comparator2);

        // Direct use of Compare method From Comparator inside Collection.sort()
        Collections.sort(list, (o1, o2) -> 0);

        System.out.println(list);


    }
}





























public class Comp {
}
