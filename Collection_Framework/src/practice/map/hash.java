package practice.map;

import java.util.*;

public class hash {

    public static void main(String [] args){
        HashMap<Integer,String> employee = new HashMap<>();
        employee.put(200,"Manish");
        employee.put(300,"ranjeet");
        employee.put(400,"Nishu");
        employee.put(500,"komal");
        System.out.println(employee.get(200));
        System.out.println("is value 300 present : "+employee.containsKey(300));
        System.out.println("is manish contains : "+employee.containsValue("Manish"));
        Set<Integer> keys = employee.keySet();
        for(Integer key : keys){
            System.out.println(key+" : "+employee.get(key));
        }



    }
}
