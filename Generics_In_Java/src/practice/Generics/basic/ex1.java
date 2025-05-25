package practice.Generics.basic;

class manish<E> {
    private E val;

    public E getVal() {
        return val;
    }

    public void setVal(E val) {
        this.val = val;
    }
}


public class ex1 {
    public static void main(String[] args) {
        manish<String> m = new manish<>();
//        m.setVal("hello");
        m.setVal("123");
        String i = m.getVal();
        System.out.println(i);
    }
}
