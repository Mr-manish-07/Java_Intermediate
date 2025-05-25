package practice.Generics.basic;
class A<K,V>{
    private K key;
    private V val;
    public A(K key, V val) {
        this.key = key;
        this.val = val;
    }
    public K getKey() {
        return key;
    }
    public V getVal() {
        return val;
    }
}


public class ex2 {
    public static void main(String[] args) {
        A<String  , Integer> a = new A<>("User Id ",3434);
        System.out.println(a.getKey());
        System.out.println(a.getVal());
    }
}
