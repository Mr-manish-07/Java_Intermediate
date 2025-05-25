import java.util.ArrayList;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("123");
        list.add("3.44");
        String o = list.get(0);
        String string = list.get(1);
        System.out.println(o + string);

    }
}