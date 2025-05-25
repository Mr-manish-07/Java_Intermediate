package practice.Generics.basic;



public interface ex3 <T>{
    void print();
    T getVal();
}
class C<T extends Number> implements ex3 <T>{ // <T> or <T extends Number>of c will be spreaded everywhere in interface , inherited class
    T s;
    @Override
    public void print() {
        System.out.println("print");
    }
    public void setVal(T val) {
        this.s = val;
    }

    public T getVal() {
        return s;
    }

    public static void main(String[] args) {
        C<Integer> c=new C<>();
        c.print();
        c.setVal(332);
        System.out.println(c.getVal());
    }
}
