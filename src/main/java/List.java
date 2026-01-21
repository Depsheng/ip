import java.util.*;

public class List {
    private static ArrayList<String> list =  new ArrayList<>();

    public static void add(String s){
        list.add(s);
    }

    public static void toPrint() {
        int len = list.size();
        System.out.println("____________________________________________________________");
        for (int i = 0; i < len ; i++) {
            String num = Integer.toString(i + 1);
            System.out.println(num + ". " + list.get(i));
        }
        System.out.println("____________________________________________________________");
    }

}
