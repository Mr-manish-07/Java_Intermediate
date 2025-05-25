package practice.Generics.basic;

@FunctionalInterface
interface printable {
    void print();
}

//  BOUNDED TYPE PARAMETER

public class ex4 extends Number implements Runnable {
    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public void run() {

    }
}

class AA<T extends Number & Runnable> {
    public void print() {
        System.out.println("print");
    }

    public static void main(String[] args) {
        AA<ex4> a = new AA<>();
        a.print();
    }
}

